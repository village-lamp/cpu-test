package org.generator.cal_rr_generator;

import org.mips.Mips;
import org.util.RandomUtil;
import org.util.UnsignedInt;

/**
 * add指令生成器
 */
public class AddGenerator extends CalRrGenerator {

    public AddGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "add");
    }

    @Override
    public String getFunct() {
        return "100000";
    }

    @Override
    public long calc(int rs, int rt) {
        return UnsignedInt.over(getMips().getReg(rs) + getMips().getReg(rt));
    }
}
