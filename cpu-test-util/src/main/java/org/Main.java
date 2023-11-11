package org;

import org.data_generator.DataGenerator;
import org.depress_mips.DepressMips;

/**
 * 主类，用于判断参数是否正确
 */

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
            case "run":
                if (args.length == 2) {
                    DepressMips.main(new String[]{args[1]});
                } else {
                    System.out.println("参数错误，输入java -jar *.jar help来获取用法");
                }
                break;
            case "help":
                System.out.println("help\t\t获取用法\ngenerate\t生成测试文件\n\t\t参数：存放生成的test.asm的路径\n" +
                        "test " +
                        "run\t\t运行，重编文件\n\t\t参数1：压缩包文件");
                break;
            default:
                System.out.println("参数错误，输入java -jar *.jar help来获取用法");
        }
    }
}
