package org.generator.mul_div_generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * multu指令生成器
 */
public class MultuGenerator extends MulDivGenerator {

    public MultuGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "multu");
    }

    @Override
    public String getFunct() {
        return "011001";
    }
}
