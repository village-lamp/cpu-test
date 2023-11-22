package org.generator.load_generator;

import org.Mips;
import org.util.RandomUtil;

public class LhGenerator extends LoadGenerator {

    public LhGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "lh");
    }

    @Override
    public String getOpcode() {
        return "100001";
    }

    @Override
    public int randomBits() {
        return getRandom().randInt(1) << 1;
    }
}
