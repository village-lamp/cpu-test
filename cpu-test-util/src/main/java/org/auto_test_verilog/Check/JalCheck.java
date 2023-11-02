package org.auto_test_verilog.Check;

import org.auto_test_verilog.Manager;
import org.auto_test_verilog.Util.Hex;

import java.util.HashMap;
import java.util.Objects;

public class JalCheck extends Check {

    @Override
    public String generate(String code) {
        Hex im = new Hex();
        im.set(code);
        long offset = getImm26(im);
        Manager.setPc(((Manager.getPc() >> 28) << 28) | (offset << 2));
        return null;
    }
}
