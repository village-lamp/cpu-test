package org.generator.cal_rr_generator;

import org.mips.Mips;
import org.util.RandomUtil;

/**
 * sltu指令生成器
 */
public class SltuGenerator extends CalRrGenerator {

    public SltuGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "sltu");
    }

    @Override
    public String getFunct() {
        return "101011";
    }

    @Override
    public long calc(int rs, int rt) {
        long rsValue = getMips().getReg(rs);
        long rtValue = getMips().getReg(rt);
        if (rsValue < rtValue) {
            return 1L;
        }
        return 0L;
    }
}
