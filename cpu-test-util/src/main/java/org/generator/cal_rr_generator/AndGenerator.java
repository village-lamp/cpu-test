package org.generator.cal_rr_generator;

import org.mips.Mips;
import org.util.RandomUtil;
import org.util.UnsignedInt;

/**
 * and指令生成器
 */
public class AndGenerator extends CalRrGenerator {

    public AndGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "and");
    }

    @Override
    public String getFunct() {
        return "100100";
    }

    @Override
    public long calc(int rs, int rt) {
        return UnsignedInt.over(getMips().getReg(rs) & getMips().getReg(rt));
    }
}
