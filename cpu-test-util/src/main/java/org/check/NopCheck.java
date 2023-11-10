package org.check;

import org.auto_test_verilog.Manager;

public class NopCheck extends Check {

    @Override
    public String generate(String code) {
        Manager.addPc(4);
        return null;
    }
}
