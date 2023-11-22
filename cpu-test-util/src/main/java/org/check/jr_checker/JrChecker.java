package org.check.jr_checker;

import org.Mips;
import org.check.Checker;
import org.constant.CommonConstant;
import org.util.Hex;

public class JrChecker extends Checker implements CommonConstant {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        if (mips.getRegs()[rs] > PC_END || mips.getRegs()[rs] < PC_BEGIN ||
        mips.getRegs()[rs] % 4 != 0) {
            return "null";
        }
        mips.setPc((int) mips.getRegs()[rs]);
        return null;
    }
}
