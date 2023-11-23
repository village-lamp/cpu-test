package org.check.cal_rr_checker;

/**
 * or验证抽象类
 */
public class OrChecker extends CalRrChecker {

    @Override
    public Long calc(long rsVal, long rtVal) {
        return rsVal | rtVal;
    }
}
