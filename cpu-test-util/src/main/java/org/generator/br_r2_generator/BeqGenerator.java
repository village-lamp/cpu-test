package org.generator.br_r2_generator;

import org.constant.CommonConstant;
import org.mips.Mips;
import org.constant.RegConstant;
import org.util.RandomUtil;

/**
 * beq指令生成器类
 */
public class BeqGenerator extends BrR2Generator implements RegConstant, CommonConstant {

    public BeqGenerator(Mips mips, RandomUtil random) {
        super(mips, random, "beq");
    }

    @Override
    public boolean isJump(long rsVal, long rtVal) {
        return rsVal == rtVal;
    }

    @Override
    public String getOpcode() {
        return "000100";
    }
}
