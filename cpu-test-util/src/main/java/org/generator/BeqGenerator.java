package org.generator;

import org.constant.CommonConstant;
import org.Mips;
import org.constant.RegConstant;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * beq指令生成器类
 */
public class BeqGenerator extends Generator implements RegConstant, CommonConstant {

    public BeqGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        if (getMips().getBlock() != null) {
            return;
        }
        int rs = LOW_REG_START;
        int rt = LOW_REG_START;
        for (;rs <= LOW_REG_END; ++rs) {
            for (; rt <= LOW_REG_END; ++rt) {
                if (rs == rt) {
                    continue;
                }
                if (getMips().getReg(rs) == getMips().getReg(rt)) {
                    break;
                }
            }
        }
        int pc = getRandom().randInt(PC_BEGIN, getMips().getPc() + JUMP_MAX);
        if (pc <= getMips().getPc()) {
            Mips testMips = getMips().clone();
            testMips.run(getMips().getPc());
            if (testMips.getPc() == getMips().getPc()) {
                if (testMips.getReg(rs) == testMips.getReg(rt)) {
                    return;
                } else {
                    getMips().setDm(testMips.getDm());
                    getMips().setRegs(testMips.getRegs());
                    pc = getMips().getPc() + 8;
                }
            } else {
                getMips().setDm(testMips.getDm());
                getMips().setRegs(testMips.getRegs());
                getMips().setBlock("beq", getMips().getPc() + 4);
                pc = testMips.getPc();
            }
        }
        String codeStr = String.format("beq $%d, $%d, line%d", rs, rt, getRandom().getLine(pc));
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getMips().addPc(4);
        getMips().putCodeStr("nop");
        getMips().putCode("00000000000000000000000000000000");
        getMips().setPc(pc);
    }

    @Override
    public String translate(String codeStr) {
        String str = "000100";
        Pattern pattern = Pattern.compile("beq \\$(\\d*), \\$(\\d*), line(\\d*)");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        int imm = Integer.parseInt(matcher.group(3)) -
                getRandom().getLine(getMips().getPc()) - 1;
        str += MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                MipsCode.getReg(Integer.parseInt(matcher.group(2))) +
                MipsCode.getImm16(imm);
        return str;
    }
}
