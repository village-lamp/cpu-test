package org.check.mv_to_checker;

import org.mips.Mips;
import org.check.Checker;
import org.util.Hex;

/**
 * mv_to类指令验证抽象类
 */
public abstract class MvToChecker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        long[] regs = mips.getRegs();
        int target = getTarget();
        mips.setReg(target, regs[rs]);
        mips.addPc(4);
        return null;
    }

    /**
     * 获得目标寄存器
     * @return 寄存器编号
     */
    public abstract int getTarget();
}
