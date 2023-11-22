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
    public long calc(long rsVal, long rtVal) {
        return rsVal - rtVal;
    }
}
