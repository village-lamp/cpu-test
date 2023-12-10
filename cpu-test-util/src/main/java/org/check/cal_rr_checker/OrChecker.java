package org.check.cal_rr_checker;

import org.util.UnsignedInt;

/**
 * or验证抽象类
 */
public class OrChecker extends CalRrChecker {

    @Override
    public Long calc(long rsVal, long rtVal) {
        return UnsignedInt.extend(rsVal | rtVal);
    }
}
