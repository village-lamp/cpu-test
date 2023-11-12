package org.check;

import org.Mips;

/**
 * nop验证类
 */
public class NopCheck extends Check {

    @Override
    public String check(String code, Mips mips) {
        mips.addPc(4);
        return null;
    }
}
