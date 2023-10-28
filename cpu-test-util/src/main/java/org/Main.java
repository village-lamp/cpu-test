package org;

import org.auto_test.AutoTest;
import org.data_generator.DataGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("缺少参数，输入java -jar *.jar help来获取用法");
            return;
        }
        switch (args[0]) {
            case "generate":
                if (args.length == 2) {
                    DataGenerator.main(new String[]{args[1]});
                } else {
                    System.out.println("参数错误，输入java -jar *.jar help来获取用法");
                }
                break;
            case "test":
                if (args.length == 4) {
                    AutoTest.main(new String[]{args[1], args[2], args[3]});
                } else {
                    System.out.println("参数错误，输入java -jar *.jar help来获取用法");
                }
                break;
            case "help":
                System.out.println("help\t获取用法\ngenerate\t生成测试文件\n\t\t参数：存放生成的test.asm以及testfirst.asm的路径\n" +
                        "test\t测试电路，生成测试批文件\n\t\t参数1：电路文件路径\n\t\t参数2：测试文件路径\n\t\t参数3：存放结果文件");
                break;
            default:
                System.out.println("参数错误，输入java -jar *.jar help来获取用法");
                break;
        }
    }
}
