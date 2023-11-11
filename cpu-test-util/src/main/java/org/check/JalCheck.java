package org.check;

import org.Mips;
import org.util.Hex;

public class JalCheck extends Check {

    @Override
    public String generate(String code, Mips mips) {
        if ("jal".equals(mips.getBlock())) {
            mips.setBlock("beq", mips.getBlockPc());
        }
        Hex im = new Hex();
        im.set(code);
        long offset = getImm26(im);
        String str = mips.writeToGrf(mips.getPc(), 31, mips.getPc() + 8);
        mips.setPc((int) (((mips.getPc() >> 28) << 28) | (offset << 2)));
        return str;
    }
}
