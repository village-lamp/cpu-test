package org.generator;

import org.Mips;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * lui指令生成器
 * lui指令只使用高级寄存器
 */
public class LuiGenerator extends Generator {

    public LuiGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        int rt = getRandom().randomHigh(false);
        int imm = getRandom().randomUnsignedImm();
        getRandom().update(rt);
        String codeStr = String.format("lui $%d, %d", rt, imm);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = "001111";
        Pattern pattern =Pattern.compile("lui \\$(\\d*), (\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(0) +
                    MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                    MipsCode.getImm16(Integer.parseInt(matcher.group(2)));
        }
        return str;
    }
}
