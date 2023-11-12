package org.check;

import org.Mips;
import org.constant.CommonConstant;
import org.util.Hex;

public class JrCheck extends Check implements CommonConstant {

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
