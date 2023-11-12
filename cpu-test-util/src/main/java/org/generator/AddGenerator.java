package org.generator;

import org.Mips;
import org.util.RandomUtil;
import org.util.UnsignedInt;

/**
 * 加法指令生成器
 */
public class AddGenerator extends RGenerator {

    public AddGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "add");
    }

    @Override
    public String getFunct() {
        return "00000100000";
    }

    @Override
    public long calc(int rs, int rt) {
        return UnsignedInt.over(getMips().getReg(rs) + getMips().getReg(rt));
    }
}
