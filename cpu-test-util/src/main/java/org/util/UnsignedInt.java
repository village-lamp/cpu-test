package org.util;

/**
 * 无符号整型工具类
 * 使用长整型表示
 */
public class UnsignedInt {

    /**
     * 将hi和lo转为无符号整型
     * @param hi 高16位
     * @param lo 低16位
     * @return 无符号整型
     */
    public static long toUnsignedInt(int hi, int lo) {
        long val = (((long) hi) << 16) + lo;
        return over(val);
    }

    /**
     * 将长整型转为无符号整型
     * @param val 长整型
     * @return 无符号整型
     */
    public static long over(long val) {
        return (val + 0x100000000L) % 0x100000000L;
    }

    /**
     * 将无符号转为有符号
     * @param val 无符号数
     * @return 有符号数
     */
    public static long signed(long val) {
        if ((val & 0x80000000L) != 0L) {
            return -over(~val + 1);
        }
        return val;
    }
}
