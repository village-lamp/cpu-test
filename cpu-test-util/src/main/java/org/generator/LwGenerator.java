package org.generator;

import org.Mips;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * lw指令生成器
 * base使用低级寄存器
 * rt使用高级寄存器
 */
public class LwGenerator extends Generator {

    public LwGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        int base;
        //获取低中级寄存器
        do {
            base = getRandom().randomReg(true);
        } while ("high".equals(getRandom().getRegType(base)));
        int rt = getRandom().randomHigh(false);
        int baseVal = (int) getMips().getReg(base);
        int offset = getRandom().randomDm(baseVal);
        if (Math.abs(offset) >= 0x7fff) {
            return;
        }
        String codeStr = String.format("lw $%d, %d($%d)", rt, offset, base);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getRandom().updateHigh(rt);
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = "100011";
        Pattern pattern =Pattern.compile("lw \\$(\\d*), ([-\\d]*)\\(\\$(\\d*)\\)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(3))) +
                    MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                    MipsCode.getImm16(Integer.parseInt(matcher.group(2)));
        }
        return str;
    }
}
