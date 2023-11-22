package org.check.store_checker;

/**
 * sw验证类
 */
public class SwChecker extends StoreChecker {

    @Override
    public boolean isAlign(long addr) {
        return addr % 4 == 0;
    }

    @Override
    public long storeData(long data, long val, long addr) {
        return val;
    }
}
