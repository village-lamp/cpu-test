package org.data_generator.generator;

import org.data_generator.Manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * lui指令生成器类
 */
public class LuiGenerator extends Generator {

    @Override
    public void generate(ArrayList<Integer> list) {
        int rt = randReg();
        int imm = randUnsignedImm();
        if (list != null) {
            rt = list.get(0);
            imm = list.get(1);
        }
        Manager.getCode().add(String.format("lui $%d, %d", rt, imm));
        Manager.setPc(Manager.getPc() + 4);
    }
}
