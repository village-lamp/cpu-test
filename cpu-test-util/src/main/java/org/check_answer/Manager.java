package org.check_answer;

import org.constant.CommonConstant;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证答案
 */
public class Manager implements CommonConstant {

    /**
     * 验证答案
     * @param args 参数列表
     */
    public static void work(String[] args){
        analyseCode(args);
    }

    /**
     * 验证答案
     * @param args 参数列表
     */
    public static void analyseCode(String[] args){
        //输出结果
        String outPath = args[0];
        //标准输出结果
        String stdPath = args[1];

        try {
            ArrayList<String> stdOut = (ArrayList<String>) Files.readAllLines(Paths.get(stdPath));
            ArrayList<String> out = (ArrayList<String>) Files.readAllLines(Paths.get(outPath));
            int pos = -1;
            for (String str : stdOut) {
                //得到下一条有效输出
                pos = getNextOut(out, pos);
                if (pos >= out.size()) {
                    System.out.printf("行数少于标准答案，期望输出%s，实际输出为空\n", str);
                    return;
                }
                String answer = out.get(pos);
                answer = deleteTime(answer);
                int nPos = getNextOut(out, pos);

                //同一时刻的输出，dm会在grf前面，可能导致顺序的颠倒
                if (nPos < out.size() && str.equals(deleteTime(out.get(nPos)))) {
                    out.set(nPos, out.get(pos));
                } else if (!str.equals(answer)) {
                    System.out.printf("期望输出%s，实际输出%s", str, answer);
                    return;
                }
            }
            pos = getNextOut(out, pos);
            //排除循环到7000的情况
            if (pos < out.size() && !out.get(pos).matches(".*@00007000: .*")) {
                System.out.printf("行数多于标准答案，期望输出为空，实际输出为%s\n", out.get(pos));
                return;
            }
            System.out.println("答案正确");
        } catch (Exception e) {
            System.out.println("比较失败");
        }
    }

    /**
     * 获取下一条有效输出
     * @param out 输出
     * @param pos 当前位置
     * @return 有效输出位置
     */
    public static int getNextOut(ArrayList<String> out, int pos) {
        ++pos;
        int size = out.size();
        while (pos < size && !out.get(pos).matches(OUT)) {
            ++pos;
        }
        return pos;
    }

    /**
     * 删除输出中的时间
     * @param str 输出
     * @return 删除后的字符串
     */
    public static String deleteTime(String str) {
        Pattern pattern = Pattern.compile(OUT);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
