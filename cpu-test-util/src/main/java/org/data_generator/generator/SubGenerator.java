package org.data_generator.generator;

import org.data_generator.Manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * sub指令生成器类
 */
public class SubGenerator extends Generator{

    @Override
    public void generate(ArrayList<Integer> list) {
        RGenerator.generator(list, "sub");
    }
}
