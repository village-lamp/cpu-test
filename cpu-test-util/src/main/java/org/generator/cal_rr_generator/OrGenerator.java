package org.generator.cal_rr_generator;

import org.Mips;
import org.util.RandomUtil;
import org.util.UnsignedInt;

/**
 * or指令生成器
 */
public class OrGenerator extends CalRrGenerator {

    public OrGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "or");
    }

    @Override
    public String getFunct() {
        return "100101";
    }

    @Override
    public long calc(int rs, int rt) {
        return UnsignedInt.over(getMips().getReg(rs) | getMips().getReg(rt));
    }
}
