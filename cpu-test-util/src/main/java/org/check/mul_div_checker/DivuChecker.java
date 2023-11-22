package org.check.mul_div_checker;

/**
 * divu验证类
 */
public class DivuChecker extends MulDivChecker {

    @Override
    public long[] calc(long rsVal, long rtVal) {
        long[] outs = new long[2];
        if (rtVal == 0) {
            return null;
        }
        outs[0] = rsVal % rtVal;
        outs[1] = rsVal / rtVal;
        return outs;
    }
}
