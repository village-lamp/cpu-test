package org.generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * sub指令生成器
 */
public class SubGenerator extends RGenerator{

    public SubGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "sub");
    }
}
