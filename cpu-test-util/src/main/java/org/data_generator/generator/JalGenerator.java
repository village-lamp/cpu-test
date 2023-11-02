package org.data_generator.generator;

import org.data_generator.Manager;

import java.util.ArrayList;

public class JalGenerator extends Generator {

    @Override
    public void generate(ArrayList<Integer> list) {
        Manager.getCode().add("jal block" + Manager.getBlocks());
        Manager.setPc(Manager.getPc() + 4);
        Manager.setLastBeq(Manager.getPc());
    }
}
