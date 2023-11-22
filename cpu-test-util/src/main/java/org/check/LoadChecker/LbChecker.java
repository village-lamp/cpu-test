package org.check.LoadChecker;

public class LbChecker extends LoadChecker {

    @Override
    public boolean isAlign(long addr) {
        return true;
    }

    @Override
    public long loadData(long data, long addr) {
        data >>= (addr & 0x3) << 3;
        return ((data & 0x80) != 0) ? data | 0xffffff00L : data & 0xff;
    }
}
