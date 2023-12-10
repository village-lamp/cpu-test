package org.check.store_checker;

import org.mips.Mips;

/**
 * sw验证类
 */
public class SwChecker extends StoreChecker {

    @Override
    public boolean isExc(long addr) {
        return (addr % 4 != 0) || "none".equals(Mips.hitHardware(addr)) ||
                addr == TC0_COUNT_ADDR || addr == TC1_COUNT_ADDR;
    }

    @Override
    public long storeData(long data, long val, long addr) {
        return val;
    }
}
