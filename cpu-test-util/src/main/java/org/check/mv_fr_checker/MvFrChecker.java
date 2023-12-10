package org.check.mv_fr_checker;

import org.mips.Mips;
import org.check.Checker;
import org.util.Hex;

/**
 * mf_fr类指令验证抽象类
 */
public abstract class MvFrChecker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rd = getRd(im);
        long[] regs = mips.getRegs();
        int target = getTarget();
        mips.addPc(4);
        return mips.writeToGrf(mips.getPc() - 4, rd, regs[target]);
    }

    /**
     * 获得目标寄存器
     * @return 寄存器编号
     */
    public abstract int getTarget();
}
