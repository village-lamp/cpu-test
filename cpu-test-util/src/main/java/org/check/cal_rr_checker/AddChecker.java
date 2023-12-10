package org.check.cal_rr_checker;

import org.util.UnsignedInt;

/**
 * add验证类
 */
public class AddChecker extends CalRrChecker {

    @Override
    public Long calc(long rsVal, long rtVal) {
        return UnsignedInt.extend(rsVal) + UnsignedInt.extend(rtVal);
    }
}
