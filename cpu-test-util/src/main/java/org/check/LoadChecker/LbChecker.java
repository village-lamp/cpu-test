package org.check.LoadChecker;

import org.mips.Mips;

public class LbChecker extends LoadChecker {

    @Override
    public boolean isExc(long addr) {
        String hit = Mips.hitHardware(addr);
        return "none".equals(hit) || "TC0".equals(hit) || "TC1".equals(hit);
    }

    @Override
    public long loadData(long data, long addr) {
        data >>= (addr & 0x3) << 3;
        return ((data & 0x80) != 0) ? data | 0xffffff00L : data & 0xff;
    }
}
