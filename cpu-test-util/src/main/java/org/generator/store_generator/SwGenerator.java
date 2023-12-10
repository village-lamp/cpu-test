package org.generator.store_generator;

import org.mips.Mips;
import org.util.RandomUtil;

/**
 * sw指令生成器
 */
public class SwGenerator extends StoreGenerator {

    public SwGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "sw");
    }

    @Override
    public String getOpcode() {
        return "101011";
    }
}
