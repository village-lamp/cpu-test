package org.data_generator.generator;

import org.data_generator.Manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * lw指令生成器类
 */
public class LwGenerator extends Generator {

    private static final ArrayList<Integer> id = new ArrayList<>();

    @Override
    public void generate(ArrayList<Integer> list) {
        int base = randReg();
        while (base == 0) {
            base = randReg();
        }
        int rt = randReg();
        int index;
        if (id.isEmpty()) {
            index = 0;
        } else {
            index = id.get(randInt(0, id.size() - 1));
        }
        index <<= 2;
        int offset = randInt(Math.max(-65535 + index, -32768), index);
        int baseValue = index - offset;
        OriGenerator oriGenerator = new OriGenerator();
        oriGenerator.generate(new ArrayList<>(Arrays.asList(0, base, baseValue)));
        Manager.getCode().add(String.format("lw $%d, %d($%d)", rt, offset, base));
        Manager.setPc(Manager.getPc() + 4);
    }

    public static ArrayList<Integer> getId() {
        return id;
    }
}
