package org.check;

import org.Mips;
import org.util.Hex;
import org.util.UnsignedInt;

/**
 * ori验证类
 */
public class OriCheck extends Check {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        int imm = getImm16(im);
        long[] regs = mips.getRegs();
        long data = UnsignedInt.over(regs[rs] | imm);
        mips.addPc(4);
        return mips.writeToGrf(mips.getPc() - 4, rt, data);
    }
}
