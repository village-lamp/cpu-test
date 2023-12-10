package org.check.cal_ri_checker;

import org.util.UnsignedInt;

/**
 * ori验证类
 */
public class OriChecker extends CalRiChecker {

    @Override
    public Long calc(long rsVal, long imm) {
        return UnsignedInt.extend(rsVal | imm);
    }
}
