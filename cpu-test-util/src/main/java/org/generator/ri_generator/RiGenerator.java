package org.generator.ri_generator;

import org.check.Checker;
import org.generator.Generator;
import org.mips.Mips;
import org.util.Hex;
import org.util.RandomUtil;
import org.util.UnsignedInt;

public class RiGenerator extends Generator {

    public RiGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        long code = getRandom().getRandom().nextLong();
        code = (code < 0) ? -code : code;
        code = UnsignedInt.over(code);
        Hex hexCode = Hex.toHex(code);
        if (!"RI".equals(Checker.analyse(hexCode.toString()))) {
            return;
        }
        String codeStr = "xor $0, $0, $0";
        getMips().putCodeStr(codeStr);
        getMips().putCode(Long.toBinaryString(code));
        if (getMips().isDelaySlot()) {
            getMips().setDelaySlot(false);
            return;
        }
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        return null;
    }
}
