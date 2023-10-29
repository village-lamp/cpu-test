package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * lui指令生成器类
 */
public class LuiGenerator extends Generator {

    @Override
    public void generate(FileOutputStream o) throws IOException {
        int rt = randReg();
        int imm = randImm();
        imm += 0x8000;
        String str = String.format("lui $%d, %d\r\n", rt, imm);
        setPc(getPc() + 4);
        o.write(str.getBytes());
    }
}
