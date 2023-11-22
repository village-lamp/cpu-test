package org.check.br_r2_checker;

/**
 * beq验证类
 */
public class BeqChecker extends BrR2Checker {

    @Override
    public boolean isJump(long rsVal, long rtVal) {
        return rsVal == rtVal;
    }
}
