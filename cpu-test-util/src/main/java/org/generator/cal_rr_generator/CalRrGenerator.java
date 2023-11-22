package org.generator.cal_rr_generator;

import org.Mips;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * cal_rr类指令生成器
 * cal_rr类指令使用所有寄存器
 */
public abstract class CalRrGenerator extends Generator {

    private final String type;

    public CalRrGenerator(Mips mips, RandomUtil random, String type) {
        super(mips, random);
        this.type = type;
    }

    @Override
    public void generate() {
        //生成寄存器，rs和rt都需要构造冒险
        int rd = getRandom().randomReg(false);
        int rs = getRandom().randomReg(true, rd);
        int rt;
        //rs与rt不相同
        do {
            rt = getRandom().randomReg(true, rd);
        } while(rt == rs);
        if (!getRandom().isLegal(rd, calc(rs, rt))) {
            return;
        }
        //更新高级寄存器
        getRandom().update(rd);
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
        str += "00000";
        str += getFunct();
        return str;
    }

    /**
     * 获取funct值
     * @return “00000” + funct字符串
     */
    public abstract String getFunct();

    /**
     * 计算指令结果
     * @return 结果
     */
    public abstract long calc(int rs, int rt);
}
