package org.check.cal_rr_checker;

/**
 * and验证类
 */
public class AndChecker extends CalRrChecker {

    @Override
    public long calc(long rsVal, long rtVal) {
        return rsVal & rtVal;
    }
}
