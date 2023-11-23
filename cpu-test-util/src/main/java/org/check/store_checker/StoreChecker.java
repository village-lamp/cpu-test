package org.check.store_checker;

import org.Mips;
import org.check.Checker;
import org.constant.CommonConstant;
import org.util.Hex;

/**
 * store类指令验证抽象类
 */
public abstract class StoreChecker extends Checker implements CommonConstant {

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
        data = storeData(data, regs[rt], addr);
        if (data == 0L && mips.isGenerate()) {
            mips.addPc(-4);
            return "none";
        }
        return mips.writeToDm((mips.getPc() - 4), (int) addr & 0xfffffffc, data);
    }

    /**
     * 判断是否对齐
     * @return 是否对齐
     */
    public abstract boolean isAlign(long addr);

    /**
     * 计算存储到dm的值
     * @param data dm内数据
     * @param val 寄存器值
     * @param addr 存入地址
     * @return 计算结果
     */
    public abstract long storeData(long data, long val, long addr);
}
