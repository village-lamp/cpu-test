package org.check;

import org.auto_test_verilog.Manager;
import org.util.Hex;

public class JalCheck extends Check {

    @Override
    public String generate(String code) {
        Hex im = new Hex();
        im.set(code);
        long offset = getImm26(im);
        String str = writeToGrf(Manager.getPc(), 31, Manager.getPc() + 8);
        Manager.setPc(((Manager.getPc() >> 28) << 28) | (offset << 2));
        return str;
    }
}
