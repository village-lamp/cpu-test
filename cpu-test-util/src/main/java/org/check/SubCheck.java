package org.check;

import org.auto_test_verilog.Manager;
import org.util.Hex;

import java.util.HashMap;

public class SubCheck extends Check {

    @Override
    public String generate(String code) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        int rd = getRd(im);
        HashMap<Integer, Long> regs = Manager.getRegs();
        long data = over(regs.get(rs) - regs.get(rt));
        Manager.addPc(4);
        return writeToGrf(Manager.getPc() - 4, rd, data);
    }
}