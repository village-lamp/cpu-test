package org.mips;

import org.check.Checker;
import org.check.CheckFactory;
import org.constant.CommonConstant;
import org.constant.RegConstant;
import org.util.Hex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mips类，模拟cpu行为
 */
public class Mips implements CommonConstant, Cloneable, RegConstant {

    //寄存器堆，0-31为通用寄存器，32为hi，33为lo
    private long[] regs;
    //当前pc值
    private int pc;
    //前一条指令的pc值
    private int lastPc;
    //该cpu中的代码段
    private final HashMap<Integer, String> codeStr;
    //十六进制代码
    private HashMap<Integer, String> code;
    //数据段
    private HashMap<Integer, Long> dm;
    //当前空白块所属指令
    private String block;
    //空白块所属指令的下一条指令pc
    private int blockPc;
    //运行出错标识
    private boolean error;
    //是否是生成时使用的mips
    private boolean generate;
    //协处理器
    private Cp0 cp0;
    //Tc0计数器
    private Tc tc0;
    //Tc1计数器
    private Tc tc1;
    //中断发生器中断位置集合
    private ArrayList<Integer> interrupts;
    //是否为延迟槽
    private boolean isDelaySlot;

    public Mips(long[] regs, int pc, HashMap<Integer, String> codeStr,
                HashMap<Integer, Long> dm, HashMap<Integer, String> code,
                Cp0 cp0, Tc tc0, Tc tc1, ArrayList<Integer> interrupts) {
        this.regs = regs;
        this.pc = pc;
        this.codeStr = codeStr;
        this.dm = dm;
        this.code = code;
        this.cp0 = cp0;
        this.tc0 = tc0;
        this.tc1 = tc1;
        this.interrupts = interrupts;
        this.lastPc = pc;
        error = false;
        generate = false;
        block = null;
    }

    public Mips() {
        this.regs = new long[34];
        for (int i = 1; i <= 31; i++) {
            regs[i] = 0;
        }
        cp0 = new Cp0();
        tc0 = new Tc();
        tc1 = new Tc();
        codeStr = new HashMap<>();
        dm = new HashMap<>();
        code = new HashMap<>();
        interrupts = new ArrayList<>();
        pc = PC_BEGIN;
        lastPc = PC_BEGIN;
        block = null;
        error = false;
        generate = false;
    }

    /**
     * 运行cpu
     * @param pcEnd 当pc与pcEnd相等时停止，用于判定是否循环
     * @param maxTimes 最大运行时间
     * @return 运行结果
     */
    public ArrayList<String> run(int pcEnd, int maxTimes) {
        ArrayList<String> out = new ArrayList<>();
        int times = 0;
        while (pc <= PC_END) {

            if (pc == 0x300c) {
                int j = 0;
            }

            ++times;
            ArrayList<String> checkOut = check();

            //返回"none"代表没有指令
            if ("none".equals(checkOut.get(0))) {
                return out;
            }
            out.addAll(checkOut);
            //返回"null"代表运行错误
            if (maxTimes <= times || "null".equals(checkOut.get(0))) {
                error = true;
                return null;
            } else {
                if (checkOut.size() > 1) {
                    if ("null".equals(checkOut.get(1))) {
                        error = true;
                        return null;
                    }
                }
            }
        }
        return out;
    }

