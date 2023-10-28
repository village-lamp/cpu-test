package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class OriGenerator extends Generator {

    @Override
    public void generate(FileOutputStream o) throws IOException {
        int rs = randReg();
        int rt = randReg();
        int imm = randImm();
        imm += 0x8000;
        String str = String.format("ori $%d, $%d, %d\r\n", rt, rs, imm);
        setPc(getPc() + 4);
        o.write(str.getBytes());
    }
}
