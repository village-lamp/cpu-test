package org.check.cal_ri_checker;

import org.util.UnsignedInt;

/**
 * andi验证类
 */
public class AndiChecker extends CalRiChecker {

    @Override
    public Long calc(long rsVal, long imm) {
        long data = rsVal & imm;
        if (data == 0L) {
            return null;
        }
        return UnsignedInt.extend(data);
    }
}
