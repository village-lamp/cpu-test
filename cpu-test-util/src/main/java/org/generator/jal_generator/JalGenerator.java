package org.generator.jal_generator;

import org.data_generator.Manager;
import org.mips.Mips;
import org.constant.CommonConstant;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JalGenerator extends Generator implements CommonConstant {

    public JalGenerator(Mips mips, RandomUtil random) {
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
        //不能在延迟槽中生成
        if (getMips().isDelaySlot()) {
            return;
        }
        //不在计时槽中生成
        if (getMips().getTc0().isStart() ||
                getMips().getTc1().isStart()) {
            return;
        }

        //生成延迟槽
        Manager.generateDelaySlot();

        //尝试跳转
        for (int i = 1; i <= TRY_TIMES; ++i) {
            int pc = getRandom().randInt(PC_BEGIN + 8, Math.min(getMips().getPc() + JUMP_MAX, PC_END - 12));
            pc = pc & 0xfffffffc;
            //npc用于记录跳转的位置
            int npc = pc;

            if (getRandom().getLine(pc) == 360) {
                int j = 0;
            }

            if (pc <= getMips().getPc()) {
                //如果向回跳转，则需要判断是否死循环
                Mips testMips = getMips().clone();
                testMips.setReg(31, getMips().getPc() + 8);
                ArrayList<String> outs = testMips.runDelaySlot(getMips().getPc());
                if (outs.size() > 1 || "none".equals(outs.get(0))) {
                    continue;
                }
                testMips.setPc(pc);
                testMips.setBlock("jal", 0);
                testMips.run(getMips().getPc(), MAX_RUNTIMES);
                if (testMips.isError()) {
                    continue;
                }
                if (testMips.getPc() == getMips().getPc()) {
                    //如果回到本条指令，则判定为死循环
                    continue;
                } else {
                    //如果运行失败，则停止的位置应该已经有指令
                    if (getMips().getCodeStr().get(testMips.getPc() + 4) != null ||
                            getMips().getCodeStr().get(testMips.getPc()) != null) {
                        continue;
                    }
                    //写回状态
                    getMips().cpy(testMips);
                    npc = testMips.getPc();
                    //如果停留的地方在指令的前面，则进入一个空块，将这个块声明为beq或者jal,取决于循环时31号寄存器有无变化
                    if (testMips.getPc() < getMips().getPc()) {
                        getMips().setBlock(testMips.getBlock(), getMips().getPc() + 8);
                    }
                }
            } else {
                getMips().setReg(31, getMips().getPc() + 8);
                ArrayList<String> outs = getMips().runDelaySlot(getMips().getPc());
                if (outs.size() > 1) {
                    npc = getMips().getPc();
                }
                getMips().addPc(-8);
            }

            //不能跳转到自己的下一条指令
            if (pc == getMips().getPc() + 4) {
                pc += 4;
                npc += 4;
            }

            String codeStr = String.format("jal line%d", getRandom().getLine(pc));
            getMips().putCodeStr(codeStr);
            getMips().putCode(translate(codeStr));
            getMips().setPc(npc);
            break;
        }

        //清除延迟槽
        getMips().removeDelaySlot();
    }

    @Override
    public String translate(String codeStr) {
        String str = "000011";
        Pattern pattern = Pattern.compile("jal line(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            int imm = Integer.parseInt(matcher.group(1));
            imm = getRandom().getPc(imm) >> 2;
            str += MipsCode.getImm26(imm);
        }
        return str;
    }
}
