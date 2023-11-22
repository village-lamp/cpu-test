package org.check.mul_div_checker;

import org.util.UnsignedInt;

/**
 * mult验证类
 */
public class MultChecker extends MulDivChecker {

    @Override
    public long[] calc(long rsVal, long rtVal) {
        rsVal = UnsignedInt.signed(rsVal);
        rtVal = UnsignedInt.signed(rtVal);
        long out = rsVal * rtVal;
        long[] outs = new long[2];
        outs[0] = (out >> 32) & 0xffffffffL;
        outs[1] = out & 0xffffffffL;
        return outs;
    }
}
