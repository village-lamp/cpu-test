package org;

import org.check_answer.CheckAnswer;
import org.data_generator.DataGenerator;
import org.depress_mips.DepressMips;
import org.run_asm.RunAsm;

/**
 * 主类，用于判断参数是否正确
 */

public class Main {

    public static void main(String[] args) {
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
            case "depress":
                if (args.length == 2) {
                    DepressMips.main(new String[]{args[1]});
                } else {
                    System.out.println("参数错误，输入java -jar *.jar help来获取用法");
                }
                break;
            case "run":
                if (args.length == 2) {
                    RunAsm.main(new String[]{args[1]});
                } else {
                    System.out.println("参数错误，输入java -jar *.jar help来获取用法");
                }
                break;
            case "check":
                if (args.length == 3) {
                    CheckAnswer.main(new String[]{args[1], args[2]});
                } else {
                    System.out.println("参数错误，输入java -jar *.jar help来获取用法");
                }
                break;
            case "help":
                System.out.println("help\t\t获取用法\ngenerate\t生成测试文件\n\t\t参数：存放生成的test.asm的路径\n" +
                        "run\t\t运行txt,获取正确答案\n\t\t参数：test.txt文件路径\n" +
                        "depress\t解压，重编文件\n\t\t参数：压缩包文件\n" +
                        "check\t\t检查答案\n\t\t参数1：输出结果\n\t\t参数2：正确结果");
                break;
            default:
                System.out.println("参数错误，输入java -jar *.jar help来获取用法");
        }
    }
}
