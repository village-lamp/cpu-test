package org.generator.mul_div_generator;

import org.mips.Mips;
import org.util.RandomUtil;

/**
 * mult指令生成器
 */
public class MultGenerator extends MulDivGenerator {

    public MultGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "mult");
    }

    @Override
    public String getFunct() {
        return "011000";
    }
}
