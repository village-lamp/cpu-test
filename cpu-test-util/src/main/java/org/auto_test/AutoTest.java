package org.auto_test;

import java.util.Scanner;

/**
 * 自动测试类
 */
public class AutoTest {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            args = new String[3];
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入电路文件路径：");
            args[0] = scanner.nextLine();
            System.out.println("输入指令文件路径：");
            args[1] = scanner.nextLine();
            System.out.println("输入结果存放路径：");
            args[2] = scanner.nextLine();
        }
        Manager.getManager().work(args);
    }
}