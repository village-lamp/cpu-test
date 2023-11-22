package org.generator.cal_rr_generator;

import org.Mips;
import org.util.RandomUtil;
import org.util.UnsignedInt;

/**
 * sub指令生成器
 */
public class SubGenerator extends CalRrGenerator {

    public SubGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "sub");
    }

    @Override
    public String getFunct() {
        return "100010";
    }

    @Override
    public long calc(int rs, int rt) {
        return UnsignedInt.over(getMips().getReg(rs) - getMips().getReg(rt));
    }
}
