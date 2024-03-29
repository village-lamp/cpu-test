package org.check.mul_div_checker;

import org.constant.CommonConstant;
import org.mips.Mips;
import org.check.Checker;
import org.util.Hex;
import org.util.UnsignedInt;

/**
 * mul_div类指令验证抽象类
 */
public abstract class MulDivChecker extends Checker implements CommonConstant {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        long[] regs = mips.getRegs();
        long[] data = calc(regs[rs], regs[rt]);
        if (data != null) {
            long hi = UnsignedInt.over(data[0]);
            long lo = UnsignedInt.over(data[1]);
            mips.setReg(32, hi);
            mips.setReg(33, lo);
        } else {
            if (mips.isGenerate() && mips.getPc() < EXC_INT_BEGIN &&
                    !mips.isDelaySlot()) {
                return "none";
            }
        }
        mips.addPc(4);
        return null;
    }

    /**
     * 计算指令结果
     * @return 结果
     */
    public abstract long[] calc(long rsVal, long rtVal);
}
