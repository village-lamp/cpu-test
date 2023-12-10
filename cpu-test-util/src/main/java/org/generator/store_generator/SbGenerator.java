package org.generator.store_generator;

import org.mips.Mips;
import org.util.RandomUtil;

public class SbGenerator extends StoreGenerator {

    public SbGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "sb");
    }

    @Override
    public String getOpcode() {
        return "101000";
    }
}
