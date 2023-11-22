package org.generator.cal_ri_generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * addi指令生成器
 */
public class AddiGenerator extends CalRiGenerator {

    public AddiGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "addi");
    }

    @Override
    public long calc(int rs, int imm) {
        if ((imm & 0x8000) != 0) {
            imm = (~imm + 1) & 0xffff;
            imm = -imm;
        }
        return getMips().getReg(rs) + imm;
    }

    @Override
    public String getOpcode() {
        return "001000";
    }

    @Override
    public int getImm(int rs) {
        return getRandom().randomSignedImm(rs);
    }
}
