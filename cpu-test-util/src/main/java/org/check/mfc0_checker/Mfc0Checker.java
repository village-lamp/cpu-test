package org.check.mfc0_checker;

import org.check.Checker;
import org.mips.Mips;
import org.util.Hex;

public class Mfc0Checker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rt = getRt(im);
        int rd = getRd(im);
        mips.addPc(4);
        return mips.writeToGrf(mips.getPc() - 4, rt, mips.getCp0().read(rd));
    }
}
