package org.check.store_checker;

import org.mips.Mips;

/**
 * sh验证类
 */
public class ShChecker extends StoreChecker {

    @Override
    public boolean isExc(long addr) {
        String hit = Mips.hitHardware(addr);
        return (addr % 2 != 0) || "none".equals(hit) ||
                "TC0".equals(hit) || "TC1".equals(hit);
    }

    @Override
    public long storeData(long data, long val, long addr) {
        long filter = 0xffff0000ffffffffL;
        int shift = (((addr & 0x2) != 0) ? 1 : 0) << 4;
        filter >>= (32 - shift);
        data &= filter;
        val = (val & 0xffff) << shift;
        return data | val;
    }
}
