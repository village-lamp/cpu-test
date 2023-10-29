package org.data_generator.generator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * beq指令生成器类
 */
public class BeqGenerator extends Generator implements Constant {

    @Override
    public void generate(FileOutputStream o) throws IOException {
        int rs = randReg();
        int rt = randReg();
        int offset = randImm();
        int ban = getBan();
        offset >>= 2;
        if (offset < 0) {
            String add = String.format("ori $%d, $0, 1\n" +
                    "sub $%d, $0, $%d\n" +
                    "beq $0, $0, 1\n",
                    ban, ban, ban);
            setPc(getPc() + 12);
            o.write(add.getBytes());
            offset -= 3;
        }
        String str = String.format("beq $%d, $%d, %d\r\n", rs, rt, offset);
        setPc(getPc() + 4);
        o.write(str.getBytes());
    }

    @Override
    public int randImm() {
        int pc = getPc();
        int value = randInt(PC_BEGIN, PC_END - 32);
        value = value & (0x0000fffc);
        return value - pc - 4;
    }
}
