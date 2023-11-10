package org.generator;

import org.Mips;
import org.constant.CommonConstant;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * sw指令生成器
 * base使用低级寄存器
 * rt使用高级寄存器
 */
public class SwGenerator extends Generator implements CommonConstant {

    public SwGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        int base = getRandom().randomLow(true);
        int rt = getRandom().randomHigh(true);
        int baseVal = (int) getMips().getReg(base);
        int addr = getRandom().randInt(Math.max(0, -0x7fff + baseVal),
                Math.min(DM_END, 0x7fff + baseVal)) & 0xfffffffc;
        int offset = addr - baseVal;
        String codeStr = String.format("sw $%d, %d($%d)", rt, offset, base);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getRandom().addValueToDm(addr);
        getRandom().updateHigh(rt);
        getRandom().updateLow(baseVal);
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = "101011";
        Pattern pattern =Pattern.compile("sw \\$(\\d*), (\\d*)\\((\\$\\d*)\\)");
        Matcher matcher = pattern.matcher(str);
        str += MipsCode.getReg(Integer.parseInt(matcher.group(2))) +
                MipsCode.getReg(Integer.parseInt(matcher.group(0))) +
                MipsCode.getImm16(Integer.parseInt(matcher.group(1)));
        return str;
    }
}