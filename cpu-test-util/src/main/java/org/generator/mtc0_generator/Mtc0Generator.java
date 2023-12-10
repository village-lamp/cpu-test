package org.generator.mtc0_generator;

import org.generator.Generator;
import org.mips.Mips;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mtc0指令生成器
 */
public class Mtc0Generator extends Generator {

    public Mtc0Generator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        int rt = getRandom().randomHigh(true);
        int rd = getRandom().randInt(13, 14);
        String codeStr = String.format("mtc0 $%d, $%d", rt, rd);
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
        str += "00100";
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
