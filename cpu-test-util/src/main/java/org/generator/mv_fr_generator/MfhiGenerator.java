package org.generator.mv_fr_generator;

import org.Mips;
import org.util.RandomUtil;

public class MfhiGenerator extends MvFrGenerator {

    public MfhiGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "mfhi");
    }

    @Override
    public String getFunct() {
        return "010000";
    }
}
