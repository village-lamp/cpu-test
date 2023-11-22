package org.generator.store_generator;

import org.Mips;
import org.util.RandomUtil;

public class SbGenerator extends StoreGenerator {

    public SbGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "sb");
    }

    @Override
    public String getOpcode() {
        return "101000";
    }

    @Override
    public int alignAddr(int addr) {
        return addr;
    }
}
