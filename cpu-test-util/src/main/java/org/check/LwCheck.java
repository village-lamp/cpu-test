package org.check;

import org.auto_test_verilog.Manager;
import org.util.Hex;

import java.util.HashMap;

public class LwCheck extends Check {

    @Override
    public String generate(String code) {
        Hex im = new Hex();
        im.set(code);
        int base = getRs(im);
        int rt = getRt(im);
        int offset = getImm16(im);
        HashMap<Integer, Long> regs = Manager.getRegs();
        long addr = regs.get(base) + offset;
        addr = addr % 0x10000L;
        Manager.addPc(4);
        return writeToGrf(Manager.getPc() - 4, rt, Manager.getDm().get((int) addr >> 2));
    }
}
