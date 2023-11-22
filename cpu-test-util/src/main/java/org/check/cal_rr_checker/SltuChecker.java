package org.check.cal_rr_checker;

/**
 * sltu验证类
 */
public class SltuChecker extends CalRrChecker {

    @Override
    public long calc(long rsVal, long rtVal) {
        if (rsVal < rtVal) {
            return 1L;
        }
        return 0L;
    }
}
