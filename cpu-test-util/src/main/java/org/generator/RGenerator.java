package org.generator;

import org.Mips;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * R类指令生成器
 * R类指令只使用高级寄存器
 */
public abstract class RGenerator extends Generator {

    private final String type;

    public RGenerator(Mips mips, RandomUtil random, String type) {
        super(mips, random);
        this.type = type;
    }

    @Override
    public void generate() {
        //生成寄存器，rs和rt都需要构造冒险
        int rs = getRandom().randomHigh(true);
        int rt;
        //rs与rt不相同
        do {
            rt = getRandom().randomHigh(true);
        } while(rt == rs);
        int rd = getRandom().randomHigh(false);
        //更新高级寄存器
        getRandom().updateHigh(rd);
        String codeStr = String.format("%s $%d, $%d, $%d", type, rd, rs, rt);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = "000000";
        Pattern pattern =Pattern.compile(".* \\$(\\d*), \\$(\\d*), \\$(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(2))) +
                    MipsCode.getReg(Integer.parseInt(matcher.group(3))) +
                    MipsCode.getReg(Integer.parseInt(matcher.group(1)));
        }
        str += getFunct();
        return str;
    }

    /**
     * 获取funct值
     * @return “00000” + funct字符串
     */
    public abstract String getFunct();
}
