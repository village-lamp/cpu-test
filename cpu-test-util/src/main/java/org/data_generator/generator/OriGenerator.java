package org.data_generator.generator;

import org.data_generator.Manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ori指令生成器类
 */
public class OriGenerator extends Generator {

    @Override
    public void generate(ArrayList<Integer> list) {
        int rs = randReg();
        int rt = randReg();
        int imm = randUnsignedImm();
        if (list != null) {
            rs = list.get(0);
            rt = list.get(1);
            imm = list.get(2);
        }
        Manager.getCode().add(String.format("ori $%d, $%d, %d", rt, rs, imm));
        Manager.setPc(Manager.getPc() + 4);
    }
}
