package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * sw指令生成器类
 */
public class SwGenerator extends Generator {

    @Override
    public void generate(FileOutputStream o) throws IOException {
        int rt = randReg();
        int offset = randInt(0, 0x2ffe);
        offset = (offset / 4) * 4;
        String str = String.format("sw $%d, %d($0)\r\n", rt, offset);
        LwGenerator.getId().add(offset);
        setPc(getPc() + 4);
        o.write(str.getBytes());
    }
}
