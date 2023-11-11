package org.check;

import org.Mips;
import org.util.Hex;

public class BeqCheck extends Check {

    @Override
    public String generate(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        short offset = (short) getImm16(im);
        long[] regs = mips.getRegs();
        if (regs[rs] == regs[rt]) {
            mips.addPc(((int) offset + 1) << 2);
        }
        else {
            mips.addPc(4);
        }
        return null;
    }
}
