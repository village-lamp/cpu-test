package org;

import org.check.Check;
import org.check.CheckFactory;
import org.constant.CommonConstant;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * mips类，模拟cpu行为
 */
public class Mips implements CommonConstant, Cloneable {

    //寄存器堆
    private long[] regs;
    //当前pc值
    private int pc;
    //该cpu中的代码段
    private final HashMap<Integer, String> codeStr;
    //十六进制代码
    private final HashMap<Integer, String> code;
    //数据段
    private HashMap<Integer, Long> dm;
    //当前空白块所属指令
    private String block;
    //空白块所属指令的下一条指令pc
    private int blockPc;

    public Mips(long[] regs, int pc, HashMap<Integer, String> codeStr,
                HashMap<Integer, Long> dm, HashMap<Integer, String> code) {
        this.regs = regs;
        this.pc = pc;
        this.codeStr = codeStr;
        this.dm = dm;
        block = null;
        this.code = code;
    }

    public Mips() {
        this.regs = new long[32];
        for (int i = 1; i <= 31; i++) {
            regs[i] = 0;
        }
        this.pc = PC_BEGIN;
        this.codeStr = new HashMap<>();
        this.dm = new HashMap<>();
        block = null;
        this.code = new HashMap<>();
    }

    /**
     * 运行cpu
     * @param pcEnd 当pc与pcEnd相等时停止，用于判定是否循环
     * @return 运行结果
     */
    public ArrayList<String> run(int pcEnd) {
        ArrayList<String> out = new ArrayList<>();
        do {
            String str = check();
            if (check() != null) {
                return null;
            }
            out.add(str);
        } while (pc <= PC_END && pc != pcEnd);
        return out;
    }

    public String check() {
        CheckFactory checkFactory = new CheckFactory();
        String line = code.get(pc);
        if (line == null) {
            return null;
        }
        Check check = checkFactory.create(Check.analyse(line));
        return check.generate(line);
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

    public void putCodeStr(String code) {
        this.codeStr.put(pc, code);
    }

    public void putCode(String code) {
        this.code.put(pc, code);
    }

    public long getReg(int base) {
        return (base == 0) ? 0 : regs[base];
    }

    public HashMap<Integer, Long> getDm() {
        return dm;
    }

    public void setDm(HashMap<Integer, Long> dm) {
        this.dm = dm;
    }

    public void setDm(int addr, long val) {
        dm.put(addr, val);
    }

    public long[] getRegs() {
        return regs;
    }

    public void setRegs(long[] regs) {
        this.regs = regs;
    }

    public void setReg(int reg, long val) {
        regs[reg] = val;
    }

    public String getBlock() {
        return block;
    }

    public int getBlockPc() {
        return blockPc;
    }

    public void setBlock(String type, int val) {
        block = type;
        blockPc = val;
    }

    public HashMap<Integer, String> getCodeStr() {
        return codeStr;
    }

    @Override
    public Mips clone() {
        try {
            Mips clone = (Mips) super.clone();
            clone.setDm(new HashMap<>(dm));
            return clone;
        } catch (Exception e) {
            return null;
        }
    }
}