package org.auto_test_verilog.Check;

import org.auto_test_verilog.Manager;
import org.auto_test_verilog.Util.Hex;

import java.util.HashMap;

public class SwCheck extends Check {

    @Override
    public String generate(String code) {
        Hex im = new Hex();
        im.set(code);
        int base = getRs(im);
        int rt = getRt(im);
        int offset = getImm16(im);
        HashMap<Integer, Long> regs = Manager.getRegs();
        long addr = regs.get(base) + offset;
        Manager.addPc(4);
        return writeToGrf(Manager.getPc(), rt, Manager.getDm().get((int) addr >> 2));
    }
}
