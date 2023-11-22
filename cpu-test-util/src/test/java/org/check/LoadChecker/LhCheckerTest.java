package org.check.LoadChecker;

import org.junit.Test;

import static org.junit.Assert.*;

public class LhCheckerTest {

    @Test
    public void loadData() {
        LhChecker lhChecker = new LhChecker();
        assertEquals(0x3020L, lhChecker.loadData(0xa2333020L, 0));
        assertEquals(0xffffa233L, lhChecker.loadData(0xa2333020L, 2));
    }
}