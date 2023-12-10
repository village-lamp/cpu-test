package org.check.cal_rr_checker;

import org.util.UnsignedInt;

/**
 * sub验证类
 */
public class SubChecker extends CalRrChecker {

    @Override
    public Long calc(long rsVal, long rtVal) {
        long data = UnsignedInt.extend(rsVal) - UnsignedInt.extend(rtVal);
        if (data == 0L) {
            return null;
        }
        return data & 0x1ffffffffL;
    }
}
