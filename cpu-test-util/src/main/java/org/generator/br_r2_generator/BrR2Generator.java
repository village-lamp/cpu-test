package org.generator.br_r2_generator;

import org.data_generator.Manager;
import org.mips.Mips;
import org.constant.CommonConstant;
import org.constant.RegConstant;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * br_r2类指令生成器抽象类
 * 使用低级寄存器
 */
public abstract class BrR2Generator extends Generator implements RegConstant, CommonConstant {

    private final String type;

    public BrR2Generator(Mips mips, RandomUtil random, String type) {
        super(mips, random);
        this.type = type;
    }

    @Override
    public void generate() {
        //不能在最后两条中生成
        if (getMips().getPc() > PC_END - 12) {
            return;
        }
        //不能在向回跳转的代码空块中生成
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

        //寻找符合条件的两个低级寄存器
        int rs = LOW_REG_START;
        int rt = LOW_REG_START;
        for (;rs <= LOW_REG_END; ++rs) {
            for (; rt <= LOW_REG_END; ++rt) {
                if (rs == rt) {
                    continue;
                }
                if (isJump(getMips().getReg(rs), getMips().getReg(rt))) {
                    break;
                }
            }
            if (isJump(getMips().getReg(rs), getMips().getReg(rt))) {
                break;
            }
        }

        if (rs == 31 && rt == 31) {
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
            if (getRandom().getLine(pc) == 328) {
                int j = 0;
            }
            if (pc <= getMips().getPc()) {
                //如果向回跳转，则需要判断是否死循环
                Mips testMips = getMips().clone();
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
                    //如果回到本条指令且仍然跳转，则判定为死循环
                    if (isJump(testMips.getReg(rs), testMips.getReg(rt))) {
                        continue;
                    } else {
                        //写回状态
                        getMips().cpy(testMips);
                        npc = getMips().getPc() + 8;
                    }
                } else {
                    //如果运行失败，则停止的位置应该已经有指令
                    if (getMips().getCodeStr().get(testMips.getPc() + 4) != null ||
                            getMips().getCodeStr().get(testMips.getPc()) != null) {
                        continue;
                    }
                    //写回状态
                    getMips().cpy(testMips);
                    //如果停留的地方在指令的前面，则进入一个空块，将这个块声明为beq
                    if (testMips.getPc() < getMips().getPc()) {
                        getMips().setBlock("beq", getMips().getPc() + 8);
                    }
                    npc = testMips.getPc();
                }
            } else {
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

            String codeStr = String.format("%s $%d, $%d, line%d", type, rs, rt, getRandom().getLine(pc));
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
        String str = getOpcode();
        Pattern pattern = Pattern.compile(".* \\$(\\d*), \\$(\\d*), line(\\d*)");
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

    /**
     * 判断是否跳转
     * @param rsVal rs寄存器值
     * @param rtVal rt寄存器值
     * @return 结果
     */
    public abstract boolean isJump(long rsVal, long rtVal);

    /**
     * 获取opcode
     * @return opcode
     */
    public abstract String getOpcode();
}
