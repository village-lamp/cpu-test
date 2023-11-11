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
        for (int i = 1; i <= TRY_TIMES; ++i) {
            int pc = getRandom().randInt(PC_BEGIN, getMips().getPc() + JUMP_MAX);
            pc = pc & 0xfffffffc;
            int npc = pc;
            if (getRandom().getLine(pc) == 497) {
                int j = 0;
            }
            if (pc <= getMips().getPc()) {
                Mips testMips = getMips().clone();
                testMips.setPc(pc);
                testMips.setReg(31, getMips().getPc() + 8);
                testMips.setBlock("jal", 0);
                testMips.run(getMips().getPc(), MAX_RUNTIMES);
                if (testMips.getPc() == getMips().getPc()) {
                    continue;
                } else {
                    if (getMips().getCodeStr().get(testMips.getPc() + 4) != null) {
                        continue;
                    }
                    getMips().setDm(testMips.getDm());
                    getMips().setRegs(testMips.getRegs());
                    npc = testMips.getPc();
                    if (testMips.getPc() < getMips().getPc()) {
                        getMips().setBlock(testMips.getBlock(), getMips().getPc() + 8);
                    }
                }
            }
            if (pc == getMips().getPc() + 4) {
                pc += 4;
                npc += 4;
            }
            String codeStr = String.format("jal line%d", getRandom().getLine(pc));
            getMips().setReg(31, getMips().getPc() + 8);
            getMips().putCodeStr(codeStr);
            getMips().putCode(translate(codeStr));
            getMips().addPc(4);
            getMips().putCodeStr("nop");
            getMips().putCode("00000000");
            getMips().setPc(npc);
            break;
        }
    }

    @Override
    public String translate(String codeStr) {
        String str = "000011";
        Pattern pattern = Pattern.compile("jal line(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        matcher.find();
        int imm = Integer.parseInt(matcher.group(1));
        imm = getRandom().getPc(imm) >> 2;
        str += MipsCode.getImm26(imm);
        return str;
    }
}
