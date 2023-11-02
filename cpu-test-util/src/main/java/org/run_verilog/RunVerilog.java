package org.run_verilog;

import java.util.Scanner;

public class RunVerilog {
    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = new String[2];
            /*System.out.println("输入zip文件路径");
            args[0] = scanner.nextLine();
            System.out.println("输入test.asm文件路径");
            args[1] = scanner.nextLine();*/
            args[0] = "./mips.zip";
            args[1] = ".";
        }
        Manager.work(args);
    }
}
