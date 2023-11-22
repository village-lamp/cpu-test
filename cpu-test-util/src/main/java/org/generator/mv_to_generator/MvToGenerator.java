package org.generator.mv_to_generator;

import org.Mips;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mv_to类指令生成器抽象类
 * 使用所有寄存器
 */
public abstract class MvToGenerator extends Generator {

    private final String type;

    public MvToGenerator(Mips mips, RandomUtil random, String type) {
        super(mips, random);
        this.type = type;
    }

    @Override
    public void generate() {
        int rS = getRandom().randomReg(true);
        String codeStr = String.format("%s $%d", type, rS);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = "000000";
        Pattern pattern =Pattern.compile(".* \\$(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(1)));
        }
        str += "000000000000000";
        str += getFunct();
        return str;
    }

    /**
     * 获取funct值
     * @return “00000” + funct字符串
     */
    public abstract String getFunct();
}
