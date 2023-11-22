package org.generator.load_generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * lw指令生成器
 */
public class LwGenerator extends LoadGenerator {

    public LwGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "lw");
    }

    @Override
    public String getOpcode() {
        return "100011";
    }

    @Override
    public int randomBits() {
        return 0;
    }
}
