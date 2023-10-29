package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * lw指令生成器类
 */
public class LwGenerator extends Generator {

    private static final ArrayList<Integer> id = new ArrayList<>();

    @Override
    public void generate(FileOutputStream o) throws IOException {
        int rt = randReg();
        int offset = 0;
        if (!id.isEmpty()) {
            int index = randInt(0, id.size() - 1);
            offset = id.get(index);
        }
        String str = String.format("lw $%d, %d($0)\r\n", rt, offset);
        setPc(getPc() + 4);
        o.write(str.getBytes());
    }

    public static ArrayList<Integer> getId() {
        return id;
    }
}
