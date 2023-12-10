package org.check.LoadChecker;

import org.mips.Mips;

public class LhChecker extends LoadChecker {

    @Override
    public boolean isExc(long addr) {
        String hit = Mips.hitHardware(addr);
        return (addr % 2 != 0) || "none".equals(hit) ||
                "TC0".equals(hit) || "TC1".equals(hit);
    }

    @Override
    public long loadData(long data, long addr) {
        data >>= (((addr & 0x2) != 0) ? 1 : 0) << 4;
        return ((data & 0x8000) != 0) ? data | 0xffff0000L : data & 0xffff;
    }
}
