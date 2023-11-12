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
        //不能在最后两条中生成
        if (getMips().getPc() > PC_END - 12) return;
        //不能再向回跳转的代码空块中生成
        if (getMips().getBlock() != null) {
            return;
        }

        //寻找可能跳转的中级寄存器
        int rs = MID_REG_START;
        for (; rs <= MID_REG_END; ++rs) {
            if (getMips().getReg(rs) % 4 == 0) {
                int pc = (int) getMips().getReg(rs);
                if (pc < PC_BEGIN || pc > getMips().getPc() + JUMP_MAX||
                pc == getMips().getPc() + 4) continue;

                //尝试执行
                if (pc <= getMips().getPc()) {
                    Mips testMips = getMips().clone();
                    testMips.run(getMips().getPc(), MAX_RUNTIMES);
                    //如果回到本条指令，则判定为死循环
                    if (testMips.getPc() == getMips().getPc()) {
                        continue;
                    } else {
                        //如果运行失败，则停止的位置应该已经有指令
                        if (getMips().getCodeStr().get(testMips.getPc() + 4) != null ||
                                getMips().getCodeStr().get(testMips.getPc()) != null) {
                            continue;
                        }
                        //写回状态
                        getMips().setDm(testMips.getDm());
                        getMips().setRegs(testMips.getRegs());
                        //如果停留的地方在指令的前面，则进入一个空块，将这个块声明为beq
                        if (testMips.getPc() < getMips().getPc()) {
                            getMips().setBlock("beq", getMips().getPc() + 8);
                        }
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
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                    MipsCode.getReg(0) + MipsCode.getReg(0);
            str += "00000001000";
        }
        return str;
    }
}
