package org.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RandomUtilTest {


    private RandomUtil util;

    @Before
    public void init() {
        Random random = new Random();
        util = new RandomUtil(random.nextLong());
    }

    @Test
    public void randomReg() {
    }

    @Test
    public void testRandomReg() {
    }

    @Test
    public void randomLow() {
    }

    @Test
    public void randomMid() {
    }

    @Test
    public void randomHigh() {
    }

    @Test
    public void updateLow() {
    }

    @Test
    public void updateMid() {
    }

    @Test
    public void updateHigh() {
    }

    @Test
    public void update() {
    }

    @Test
    public void randomUnsignedImm() {
        boolean ret = (util.randomUnsignedImm(30) <= 3);
        assertTrue(ret);
    }

    @Test
    public void randomDm() {
        assertEquals(32432, util.randomDm(32432));
        util.addValueToDm(100);
        assertEquals(-32667, util.randomDm(0x7fff));
        assertEquals(-0x8000, util.randomDm(-0x8000));
        assertEquals(32767, util.randomDm(-32667));
    }

    @Test
    public void getLine() {
        assertEquals(1, util.getLine(0x3000));
        assertEquals(10, util.getLine(0x3024));
    }
}