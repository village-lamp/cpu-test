package org.generator.store_generator;

import org.Mips;
import org.constant.CommonConstant;
import org.generator.Generator;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * store类指令生成器抽象类
 * rs使用低中级寄存器，rt使用高级寄存器
 */
public abstract class StoreGenerator extends Generator implements CommonConstant {

    private final String type;

    public StoreGenerator(Mips mips, RandomUtil random, String type) {
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
        int rt = getRandom().randomReg(true);
        int baseVal = (int) getMips().getReg(base);
        if (Math.max(4, -0x7fff + baseVal) > Math.min(DM_END, 0x7fff + baseVal)) {
            return;
        }

        //随机地址
        int addr = getRandom().randInt(Math.max(4, -0x7fff + baseVal),
                Math.min(DM_END, 0x7fff + baseVal));
        addr = alignAddr(addr);
        int offset = addr - baseVal;
        String codeStr = String.format("%s $%d, %d($%d)", type, rt, offset, base);
        getMips().putCodeStr(codeStr);
        getMips().putCode(translate(codeStr));
        getRandom().addValueToDm(addr & 0xfffffffc, getRandom().getRegType(rt));
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
     * 对齐地址
     * @param addr 对齐前的地址
     * @return 对齐后的地址
     */
    public abstract int alignAddr(int addr);
}
