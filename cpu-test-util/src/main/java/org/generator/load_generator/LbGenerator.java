package org.generator.load_generator;

import org.mips.Mips;
import org.util.RandomUtil;

public class LbGenerator extends LoadGenerator {

    public LbGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "lb");
    }

    @Override
    public String getOpcode() {
        return "100000";
    }

    @Override
    public int randomBits() {
        return getRandom().randInt(3);
    }
}
