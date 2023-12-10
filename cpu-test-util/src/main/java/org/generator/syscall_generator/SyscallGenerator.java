package org.generator.syscall_generator;

import org.generator.Generator;
import org.mips.Mips;
import org.util.MipsCode;
import org.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyscallGenerator extends Generator {

    public SyscallGenerator(Mips mips, RandomUtil random) {
        super(mips, random);
    }

    @Override
    public void generate() {
        String codeStr = "syscall";
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
        return "00000000000000000000000000001100";
    }
}
