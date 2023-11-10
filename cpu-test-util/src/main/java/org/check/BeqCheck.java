package org.check;

import org.auto_test_verilog.Manager;
import org.util.Hex;

import java.util.HashMap;
import java.util.Objects;

public class BeqCheck extends Check {

    @Override
    public String generate(String code) {
        Hex im = new Hex();
        im.set(code);
        int rs = getRs(im);
        int rt = getRt(im);
        short offset = (short) getImm16(im);
        HashMap<Integer, Long> regs = Manager.getRegs();
        if (Objects.equals(regs.get(rs), regs.get(rt))) {
            Manager.addPc(((int) offset + 1) << 2);
        }
        else {
            Manager.addPc(4);
        }
        return null;
    }
}
