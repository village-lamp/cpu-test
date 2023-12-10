package org.check.ri_checker;

import org.check.Checker;
import org.mips.Mips;

public class RiChecker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        return "ExcCode:10";
    }
}
