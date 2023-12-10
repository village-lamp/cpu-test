package org.check.nop_checker;

import org.mips.Mips;
import org.check.Checker;

/**
 * nop验证类
 */
public class NopChecker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        mips.addPc(4);
        return null;
    }
}
