package org.data_generator.generator;

import org.data_generator.Manager;

import java.util.ArrayList;

/**
 * add指令生成器类
 */
public class AddGenerator extends Generator {

    @Override
    public void generate(ArrayList<Integer> list) {
        RGenerator.generator(list, "add");
    }
}
