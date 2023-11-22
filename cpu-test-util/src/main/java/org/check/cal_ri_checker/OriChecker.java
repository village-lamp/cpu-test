package org.check.cal_ri_checker;

import org.Mips;
import org.check.Checker;
import org.util.Hex;
import org.util.UnsignedInt;

/**
 * ori验证类
 */
public class OriChecker extends CalRiChecker {

    @Override
    public long calc(long rsVal, long imm) {
        return rsVal | imm;
    }
}
