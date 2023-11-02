package org.data_generator.generator;

import org.data_generator.Manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 生成器抽象类
 */
public abstract class Generator {
    private static int counter = randInt(1, 29);

    public abstract void generate(ArrayList<Integer> list);

    /**
     * 在一定范围内生成随机的整数
     * @param l 左边界（取）
     * @param r 右边界（取）
     * @return 生成的整数
     */
    public static int randInt(int l, int r) {
        return Manager.getRandom().nextInt(r - l + 1) + l;
    }

    /**
     * 生成随机的寄存器编号
     * @return 寄存器编号
     */
    public static int randReg() {
        int reg;
        do {
            reg = randInt(0, 29);
        } while(reg == counter);
        return reg;
    }

    /**
     * 生成16位无符号立即数
     * @return 立即数
     */
    public static int randUnsignedImm() {
        return randInt(0, 0xffff);
    }

    public static int getCounter() {
        return counter;
    }
}
