package org.check.cal_ri_checker;

/**
 * ori验证类
 */
public class OriChecker extends CalRiChecker {

    @Override
    public Long calc(long rsVal, long imm) {
        return rsVal | imm;
    }
}
