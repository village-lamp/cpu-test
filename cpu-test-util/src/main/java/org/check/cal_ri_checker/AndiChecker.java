package org.check.cal_ri_checker;

/**
 * andi验证类
 */
public class AndiChecker extends CalRiChecker {

    @Override
    public long calc(long rsVal, long imm) {
        return rsVal & imm;
    }
}
