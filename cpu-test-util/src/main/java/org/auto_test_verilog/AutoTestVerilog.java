package org.auto_test_verilog;

import java.io.IOException;
import java.util.Scanner;

public class AutoTestVerilog {
    public static void main(String[] args) throws IOException {
        /*if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = new String[2];
            System.out.println("输入test.txt文件");
            args[0] = scanner.nextLine();
            System.out.println("输入out.txt文件");
            args[1] = scanner.nextLine();
        }*/
        Manager.work(args);
    }
}
