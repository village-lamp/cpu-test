package org.data_generator;

import java.util.*;

/**
 * 数据生成
 */
public class DataGenerator {

    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = new String[1];
            System.out.println("输入指令存放地址：");
            args[0] = scanner.nextLine();
            //args[0] = ".";
        }
        Manager.work(args[0]);
    }
}