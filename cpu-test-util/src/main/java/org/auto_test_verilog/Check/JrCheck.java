package org.auto_test_verilog.Check;

import org.auto_test_verilog.Manager;
import org.auto_test_verilog.Util.Hex;

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
