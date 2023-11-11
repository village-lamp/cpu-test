package org.generator;

import org.constant.CommonConstant;
import org.Mips;
import org.constant.RegConstant;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.TreeMap;
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
            if (getMips().getReg(rs) == getMips().getReg(rt)) {
                break;
            }
        }
        for (int i = 1; i <= TRY_TIMES; ++i) {
            int pc = getRandom().randInt(PC_BEGIN, getMips().getPc() + JUMP_MAX);
            pc = pc & 0xfffffffc;
            int npc = pc;
            if (getRandom().getLine(pc) == 2108) {
                int j = 0;
            }
            if (pc <= getMips().getPc()) {
                Mips testMips = getMips().clone();
                testMips.setPc(pc);
                testMips.run(getMips().getPc(), MAX_RUNTIMES);
                if (testMips.getPc() == getMips().getPc()) {
                    if (testMips.getReg(rs) == testMips.getReg(rt)) {
                        continue;
                    } else {
                        getMips().setDm(testMips.getDm());
                        getMips().setRegs(testMips.getRegs());
                        npc = getMips().getPc() + 8;
                    }
                } else {
                    if (getMips().getCodeStr().get(testMips.getPc() + 4) != null) {
                        continue;
                    }
                    getMips().setDm(testMips.getDm());
                    getMips().setRegs(testMips.getRegs());
                    getMips().setBlock("beq", getMips().getPc() + 8);
                    npc = testMips.getPc();
                }
            }
            String codeStr = String.format("beq $%d, $%d, line%d", rs, rt, getRandom().getLine(pc));
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
        String str = "000100";
        Pattern pattern = Pattern.compile("beq \\$(\\d*), \\$(\\d*), line(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        matcher.find();
        int imm = Integer.parseInt(matcher.group(3)) -
                getRandom().getLine(getMips().getPc()) - 1;
        str += MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                MipsCode.getReg(Integer.parseInt(matcher.group(2))) +
                MipsCode.getImm16(imm);
        return str;
    }
}
