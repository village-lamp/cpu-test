package org.check;

import org.Mips;
import org.constant.CommonConstant;
import org.util.Hex;

public class SwCheck extends Check implements CommonConstant {

    @Override
    public String generate(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int base = getRs(im);
        int rt = getRt(im);
        int offset = getImm16(im);
        long[] regs = mips.getRegs();
        long addr = regs[base] + offset;
        addr = addr % 0x10000L;
        if (addr % 4 != 0 || addr < 0 || addr > DM_END) {
            return "null";
        }
        mips.addPc(4);
        return mips.writeToDm((mips.getPc() - 4), (int) addr, regs[rt]);
    }
}
