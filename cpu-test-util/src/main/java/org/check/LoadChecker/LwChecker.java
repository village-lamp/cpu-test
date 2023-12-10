package org.check.LoadChecker;

import org.mips.Mips;

/**
 * lw验证类
 */
public class LwChecker extends LoadChecker {

    @Override
    public boolean isExc(long addr) {
        return (addr % 4 != 0) || "none".equals(Mips.hitHardware(addr));
    }

    @Override
    public long loadData(long data, long addr) {
        return data;
    }
}
