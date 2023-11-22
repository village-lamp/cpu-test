package org.generator.mv_fr_generator;

import org.Mips;
import org.util.RandomUtil;

public class MfloGenerator extends MvFrGenerator {

    public MfloGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "mflo");
    }

    @Override
    public String getFunct() {
        return "010010";
    }
}
