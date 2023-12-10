package org.check.cal_ri_checker;

import org.constant.CommonConstant;
import org.mips.Mips;
import org.check.Checker;
import org.util.Hex;
import org.util.UnsignedInt;

/**
 * cal_ri类指令验证抽象类
 */
public abstract class CalRiChecker extends Checker implements CommonConstant {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        int imm = getImm16(im);
        long[] regs = mips.getRegs();
        Long data = calc(regs[rs], imm);
        if (data == null) {
            if (mips.isGenerate() && mips.getPc() < EXC_INT_BEGIN &&
                    !mips.isDelaySlot()) {
                return "none";
            }
            data = 0L;
        }
        if (UnsignedInt.isOverFlow(data)) {
            return "ExcCode:12";
        }
        mips.addPc(4);
        return mips.writeToGrf(mips.getPc() - 4, rt, UnsignedInt.over(data));
    }

    /**
     * 计算指令结果
     * @return 结果
     */
    public abstract Long calc(long rsVal, long imm);
}
