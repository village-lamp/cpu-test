package org.generator.cal_ri_generator;

import org.Mips;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ori指令生成器
 */
public class OriGenerator extends CalRiGenerator {

    public OriGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "ori");
    }

    @Override
    public long calc(int rs, int imm) {
        return rs | imm;
    }

    @Override
    public String getOpcode() {
        return "001101";
    }

    @Override
    public int getImm(int rs) {
        return getRandom().randomUnsignedImm(rs);
    }
}
