package org.check;

import org.Mips;
import org.util.Hex;
import org.util.UnsignedInt;

public class LuiCheck extends Check {

    @Override
    public String generate(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rt = getRt(im);
        long imm = getImm16(im);
        long data = UnsignedInt.over(imm << 16);
        mips.addPc(4);
        return mips.writeToGrf(mips.getPc() - 4, rt, data);
    }
}
