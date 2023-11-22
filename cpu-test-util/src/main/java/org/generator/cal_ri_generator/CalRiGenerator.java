package org.generator.cal_ri_generator;

import org.Mips;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * cal_ri类指令生成器抽象类
 * 使用所有寄存器
 */
public abstract class CalRiGenerator extends Generator {

    private final String type;

    public CalRiGenerator(Mips mips, RandomUtil random, String type) {
        super(mips, random);
        this.type = type;
    }

    @Override
    public void generate() {
        int rt = getRandom().randomReg(false);
        int rs = getRandom().randomReg(true, rt);
        int imm = getImm(rs);
        if (!getRandom().isLegal(rt, calc(rs, imm))) {
            return;
        }
        getRandom().update(rt);
        String codeStr = String.format("%s $%d, $%d, %d", type, rt, rs, imm);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = getOpcode();
        Pattern pattern =Pattern.compile(".* \\$(\\d*), \\$(\\d*), ([-\\d]*)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(2))) +
                    MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                    MipsCode.getImm16(Integer.parseInt(matcher.group(3)));
        }
        return str;
    }

    /**
     * 计算指令结果
     * @return 结果
     */
    public abstract long calc(int rs, int imm);

    /**
     * 获取opcode
     * @return opcode
     */
    public abstract String getOpcode();

    /**
     * 获取相应的立即数
     * @return 立即数
     */
    public abstract int getImm(int rs);
}
