package org.generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * 加法指令生成器
 */
public class AddGenerator extends RGenerator {

    public AddGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "add");
    }
}
