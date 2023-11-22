package org.check.mul_div_checker;

import org.util.UnsignedInt;

/**
 * div验证类
 */
public class DivChecker extends MulDivChecker {

    @Override
    public long[] calc(long rsVal, long rtVal) {
        rsVal = UnsignedInt.signed(rsVal);
        rtVal = UnsignedInt.signed(rtVal);
        if (rtVal == 0) {
            return null;
        }
        long[] outs = new long[2];
        outs[0] = rsVal % rtVal;
        outs[1] = rsVal / rtVal;
        return outs;
    }
}
