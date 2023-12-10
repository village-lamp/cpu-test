package org.check.mtc0_checker;

import org.check.Checker;
import org.mips.Mips;
import org.util.Hex;

public class Mtc0Checker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rt = getRt(im);
        int rd = getRd(im);
        if (rd != 13) {
            mips.getCp0().write(mips.getReg(rt), rd);
        }
        mips.addPc(4);
        return null;
    }
}
