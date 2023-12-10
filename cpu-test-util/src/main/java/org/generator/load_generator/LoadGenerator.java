package org.generator.load_generator;

import org.mips.Mips;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * load类指令生成器抽象类
 * rs使用低中级寄存器，rt使用高级寄存器
 */
public abstract class LoadGenerator extends Generator {

    private final String type;

    public LoadGenerator(Mips mips, RandomUtil random, String type) {
        super(mips, random);
        this.type = type;
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
        int offset = getRandom().randomDm(baseVal, rt);
        offset += randomBits();
        if (Math.abs(offset) >= 0x7fff) {
            return;
        }
        String codeStr = String.format("%s $%d, %d($%d)", type, rt, offset, base);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getRandom().update(rt);
        if (getMips().isDelaySlot()) {
            getMips().setDelaySlot(false);
            return;
        }
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        String str = getOpcode();
        Pattern pattern =Pattern.compile(".* \\$(\\d*), ([-\\d]*)\\(\\$(\\d*)\\)");
        Matcher matcher = pattern.matcher(codeStr);
        if (matcher.find()) {
            str += MipsCode.getReg(Integer.parseInt(matcher.group(3))) +
                    MipsCode.getReg(Integer.parseInt(matcher.group(1))) +
                    MipsCode.getImm16(Integer.parseInt(matcher.group(2)));
        }
        return str;
    }

    /**
     * 获取opcode
     * @return opcode
     */
    public abstract String getOpcode();

    /**
     * 随机取位
     * @return 小位移
     */
    public abstract int randomBits();
}
