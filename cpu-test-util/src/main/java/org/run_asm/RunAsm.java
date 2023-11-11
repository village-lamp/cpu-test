package org.run_asm;

import java.util.Scanner;

public class RunAsm {

    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = new String[1];
            System.out.println("输入test.txt存放路径");
            args[0] = scanner.nextLine();
        }
        Manager.work(args);
    }
}
