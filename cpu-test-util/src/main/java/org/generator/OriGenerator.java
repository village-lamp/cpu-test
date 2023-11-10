package org.generator;

import org.Mips;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ori指令生成器
 * ori指令可以作用于所有寄存器，但是每种寄存器对应的随机立即数不相同
 */
public class OriGenerator extends Generator {

    public OriGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        int rt = getRandom().randomReg(false);
        int rs = getRandom().randomReg(true, rt);
        int imm = getRandom().randomUnsignedImm(rt);
        getRandom().updateByType(rt);
        String codeStr = String.format("ori $%d, $%d, %d", rt, rs, imm);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = "001101";
        Pattern pattern =Pattern.compile("ori \\$(\\d*), \\$(\\d*), (\\d*)");
        Matcher matcher = pattern.matcher(codeStr);
        matcher.find();
        str += MipsCode.getReg(Integer.parseInt(matcher.group(2))) +
                MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                MipsCode.getImm16(Integer.parseInt(matcher.group(3)));
        return str;
    }
}
