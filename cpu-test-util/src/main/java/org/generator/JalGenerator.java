package org.generator;

import org.Mips;
import org.constant.CommonConstant;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JalGenerator extends Generator implements CommonConstant {

    public JalGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        if (getMips().getBlock() != null) {
            return;
        }
        int pc = getRandom().randInt(PC_BEGIN, getMips().getPc() + JUMP_MAX);
        if (pc <= getMips().getPc()) {
            Mips testMips = getMips().clone();
            testMips.run(getMips().getPc());
            if (testMips.getPc() == getMips().getPc()) {
                return;
            } else {
                getMips().setDm(testMips.getDm());
                getMips().setRegs(testMips.getRegs());
                getMips().setBlock("jal", getMips().getPc() + 4);
                pc = testMips.getPc();
            }
        }
        String codeStr = String.format("jal line%d", getRandom().getLine(pc));
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getMips().addPc(4);
        getMips().putCodeStr("nop");
        getMips().putCode("00000000000000000000000000000000");
        getMips().setPc(pc);
    }

    @Override
    public String translate(String codeStr) {
        String str = "000011";
        Pattern pattern = Pattern.compile("jal line(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        matcher.find();
        int imm = Integer.parseInt(matcher.group(1)) -
                getRandom().getLine(getMips().getPc()) - 1;
        str += MipsCode.getImm26(imm);
        return str;
    }
}
