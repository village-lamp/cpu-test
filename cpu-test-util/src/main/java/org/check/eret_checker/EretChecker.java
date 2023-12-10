package org.check.eret_checker;

import org.check.Checker;
import org.mips.Mips;

public class EretChecker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        mips.getCp0().setExl(0);
        mips.setPc((int) mips.getCp0().getEpc());
        return null;
    }
}
