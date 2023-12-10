package org.check.LoadChecker;

import org.mips.Mips;
import org.check.Checker;
import org.constant.CommonConstant;
import org.util.Hex;
import org.util.UnsignedInt;
import sun.util.resources.cldr.ms.CalendarData_ms_BN;

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
        long addr = UnsignedInt.extend(regs[base]) + offset;

        //发生异常
        if (UnsignedInt.isOverFlow(addr)) {
            return "ExcCode:4";
        }
        addr = UnsignedInt.over(addr);
        if (isExc(addr)) {
            return "ExcCode:4";
        }
        mips.addPc(4);

        String hit = Mips.hitHardware(addr);
        Long data = 0L;

        if ("TC0".equals(hit)) {
            data = mips.getTc0().read(addr);
        }
        if ("TC1".equals(hit)) {
            data = mips.getTc1().read(addr);
        }
        if ("DM".equals(hit)) {
            data = mips.getDm().get((int) addr & 0xfffffffc);
            if (data == null) {
                data = 0L;
            }
            data = loadData(data, addr);
        }

        if (data == 0L && mips.isGenerate() && !mips.isDelaySlot()) {
            mips.addPc(-4);
            return "none";
        }

        return mips.writeToGrf(mips.getPc() - 4, rt, data);
    }

    /**
     * 判断是否异常
     * @return 是否异常
     */
    public abstract boolean isExc(long addr);

    /**
     * 计算加载到寄存器的值
     * @param data 原始数据
     * @param addr 读取地址
     * @return 计算结果
     */
    public abstract long loadData(long data, long addr);
}
