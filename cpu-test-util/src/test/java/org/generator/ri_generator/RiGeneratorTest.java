package org.generator.ri_generator;

import org.generator.Generator;
import org.junit.Test;
import org.mips.Mips;
import org.util.RandomUtil;

import static org.junit.Assert.*;

public class RiGeneratorTest {

    @Test
    public void generate() {
        Mips mips = new Mips();
        RandomUtil randomUtil = new RandomUtil(2342L);
        RiGenerator generator = new RiGenerator(mips, randomUtil);
        generator.generate();
        System.out.println(mips.getCode().get(0x3000));
        System.out.println(mips.getCodeStr().get(0x3000));
    }
}