package org.check.cal_rr_checker;

import org.Mips;
import org.check.Checker;
import org.util.Hex;
import org.util.UnsignedInt;

/**
 * sub验证类
 */
public class SubChecker extends CalRrChecker {

    @Override
    public Long calc(long rsVal, long rtVal) {
        long data = rsVal - rtVal;
        if (data == 0L) {
            return null;
        }
        return data;
    }
}
