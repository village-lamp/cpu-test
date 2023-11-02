package org.data_generator.generator;

import org.data_generator.Manager;

import java.util.ArrayList;

public class JrGenerator extends Generator {

    @Override
    public void generate(ArrayList<Integer> list) {
        Manager.getCode().add("jr $ra");
        Manager.setPc(Manager.getPc() + 4);
    }
}
