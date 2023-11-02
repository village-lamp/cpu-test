package org.data_generator.generator;

import org.data_generator.Manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * sw指令生成器类
 */
public class SwGenerator extends Generator {

    @Override
    public void generate(ArrayList<Integer> list) {
        int base = randReg();
        while (base == 0) {
            base = randReg();
        }
        int rt = randReg();
        int index = randInt(0, 0xbff);
        LwGenerator.getId().add(index);
        index <<= 2;
        int offset = randInt(Math.max(-0xffff + index, -0x1000), index);
        int baseValue = index - offset;
        OriGenerator oriGenerator = new OriGenerator();
        oriGenerator.generate(new ArrayList<>(Arrays.asList(0, base, baseValue)));
        Manager.getCode().add(String.format("sw $%d, %d($%d)", rt, offset, base));
        Manager.setPc(Manager.getPc() + 4);
    }
}
