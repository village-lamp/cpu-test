package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;

public class AddGenerator extends Generator {

    @Override
    public void generate(FileOutputStream o) throws IOException {
        int rs = randReg();
        int rt = randReg();
        int rd = randReg();
        String str = String.format("add $%d, $%d, $%d\r\n", rd, rs, rt);
        setPc(getPc() + 4);
        o.write(str.getBytes());
    }
}
