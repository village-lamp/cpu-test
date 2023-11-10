package org.util;

import org.Mips;
import org.junit.Test;

import static org.junit.Assert.*;

public class MipsCodeTest {

    @Test
    public void getReg() {
        assertEquals("11111", MipsCode.getReg(31));
        assertEquals("00000", MipsCode.getReg(0));
    }

    @Test
    public void getImm16() {
        assertEquals("1111111111111111", MipsCode.getImm16(-1));
        assertEquals("0111111111111111", MipsCode.getImm16(32767));
    }

    @Test
    public void getImm26() {
        assertEquals("11111111111111111111111110", MipsCode.getImm26(-2));
        assertEquals("00000000000111111111111111", MipsCode.getImm26(32767));
    }

    @Test
    public void getByInt() {
        assertEquals("0011", MipsCode.getByInt(3, 4));
        assertEquals("11", MipsCode.getByInt(3, 2));
    }
}