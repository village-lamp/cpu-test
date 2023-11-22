package org.generator.mv_to_generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * mtlo指令生成器
 */
public class MtloGenerator extends MvToGenerator {

    public MtloGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "mtlo");
    }

    @Override
    public String getFunct() {
        return "010011";
    }
}
