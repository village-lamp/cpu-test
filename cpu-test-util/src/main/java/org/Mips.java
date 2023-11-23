package org;

import org.check.Checker;
import org.check.CheckFactory;
import org.constant.CommonConstant;
import org.constant.RegConstant;
import org.util.Hex;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * mips类，模拟cpu行为
 */
public class Mips implements CommonConstant, Cloneable, RegConstant {

    //寄存器堆，0-31为通用寄存器，32为hi，33为lo
    private long[] regs;
    //当前pc值
    private int pc;
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

    public Mips(long[] regs, int pc, HashMap<Integer, String> codeStr,
                HashMap<Integer, Long> dm, HashMap<Integer, String> code) {
        this.regs = regs;
        this.pc = pc;
        this.codeStr = codeStr;
        this.dm = dm;
        block = null;
        this.code = code;
        error = false;
        generate = false;
    }

    public Mips() {
        this.regs = new long[34];
        for (int i = 1; i <= 31; i++) {
            regs[i] = 0;
        }
        this.pc = PC_BEGIN;
        this.codeStr = new HashMap<>();
        this.dm = new HashMap<>();
        block = null;
        this.code = new HashMap<>();
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
        while (pc <= PC_END && pc != pcEnd) {
            if (pc == 0x3198) {
                int j = 0;
            }
            ++times;
            String str = check();
            //返回"none"代表没有指令
            if ("none".equals(str)) {
                return out;
            }
            out.add(str);
            //返回"null"代表运行错误
            if (maxTimes <= times || "null".equals(str)) {
                error = true;
                return null;
            }
        }
        return out;
    }

    /**
     * 运行单条指令
     * @return 运行结果
     */
    public String check() {
        CheckFactory checkFactory = new CheckFactory();
        String line = code.get(pc);
        if (line == null) {
            return "none";
        }
        Checker checker = checkFactory.create(Checker.analyse(line));
        return checker.check(line, this);
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
            long[] nRegs = new long[34];
            System.arraycopy(regs, 0, nRegs, 0, 34);
            clone.setRegs(nRegs);
            return clone;
        } catch (Exception e) {
            return null;
        }
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
}