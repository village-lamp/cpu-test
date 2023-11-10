package org.check;

import org.auto_test_verilog.Manager;
import org.util.Hex;

import java.util.HashMap;

public class LuiCheck extends Check {

    @Override
    public String generate(String code) {
        Hex im = new Hex();
        im.set(code);
        int rt = getRt(im);
        long imm = getImm16(im);
        HashMap<Integer, Long> regs = Manager.getRegs();
        long data = over(imm << 16);
        Manager.addPc(4);
        return writeToGrf(Manager.getPc() - 4, rt, data);
    }
}