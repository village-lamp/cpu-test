package org.generator.store_generator;

import org.Mips;
import org.util.RandomUtil;

public class ShGenerator extends StoreGenerator {

    public ShGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "sh");
    }

    @Override
    public String getOpcode() {
        return "101001";
    }

    @Override
    public int alignAddr(int addr) {
        return addr & 0xfffffffe;
    }
}
