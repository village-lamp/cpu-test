package org.check.mul_div_checker;

/**
 * multu验证类
 */
public class MultuChecker extends MulDivChecker {

    @Override
    public long[] calc(long rsVal, long rtVal) {
        long out = rsVal * rtVal;
        long[] outs = new long[2];
        outs[0] = (out >> 32) & 0xffffffffL;
        outs[1] = out & 0xffffffffL;
        return outs;
    }
}
