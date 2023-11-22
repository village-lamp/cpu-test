package org.generator.cal_ri_generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * andi指令生成器
 */
public class AndiGenerator extends CalRiGenerator {

    public AndiGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "andi");
    }

    @Override
    public long calc(int rs, int imm) {
        return rs & imm;
    }

    @Override
    public String getOpcode() {
        return "001100";
    }

    @Override
    public int getImm(int rs) {
        return getRandom().randomUnsignedImm(rs);
    }
}
