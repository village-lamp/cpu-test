package org.check_answer_P3;

import java.io.IOException;
import java.util.Scanner;

/**
 * 答案检验类
 */
public class CheckAnswer {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            args = new String[3];
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入结果文件路径：");
            args[0] = scanner.nextLine();
            System.out.println("输入初级指令文件路径：");
            args[1] = scanner.nextLine();
            System.out.println("输入指令码文件路径：");
            args[2] = scanner.nextLine();
        }
        Manager.getManager().work(args);
    }
}
