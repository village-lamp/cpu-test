package org.generator.mul_div_generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * divu指令生成器
 */
public class DivuGenerator extends MulDivGenerator {

    public DivuGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "divu");
    }

    @Override
    public String getFunct() {
        return "011011";
    }
}
