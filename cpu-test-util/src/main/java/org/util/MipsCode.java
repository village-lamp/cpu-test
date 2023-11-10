package org.util;

public class MipsCode {

    public static String getReg(int reg) {
        return getByInt(reg, 5);
    }

    public static String getImm16(int imm) {
        imm &= 0xffff;
        return getByInt(imm, 16);
    }

    public static String getImm26(int imm) {
        imm &= 0x3ffffff;
        return getByInt(imm, 26);
    }

    public static String getByInt(int val, int bits) {
        StringBuilder str = new StringBuilder();
        for (int i = bits - 1; i >= 0; --i) {
            str.append(((val / (1 << i)) % 2 == 0) ? '0' : '1');
        }
        return str.toString();
    }
}