    /**
     * 运行单条指令
     * @return 运行结果
     */
    public ArrayList<String> check() {
        CheckFactory checkFactory = new CheckFactory();
        String line = code.get(pc);
        if (line == null) {
            return new ArrayList<>(Collections.singletonList("none"));
        }
        Checker checker = checkFactory.create(Checker.analyse(line));
        ArrayList<String> outs = new ArrayList<>();

        int _int;
        if (cp0.getIe() == 0 || cp0.getExl() == 1) {
            _int = 0;
        } else {
            _int = checkInt();
        }
        _int &= cp0.getIm();
        if ((_int & 0b100) != 0) {
            if (isMulDiv(pc)) {
                outs.add(checker.check(line, this));
                pc -= 4;
            }
            outs.addAll(runExcInt(0, pc, (isBD(lastPc)) ? pc - 4 : pc));
            return outs;
        }

        int lpc = pc;
        String out = checker.check(line, this);
        outs.add(out);

        if (isBD(lpc)) {
            int tpc = pc;
            if (pc != lpc + 4) {
                outs.addAll(runDelaySlot(lpc));
                if (outs.size() <= 2) {
                    pc = tpc;
                }
            } else {
                lastPc = lpc;
            }
        }

        int ret = checkExc(out);
        if (ret != 0) {
            if ((_int & 0b1) != 0 || (_int & 0b10) != 0) {
                return new ArrayList<>(Collections.singleton("null"));
            }
            return runExcInt(ret, pc, (isBD(lastPc)) ? pc - 4 : pc);
        }

        tc0.check(pc);
        tc1.check(pc);

        checkCp0();
        lastPc = (isBD(lpc)) ? lastPc : lpc;
        return outs;
    }

    /**
     * 运行延迟槽
     * @return 结果
     */
    public ArrayList<String> runDelaySlot(int pc) {
        isDelaySlot = true;
        lastPc = pc;
        this.pc = pc + 4;
        ArrayList<String> out = check();
        isDelaySlot = false;
        return out;
    }

    /**
     * 清除延迟槽
     */
    public void removeDelaySlot() {
        codeStr.put(pc + 4, null);
        code.put(pc + 4, null);
    }

    /**
     * pc对应指令是否为跳转指令
     * @param pc pc值
     * @return 是否为跳转
     */
    public boolean isBD(int pc) {
        String line = code.get(pc);
        if (line == null) {
            return false;
        }
        String instr = Checker.analyse(line);
        return "beq".equals(instr) || "jal".equals(instr) ||
                "jr".equals(instr) || "bne".equals(instr);
    }

    /**
     * pc对应指令是否为乘除指令
     * @param pc pc值
     * @return 是否为乘除指令
     */
    public boolean isMulDiv(int pc) {
        String line = code.get(pc);
        if (line == null) {
            return false;
        }
        String instr = Checker.analyse(line);
        return "multu".equals(instr) || "mult".equals(instr) ||
                "divu".equals(instr) || "div".equals(instr) ||
                "mthi".equals(instr) || "mtlo".equals(instr);
    }

