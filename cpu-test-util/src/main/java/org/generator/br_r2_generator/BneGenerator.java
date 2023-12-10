package org.generator.br_r2_generator;

import org.mips.Mips;
import org.util.RandomUtil;

/**
 * bne指令生成器
 */
public class BneGenerator extends BrR2Generator {

    public BneGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "bne");
    }

    @Override
    public boolean isJump(long rsVal, long rtVal) {
        return rsVal != rtVal;
    }

    @Override
    public String getOpcode() {
        return "000101";
    }
}
