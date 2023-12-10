package org.check.store_checker;

import org.mips.Mips;
import org.check.Checker;
import org.constant.CommonConstant;
import org.util.Hex;
import org.util.UnsignedInt;

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
        long addr = UnsignedInt.extend(regs[base]) + offset;

        //发生异常
        if (UnsignedInt.isOverFlow(addr)) {
            return "ExcCode:5";
        }
        addr = UnsignedInt.over(addr);
        if (isExc(addr)) {
            return "ExcCode:5";
        }

        mips.addPc(4);

        String hit = Mips.hitHardware(addr);
        Long data = regs[rt];

        if ("TC0".equals(hit)) {
           mips.getTc0().write(addr, data);
           if (addr == TC0_BEGIN + 4 || data <= 1) {
               return null;
           }
           return String.valueOf(((mips.getTc0().getPresent() + 2) * 4)) + '\n';
        }
        if ("TC1".equals(hit)) {
            mips.getTc1().write(addr, data);
            if (addr == TC1_BEGIN + 4 || data <= 1) {
                return null;
            }
            return String.valueOf(((mips.getTc1().getPresent() + 2) * 4)) + '\n';
        }
        if ("DM".equals(hit)) {
            data = mips.getDm().get((int) addr & 0xfffffffc);
            if (data == null) {
                data = 0L;
            }
            data = storeData(data, regs[rt], addr);
        }
        if ("IG".equals(hit)) {
            return null;
        }

        if (data == 0L && mips.isGenerate() && !mips.isDelaySlot()) {
            mips.addPc(-4);
            return "none";
        }
        return mips.writeToDm((mips.getPc() - 4), (int) addr & 0xfffffffc, data);
    }

    /**
     * 判断是否异常
     * @return 是否异常
     */
    public abstract boolean isExc(long addr);

    /**
     * 计算存储到dm的值
     * @param data dm内数据
     * @param val 寄存器值
     * @param addr 存入地址
     * @return 计算结果
     */
    public abstract long storeData(long data, long val, long addr);
}
