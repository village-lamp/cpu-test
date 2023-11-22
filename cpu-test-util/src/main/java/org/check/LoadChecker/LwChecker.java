package org.check.LoadChecker;

import org.Mips;

/**
 * lw验证类
 */
public class LwChecker extends LoadChecker {

    @Override
    public boolean isAlign(long addr) {
        return addr % 4 == 0;
    }

    @Override
    public long loadData(long data, long addr) {
        return data;
    }
}
