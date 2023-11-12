package org.util;

/**
 * 二进制译码工具类
 */
public class MipsCode {

    /**
     * 将寄存器编号转为二进制串
     * @param reg 寄存器编号
     * @return 二进制串
     */
    public static String getReg(int reg) {
        return getByInt(reg, 5);
    }

    /**
     * 将16为立即数转为二进制串
     * @param imm 16位立即数
     * @return 二进制串
     */
    public static String getImm16(int imm) {
        imm &= 0xffff;
        return getByInt(imm, 16);
    }

    /**
     * 将26位立即数转为二进制串
     * @param imm 26位立即数
     * @return 二进制串
     */
    public static String getImm26(int imm) {
        imm &= 0x3ffffff;
        return getByInt(imm, 26);
    }

    /**
     * 将整数转为二进制串
     * @param val 数值
     * @param bits 位宽
     * @return 二进制串
     */
    public static String getByInt(int val, int bits) {
        StringBuilder str = new StringBuilder();
        for (int i = bits - 1; i >= 0; --i) {
            str.append(((val / (1 << i)) % 2 == 0) ? '0' : '1');
        }
        return str.toString();
    }
}
