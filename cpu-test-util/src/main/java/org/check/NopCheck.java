package org.check;

import org.Mips;

public class NopCheck extends Check {

    @Override
    public String generate(String code, Mips mips) {
        mips.addPc(4);
        return null;
    }
}
