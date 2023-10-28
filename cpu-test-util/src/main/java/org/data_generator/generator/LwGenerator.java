package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LwGenerator extends Generator {

    private static final ArrayList<Integer> id = new ArrayList<>();

    @Override
    public void generate(FileOutputStream o) throws IOException {
        int base = randReg();
        int rt = randReg();
        int offset = 0;
        if (id.isEmpty()) {
            base = 0;
        } else {
            int index = randInt(0, id.size() - 1);
            int value = id.get(index);
            int baseVal = randInt(0, 0x7fff - value);
            if (base == 0) {
                baseVal = 0;
            }
            baseVal = (baseVal / 4) * 4;
            offset = value - baseVal;
            String str1 = String.format("ori $%d, $0, %d\r\n", base, baseVal);
            o.write(str1.getBytes());
            setPc(getPc() + 4);
        }
        String str = String.format("lw $%d, %d($%d)\r\n", rt, offset, base);
        setPc(getPc() + 4);
        o.write(str.getBytes());
    }

    public static ArrayList<Integer> getId() {
        return id;
    }
}
