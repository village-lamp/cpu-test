package org.check.LoadChecker;

import org.Mips;
import org.check.Checker;
import org.constant.CommonConstant;
import org.util.Hex;

/**
 * load类指令验证抽象类
 */
public abstract class LoadChecker extends Checker implements CommonConstant {

    @Override
    public String check(String code, Mips mips) {
        Hex im = new Hex();
        im.set(code);
        int base = getRs(im);
        int rt = getRt(im);
        int offset = getImm16(im);
        if ((offset & 0x8000) != 0) {
            offset -= 0x10000;
        }
        long[] regs = mips.getRegs();
        long addr = regs[base] + offset;
        //地址错误
        if (!isAlign(addr) || addr < 0 || addr > DM_END) {
            return "null";
        }
        mips.addPc(4);
        Long data = mips.getDm().get((int) addr & 0xfffffffc);
        if (data == null) {
            data = 0L;
        }
        data = loadData(data, addr);
        return mips.writeToGrf(mips.getPc() - 4, rt, data);
    }

    /**
     * 判断是否对齐
     * @return 是否对齐
     */
    public abstract boolean isAlign(long addr);

    /**
     * 计算加载到寄存器的值
     * @param data 原始数据
     * @param addr 读取地址
     * @return 计算结果
     */
    public abstract long loadData(long data, long addr);
}
