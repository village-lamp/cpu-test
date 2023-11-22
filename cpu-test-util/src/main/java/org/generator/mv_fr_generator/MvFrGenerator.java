package org.generator.mv_fr_generator;

import org.Mips;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mv_fr类指令生成器抽象类
 * 只使用高级寄存器
 */
public abstract class MvFrGenerator extends Generator {

    private final String type;

    public MvFrGenerator(Mips mips, RandomUtil random, String type) {
        super(mips, random);
        this.type = type;
    }

    @Override
    public void generate() {
        int rd = getRandom().randomHigh(false);
        String codeStr = String.format("%s $%d", type, rd);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = "000000";
        str += "0000000000";
        Pattern pattern =Pattern.compile(".* \\$(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(1)));
        }
        str += "00000";
        str += getFunct();
        return str;
    }

    /**
     * 获取funct值
     * @return “00000” + funct字符串
     */
    public abstract String getFunct();
}
