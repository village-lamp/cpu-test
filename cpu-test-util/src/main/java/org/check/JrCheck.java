package org.check;

import org.auto_test_verilog.Manager;
import org.util.Hex;

public class JrCheck extends Check {

    @Override
    public String generate(String code) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        Manager.setPc(Manager.getRegs().get(rs));
        return null;
    }
}
