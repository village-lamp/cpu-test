package org.check.lui_checker;

import org.mips.Mips;
import org.check.Checker;
import org.util.Hex;
import org.util.UnsignedInt;

/**
 * lui验证类
 */
public class LuiChecker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rt = getRt(im);
        long imm = getImm16(im);
        long data = UnsignedInt.over(imm << 16);
        mips.addPc(4);
        return mips.writeToGrf(mips.getPc() - 4, rt, data);
    }
}
