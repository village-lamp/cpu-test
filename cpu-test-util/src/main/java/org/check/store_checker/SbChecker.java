package org.check.store_checker;

import org.mips.Mips;

/**
 * sb验证类
 */
public class SbChecker extends StoreChecker {

    @Override
    public boolean isExc(long addr) {
        String hit = Mips.hitHardware(addr);
        return "none".equals(hit) || "TC0".equals(hit) || "TC1".equals(hit);
    }

    @Override
    public long storeData(long data, long val, long addr) {
        long filter = 0xffffff00ffffffffL;
        int shift = (int) ((addr & 0x3) << 3);
        filter >>= (32 - shift);
        data &= filter;
        val = (val & 0xff) << shift;
        return data | val;
    }
}
