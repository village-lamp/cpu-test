package org.check;

import org.Mips;
import org.constant.CommonConstant;
import org.util.Hex;

/**
 * lw验证类
 */
public class LwCheck extends Check implements CommonConstant {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int base = getRs(im);
        int rt = getRt(im);
        int offset = getImm16(im);
        long[] regs = mips.getRegs();
        long addr = regs[base] + offset;
        //地址错误
        if (addr % 4 != 0 || addr < 0 || addr > DM_END) {
            return "null";
        }
        mips.addPc(4);
        Long data = mips.getDm().get((int) addr);
        if (data == null) {
            data = 0L;
        }
        return mips.writeToGrf(mips.getPc() - 4, rt, data);
    }
}
