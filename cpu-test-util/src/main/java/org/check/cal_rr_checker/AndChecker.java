package org.check.cal_rr_checker;

import org.util.UnsignedInt;

/**
 * and验证类
 */
public class AndChecker extends CalRrChecker {

    @Override
    public Long calc(long rsVal, long rtVal) {
        long data = rsVal & rtVal;
        if (data == 0L) {
            return null;
        }
        return UnsignedInt.extend(data);
    }
}
