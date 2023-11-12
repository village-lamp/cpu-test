package org.check;

import org.Mips;
import org.util.Hex;
import org.util.UnsignedInt;

/**
 * sub验证类
 */
public class SubCheck extends Check {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        int rd = getRd(im);
        long[] regs = mips.getRegs();
        long data = UnsignedInt.over(regs[rs] - regs[rt]);
        mips.addPc(4);
        return mips.writeToGrf(mips.getPc() - 4, rd, data);
    }
}
