package org.check.br_r2_checker;

/**
 * bne验证类
 */
public class BneChecker extends BrR2Checker {

    @Override
    public boolean isJump(long rsVal, long rtVal) {
        return rsVal != rtVal;
    }
}
