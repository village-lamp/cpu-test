package org.generator;

import org.Mips;
import org.junit.Test;
import org.util.RandomUtil;

import static org.junit.Assert.*;

public class OriGeneratorTest {

    @Test
    public void generate() {
    }

    @Test
    public void translate() {
        OriGenerator oriGenerator = new OriGenerator(new Mips(), new RandomUtil(12314L));
        assertEquals("0011010000000001010100111111000000",
                oriGenerator.translate("ori $1, $0, 1343"));
    }
}