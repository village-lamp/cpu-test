package org.check.cal_ri_checker;

import org.util.UnsignedInt;

/**
 * addi验证类
 */
public class AddiChecker extends CalRiChecker {

    @Override
    public Long calc(long rsVal, long imm) {
        if ((imm & 0x8000) != 0) {
            imm = (~imm + 1) & 0xffff;
            imm = -imm;
        }
        return UnsignedInt.extend(rsVal) + UnsignedInt.extend(imm);
    }
}
