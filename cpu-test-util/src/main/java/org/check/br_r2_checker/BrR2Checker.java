package org.check.br_r2_checker;

import org.Mips;
import org.check.Checker;
import org.util.Hex;

/**
 * br_r2类指令验证抽象类
 */
public abstract class BrR2Checker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        short offset = (short) getImm16(im);
        long[] regs = mips.getRegs();
        if (isJump(regs[rs], regs[rt])) {
            mips.addPc(((int) offset + 1) << 2);
        }
        else {
            mips.addPc(4);
        }
        return null;
    }

    /**
     * 判断是否跳转
     * @param rsVal rs寄存器值
     * @param rtVal rt寄存器值
     * @return 结果
     */
    public abstract boolean isJump(long rsVal, long rtVal);
}