    /**
     * 检验是否发生异常
     * @param out 异常输出
     * @return 异常码
     */
    public int checkExc(String out) {
        if (out == null) {
            return 0;
        }
        Pattern pattern = Pattern.compile("ExcCode:(\\d*)");
        Matcher matcher = pattern.matcher(out);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    /**
     * 运行异常处理程序
     * @param excCode 异常码
     * @param vpc 受害指令
     * @param epc 异常指令
     * @return 结果
     */
    public ArrayList<String> runExcInt(int excCode, int vpc, int epc) {
        cp0.setEpc(epc);
        cp0.setExcCode(excCode);
        cp0.setBd((vpc == epc) ? 0 : 1);
        cp0.setExl(1);
        checkCp0();
        pc = EXC_INT_BEGIN;
        ArrayList<String> out = new ArrayList<>();
        while (true) {
            ArrayList<String> checkOut = check();
            if (pc < EXC_INT_BEGIN || "none".equals(checkOut.get(0))) {
                return out;
            }
            out.addAll(checkOut);
        }
    }

    /**
     * 进行一周期cp0
     */
    public void checkCp0() {
        cp0.setIp(checkInt());
    }

    /**
     * 检测中断信号
     * @return 中断值
     */
    public int checkInt() {
        int _int = 0;
        if (tc0.isStart()) {
            _int |= 0b1;
        }
        if (tc1.isStart()) {
            _int |= 0b10;
        }
        if (interrupts.contains(pc)) {
            _int |= 0b100;
        }
        return _int;
    }

    /**
     * 通过地址得到命中硬件名称
     * @param addr 地址
     * @return 硬件名
     */
    public static String hitHardware(long addr) {
        if (addr <= DM_END) {
            return "DM";
        }
        if (addr >= TC0_BEGIN && addr <= TC0_END) {
            return "TC0";
        }
        if (addr >= TC1_BEGIN && addr <= TC1_END) {
            return "TC1";
        }
        if (addr >= IG_BEGIN && addr <= IG_END) {
            return "IG";
        }
        return "none";
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int npc) {
        pc = npc;
    }

    public void addPc(int addVal) {
        pc += addVal;
    }

    public void setCode(HashMap<Integer, String> code) {
        this.code = code;
    }

    public void putCode(String code) {
        this.code.put(pc, Hex.toHex(code).toString());
    }

    public void putCodeStr(String code) {
        this.codeStr.put(pc, code);
    }

    public HashMap<Integer, String> getCode() {
        return code;
    }

    public HashMap<Integer, String> getCodeStr() {
        return codeStr;
    }

    public void setReg(int reg, long val) {
        regs[reg] = val;
    }

    public void setRegs(long[] regs) {
        this.regs = regs;
    }

    public long getReg(int base) {
        return (base == 0) ? 0 : regs[base];
    }

    public long[] getRegs() {
        return regs;
    }

    public void setDm(HashMap<Integer, Long> dm) {
        this.dm = dm;
    }

    public HashMap<Integer, Long> getDm() {
        return dm;
    }

    public void setBlock(String type, int val) {
        block = type;
        blockPc = val;
    }

    public String getBlock() {
        return block;
    }

    public int getBlockPc() {
        return blockPc;
    }

    /**
     * 深克隆
     * @return 克隆对象
     */
    @Override
    public Mips clone() {
        try {
            Mips clone = (Mips) super.clone();
            clone.setDm(new HashMap<>(dm));
            clone.setCp0(cp0.clone());
            long[] nRegs = new long[34];
            System.arraycopy(regs, 0, nRegs, 0, 34);
            clone.setRegs(nRegs);
            clone.setTc0(tc0);
            clone.setTc1(tc1);
            return clone;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 拷贝mips
     * @param mips mips
     */
    public void cpy(Mips mips) {
        setDm(mips.getDm());
        setRegs(mips.getRegs());
        setCp0(mips.getCp0());
        setTc0(mips.getTc0());
        setTc1(mips.getTc1());
    }

    /**
     * 向寄存器堆中写值
     * @param pc 当前pc值
     * @param target 目标寄存器
     * @param data 数值
     * @return 输出结果
     */
    public String writeToGrf(long pc, int target, long data) {
        if (target == 0) {
            return null;
        }
        regs[target] = data;
        return String.format("@%s: $%2d <= %s\n", Hex.toHex(pc),
                target, Hex.toHex(data));
    }

    /**
     * 向dm中写值
     * @param pc 当前pc值
     * @param addr 地址
     * @param data 数值
     * @return 输出结果
     */
    public String writeToDm(long pc, int addr, long data) {
        dm.put(addr, data);
        return String.format("@%s: *%s <= %s\n", Hex.toHex(pc),
                Hex.toHex(addr), Hex.toHex(data));
    }

    public boolean isError() {
        return error;
    }

    public boolean isGenerate() {
        return generate;
    }

    public void setGenerate(boolean flag) {
        generate = flag;
    }

    public Cp0 getCp0() {
        return cp0;
    }

    public void setCp0(Cp0 cp0) {
        this.cp0 = cp0;
    }

    public Tc getTc0() {
        return tc0;
    }

    public void setTc0(Tc tc0) {
        this.tc0 = tc0;
    }

    public Tc getTc1() {
        return tc1;
    }

    public void setTc1(Tc tc1) {
        this.tc1 = tc1;
    }

    public boolean isDelaySlot() {
        return isDelaySlot;
    }

    public void setDelaySlot(boolean delaySlot) {
        isDelaySlot = delaySlot;
    }

    public ArrayList<Integer> getInterrupts() {
        return interrupts;
    }

    public void setInterrupts(ArrayList<Integer> interrupts) {
        this.interrupts = interrupts;
    }
}