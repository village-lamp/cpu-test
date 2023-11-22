package org.generator.mul_div_generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * div指令生成器
 */
public class DivGenerator extends MulDivGenerator {

    public DivGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "div");
    }

    @Override
    public String getFunct() {
        return "011010";
    }
}
