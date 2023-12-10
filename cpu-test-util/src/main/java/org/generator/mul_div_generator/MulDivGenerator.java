package org.generator.mul_div_generator;

import org.mips.Mips;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mul_div类指令生成器抽象类
 * 使用所有寄存器
 */
public abstract class MulDivGenerator extends Generator {

    private final String type;

    public MulDivGenerator(Mips mips, RandomUtil random, String type) {
        super(mips, random);
        this.type = type;
    }

    @Override
    public void generate() {
        int rs = getRandom().randomReg(true);
        int rt = getRandom().randomReg(true);
        String codeStr = String.format("%s $%d, $%d", type, rs, rt);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        if (getMips().isDelaySlot()) {
            getMips().setDelaySlot(false);
            return;
        }
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = "000000";
        Pattern pattern =Pattern.compile(".* \\$(\\d*), \\$(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                    MipsCode.getReg(Integer.parseInt(matcher.group(2)));
        }
        str += "0000000000";
        str += getFunct();
        return str;
    }

    /**
     * 获取funct值
     * @return “00000” + funct字符串
     */
    public abstract String getFunct();
}
