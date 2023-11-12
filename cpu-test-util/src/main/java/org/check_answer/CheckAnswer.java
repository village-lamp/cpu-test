package org.check_answer;

import java.util.Scanner;

/**
 * 验证答案
 */
public class CheckAnswer {

    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = new String[2];
            System.out.println("输入输出结果：");
            args[0] = scanner.nextLine();
            System.out.println("输入正确结果：");
            args[1] = scanner.nextLine();
        }
        Manager.work(args);
    }
}
