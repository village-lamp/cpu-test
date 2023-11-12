package org.run_asm;

import java.util.Scanner;

/**
 * 运行代码
 */
public class RunAsm {

    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = new String[1];
            System.out.println("输入code.txt存放路径");
            args[0] = scanner.nextLine();
        }
        Manager.work(args);
    }
}
