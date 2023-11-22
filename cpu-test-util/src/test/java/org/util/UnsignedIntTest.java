package org.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnsignedIntTest {

    @Test
    public void signed() {
        assertEquals(1L, UnsignedInt.signed(1L));
        assertEquals(-1L, UnsignedInt.signed(0xffffffffL));
        assertEquals(-3424L, UnsignedInt.signed(0xfffff2a0L));
    }
}