package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class SwGenerator extends Generator {

    @Override
    public void generate(FileOutputStream o) throws IOException {
        int base = randReg();
        int rt = randReg();
        int baseVal = randInt(0, 0x7fff);
        if (base == 0) {
            baseVal = 0;
        }
        baseVal = (baseVal / 4) * 4;
        String str = String.format("ori $%d, $0, %d\r\n", base, baseVal);
        int offset = randInt(-baseVal, 0x2ffe - baseVal);
        offset = (offset / 4) * 4;
        str += String.format("sw $%d, %d($%d)\r\n", rt, offset, base);
        LwGenerator.getId().add(offset + baseVal);
        setPc(getPc() + 8);
        o.write(str.getBytes());
    }
}
