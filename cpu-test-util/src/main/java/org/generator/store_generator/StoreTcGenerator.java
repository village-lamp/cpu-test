package org.generator.store_generator;

import org.constant.CommonConstant;
import org.generator.Generator;
import org.generator.cal_ri_generator.OriGenerator;
import org.mips.Mips;
import org.util.RandomUtil;

public class StoreTcGenerator extends Generator implements CommonConstant {

    public StoreTcGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        if (getMips().isDelaySlot()) {
            return;
        }

        if (getMips().getTc0().isStart() || getMips().getTc1().isStart()) {
            return;
        }

        int pc = getMips().getPc();
        for (int i = pc + 4; i <= pc + 24; i += 4) {
            if (getMips().getCodeStr().get(i) != null) {
                return;
            }
            if (getMips().getInterrupts().contains(i - 4)) {
                return;
            }
        }

        if (getMips().getPc() >= PC_END - 100) {
            return;
        }

        OriGenerator oriGenerator = new OriGenerator(getMips(), getRandom());
        SwGenerator swGenerator = new SwGenerator(getMips(), getRandom());

        //生成第一个ori
        int rt = getRandom().randomMid(false);
        int imm = getRandom().randInt(1, 4);
        getRandom().update(rt);
        String codeStr = String.format("ori $%d, $0, %d", rt, imm);
        getMips().putCodeStr(codeStr);
        getMips().putCode(oriGenerator.translate(codeStr));
        getMips().check();

        //生成第一个sw
        int offset;
        if (getRandom().randInt(0, 1) == 0) {
            if ((getMips().getCp0().getIm() & 0b1) == 0) {
                return;
            }
            offset = TC0_BEGIN + 4;
            getMips().getTc0().setStart(true);
        } else {
            if ((getMips().getCp0().getIm() & 0b10) == 0) {
                return;
            }
            offset = TC1_BEGIN + 4;
            getMips().getTc1().setStart(true);
        }
        codeStr = String.format("sw $%d, %d($0)", rt, offset);
        getMips().putCodeStr(codeStr);
        getMips().putCode(swGenerator.translate(codeStr));
        getMips().check();

        //生成第二个ori
        rt = getRandom().randomMid(false);
        imm = 0b1001;
        getRandom().update(rt);
        codeStr = String.format("ori $%d, $0, %d", rt, imm);
        getMips().putCodeStr(codeStr);
        getMips().putCode(oriGenerator.translate(codeStr));
        getMips().check();

        //生成第二个sw
        offset -= 4;
        codeStr = String.format("sw $%d, %d($0)", rt, offset);
        getMips().putCodeStr(codeStr);
        getMips().putCode(swGenerator.translate(codeStr));
        getMips().check();
    }

    @Override
    public String translate(String codeStr) {
        return null;
    }
}
