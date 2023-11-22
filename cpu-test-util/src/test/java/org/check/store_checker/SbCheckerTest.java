package org.check.store_checker;

import org.junit.Test;

import static org.junit.Assert.*;

public class SbCheckerTest {

    @Test
    public void storeData() {
        SbChecker sbChecker = new SbChecker();
        assertEquals(0x2343fd20, sbChecker.storeData(0x2343fdc0, 0x000f2f20, 0));
        assertEquals(0x234320c0, sbChecker.storeData(0x2343fdc0, 0x000f2f20, 1));
        assertEquals(0x2320fdc0, sbChecker.storeData(0x2343fdc0, 0x000f2f20, 2));
        assertEquals(0x2043fdc0, sbChecker.storeData(0x2343fdc0, 0x000f2f20, 3));
    }
}