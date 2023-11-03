package org.auto_test_verilog;

import java.io.IOException;
import java.util.Scanner;

public class AutoTestVerilog {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = new String[2];
            //System.out.println("输入test.txt文件路径");
            //args[0] = scanner.nextLine();
            //System.out.println("输入out.txt文件路径");
            //args[1] = scanner.nextLine();
            args[0] = "D:\\programming\\gitrepository\\github\\cpu-test\\package\\resources\\mips\\code.txt";
            args[1] = "D:\\programming\\gitrepository\\github\\cpu-test\\package\\resources\\mips\\out.txt";
        }
        Manager.work(args);
    }
}
