package org.check.store_checker;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShCheckerTest {

    @Test
    public void storeData() {
        ShChecker shChecker = new ShChecker();
        assertEquals(0x0abc0c34L, shChecker.storeData(0x77ff0c34L, 0xf29f0abcL, 2));
        assertEquals(0x77ff0abcL, shChecker.storeData(0x77ff0c34L, 0xf29f0abcL, 0));
    }
}