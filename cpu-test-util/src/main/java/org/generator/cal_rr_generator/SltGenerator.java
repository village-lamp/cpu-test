package org.generator.cal_rr_generator;

import org.mips.Mips;
import org.util.RandomUtil;
import org.util.UnsignedInt;

/**
 * slt指令生成器
 */
public class SltGenerator extends CalRrGenerator {

    public SltGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "slt");
    }

    @Override
    public String getFunct() {
        return "101010";
    }

    @Override
    public long calc(int rs, int rt) {
        long rsValue = UnsignedInt.signed(getMips().getReg(rs));
        long rtValue = UnsignedInt.signed(getMips().getReg(rt));
        if (rsValue < rtValue) {
            return 1L;
        }
        return 0L;
    }
}
