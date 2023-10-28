package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class Generator {
    private static int now = 31;
    private static int nowImm;
    private static int pc = 0x3000;

    private static final int ban = randInt(1, 31);

    public long long2UnsignedInt(long val) {
        return val % 0xffffffffL;
    }

    public abstract void generate(FileOutputStream o) throws IOException;
    public static int randInt(int l, int r) {
        Random random = new Random();
        return random.nextInt(r - l + 1) + l;
    }

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
