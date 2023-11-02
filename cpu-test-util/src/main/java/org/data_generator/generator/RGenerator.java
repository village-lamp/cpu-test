package org.data_generator.generator;

import org.data_generator.Manager;

import java.util.ArrayList;

public class RGenerator {

    public static void generator(ArrayList<Integer> list, String type) {
        int rs = Generator.randReg();
        int rt = Generator.randReg();
        int rd = Generator.randReg();
        if (list != null) {
            rs = list.get(0);
            rt = list.get(1);
            rd = list.get(2);
        }
        Manager.getCode().add(String.format("%s $%d, $%d, $%d", type, rd, rs, rt));
        Manager.setPc(Manager.getPc() + 4);
    }
}
