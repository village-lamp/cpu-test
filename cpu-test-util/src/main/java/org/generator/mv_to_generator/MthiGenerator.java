package org.generator.mv_to_generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * mthi指令生成器
 */
public class MthiGenerator extends MvToGenerator {

    public MthiGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "mthi");
    }

    @Override
    public String getFunct() {
        return "010001";
    }
}
