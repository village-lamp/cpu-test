package org.check.cal_rr_checker;

import org.util.UnsignedInt;

/**
 * slt验证类
 */
public class SltChecker extends CalRrChecker {

    @Override
    public long calc(long rsVal, long rtVal) {
        long rsValue = UnsignedInt.signed(rsVal);
        long rtValue = UnsignedInt.signed(rtVal);
        if (rsValue < rtValue) {
            return 1L;
        }
        return 0L;
    }
}
