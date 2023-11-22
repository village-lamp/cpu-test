package org.check.cal_rr_checker;

/**
 * add验证类
 */
public class AddChecker extends CalRrChecker {

    @Override
    public long calc(long rsVal, long rtVal) {
        return rsVal + rtVal;
    }
}
