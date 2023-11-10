package org.util;

public class UnsignedInt {

    public static long toUnsignedInt(int hi, int lo) {
        long val = (((long) hi) << 16) + lo;
        return over(val);
    }

    public static long over(long val) {
        return (val + 0x100000000L) % 0x100000000L;
    }
}
