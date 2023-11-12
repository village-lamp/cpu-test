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
        //不能在最后两条中生成
        if (getMips().getPc() > PC_END - 12) return;
        //不能再向回跳转的代码空块中生成
        if (getMips().getBlock() != null) {
            return;
        }

        //寻找相同值的两个低级寄存器
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

        //尝试跳转
        for (int i = 1; i <= TRY_TIMES; ++i) {
            int pc = getRandom().randInt(PC_BEGIN, Math.min(getMips().getPc() + JUMP_MAX, PC_END - 12));
            pc = pc & 0xfffffffc;
            //npc用于记录跳转的位置
            int npc = pc;
            if (pc <= getMips().getPc()) {
                //如果向回跳转，则需要判断是否死循环
                Mips testMips = getMips().clone();
                testMips.setPc(pc);
                testMips.run(getMips().getPc(), MAX_RUNTIMES);
                if (testMips.getPc() == getMips().getPc()) {
                    //如果回到本条指令且寄存器值没有变化，则判定为死循环
                    if (testMips.getReg(rs) == testMips.getReg(rt)) {
                        continue;
                    } else {
                        //写回状态
                        getMips().setDm(testMips.getDm());
                        getMips().setRegs(testMips.getRegs());
                        npc = getMips().getPc() + 8;
                    }
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
                    npc = testMips.getPc();
                }
            }
            //不能跳转到自己的下一条指令
            if (pc == getMips().getPc() + 4) {
                pc += 4;
                npc += 4;
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
        if (matcher.find()) {
            int imm = Integer.parseInt(matcher.group(3)) -
                    getRandom().getLine(getMips().getPc()) - 1;
            str += MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                    MipsCode.getReg(Integer.parseInt(matcher.group(2))) +
                    MipsCode.getImm16(imm);
        }
        return str;
    }
}
