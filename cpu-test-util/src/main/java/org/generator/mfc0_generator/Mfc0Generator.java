package org.generator.mfc0_generator;

import org.generator.Generator;
import org.mips.Mips;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mfc0生成器类
 */
public class Mfc0Generator extends Generator {

    public Mfc0Generator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        int rt = getRandom().randomHigh(false);
        int rd = 12;
        String codeStr = String.format("mfc0 $%d, $%d", rt, rd);
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
        String str = "010000";
        str += "00000";
        Pattern pattern =Pattern.compile(".* \\$(\\d*), \\$(\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(1)));
            str += MipsCode.getReg(Integer.parseInt(matcher.group(2)));
        }
        str += "00000000000";
        return str;
    }
}
