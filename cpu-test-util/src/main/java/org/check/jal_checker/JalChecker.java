package org.check.jal_checker;

import org.mips.Mips;
import org.check.Checker;
import org.util.Hex;

/**
 * jal验证类
 */
public class JalChecker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        //31号寄存器值改变，jal空块应变成beq空块
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
