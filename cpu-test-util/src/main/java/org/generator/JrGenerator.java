package org.generator;

import org.Mips;
import org.constant.CommonConstant;
import org.constant.RegConstant;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JrGenerator extends Generator implements CommonConstant, RegConstant {

    public JrGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        int rs = MID_REG_START;
        for (; rs <= MID_REG_END; ++rs) {
            if (getMips().getReg(rs) % 4 == 0) {
                int pc = (int) getMips().getReg(rs);
                if (pc < PC_BEGIN || pc > getMips().getPc() + JUMP_MAX) continue;
                if (pc <= getMips().getPc()) {
                    Mips testMips = getMips().clone();
                    testMips.run(getMips().getPc(), MAX_RUNTIMES);
                    if (testMips.getPc() == getMips().getPc()) {
                        continue;
                    } else {
                        if (getMips().getCodeStr().get(testMips.getPc() + 4) != null) {
                            continue;
                        }
                        getMips().setDm(testMips.getDm());
                        getMips().setRegs(testMips.getRegs());
                        getMips().setBlock("beq", getMips().getPc() + 4);
                        pc = testMips.getPc();
                    }
                }
                String codeStr = String.format("jr $%d", rs);
                getMips().putCodeStr(codeStr);
                getMips().putCode(translate(codeStr));
                getMips().addPc(4);
                getMips().putCodeStr("nop");
                getMips().putCode("00000000");
                getMips().setPc(pc);
                break;
            }
        }
    }

    @Override
    public String translate(String codeStr) {
        String str = "000000";
        Pattern pattern =Pattern.compile("jr \\$(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        matcher.find();
        str += MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                MipsCode.getReg(0) + MipsCode.getReg(0);
        str += "00000001000";
        return str;
    }
}
