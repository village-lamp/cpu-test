package org.check.cal_rr_checker;

import org.constant.CommonConstant;
import org.mips.Mips;
import org.check.Checker;
import org.util.Hex;
import org.util.UnsignedInt;

/**
 * cal_rr指令验证抽象类
 */
public abstract class CalRrChecker extends Checker implements CommonConstant {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        int rd = getRd(im);
        long[] regs = mips.getRegs();
        Long data = calc(regs[rs], regs[rt]);
        if (data == null) {
            if (mips.isGenerate() && mips.getPc() < EXC_INT_BEGIN &&
                    !mips.isDelaySlot()) {
                return "none";
            }
            data = 0L;
        }
        if (data < 0 ) {
            int j = 0;
        }
        if (UnsignedInt.isOverFlow(data)) {
            return "ExcCode:12";
        }
        mips.addPc(4);
        return mips.writeToGrf(mips.getPc() - 4, rd, UnsignedInt.over(data));
    }

    /**
     * 计算指令结果
     * @return 结果
     */
    public abstract Long calc(long rsVal, long rtVal);
}
