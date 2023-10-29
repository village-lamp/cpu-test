package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 生成器抽象类
 */
public abstract class Generator {
    //用于停止随机
    private static int now = 31;
    private static int nowImm;
    //记录pc值
    private static int pc = 0x3000;
    //固定一个不会使用的寄存器，用于beq指令生成
    private static final int ban = randInt(1, 31);

    public abstract void generate(FileOutputStream o) throws IOException;

    /**
     * 在一定范围内生成随机的整数
     * @param l 左边界（取）
     * @param r 右边界（取）
     * @return 生成的整数
     */
    public static int randInt(int l, int r) {
        Random random = new Random();
        return random.nextInt(r - l + 1) + l;
    }

    /**
     * 生成随机的寄存器编号
     * @return 寄存器编号
     */
    public int randReg() {
        int reg;
        if (now > 0) {
            reg = now;
        }
        else {
            reg = randInt(0, 31);
            reg += (ban == reg)? 1 : 0;
            reg = (reg >= 32)? 0 : reg;
        }
        return reg;
    }

    /**
     * 生成16位立即数
     * @return 立即数
     */
    public int randImm() {
        int imm;
        if (now > 0) {
            imm = nowImm;
        }
        else {
            imm = randInt(-32768, 32767);
        }
        return imm;
    }

    public int getBan() {
        return ban;
    }

    public static int getPc() {
        return pc;
    }
    public static void setNowImm(int imm) {
        nowImm = imm;
    }

    public static void setNow(int nNow) {
        now = nNow;
    }

    public void setPc(int npc) {
        pc = npc;
    }
}
