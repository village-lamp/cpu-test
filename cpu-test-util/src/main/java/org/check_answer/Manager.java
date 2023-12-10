package org.check_answer;

import org.constant.CommonConstant;
import org.util.Hex;
import org.util.UnsignedInt;

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

        boolean interrupt = false;
        int countTime = 0;
        int intCount = 0;
        int stdIntCount = 0;

        try {
            ArrayList<String> stdOut = (ArrayList<String>) Files.readAllLines(Paths.get(stdPath));
            ArrayList<String> out = (ArrayList<String>) Files.readAllLines(Paths.get(outPath));
            int pos = -1;
            for (int i = 0; i < stdOut.size(); ++i) {
                String str = stdOut.get(i);
                try {
                    int time = Integer.parseInt(str);
                    interrupt = true;
                    countTime = getTime(out.get(pos)) + (time << 2);
                    ++stdIntCount;
                    continue;
                } catch (Exception ignored) {
                }

                //得到下一条有效输出
                pos = getNextOut(out, pos);
                if (pos >= out.size()) {
                    System.out.printf("行数少于标准答案，期望输出%s，实际输出为空\n", str);
                    return;
                }
                int time = getTime(out.get(pos));

                if (time > countTime + 4) {
                    interrupt = false;
                }

                //同一时刻的输出，dm会在grf前面，可能导致顺序的颠倒
                while (true) {
                    if (getNextOut(out, pos) < out.size() && str.equals(deleteTime(out.get(getNextOut(out, pos))))) {
                        out.set(getNextOut(out, pos), out.get(pos));
                        break;
                    } else if (!str.equals(deleteTime(out.get(pos)))) {

                        //中断
                        if (getPc(out.get(pos)) == 0x4180 && interrupt) {
                            long data = getData(out.get(pos));
                            if ((data & 0x1c00) != 0) {
                                ++intCount;
                                interrupt = false;
                                if (getPc("1" + stdOut.get(i)) == EXC_INT_BEGIN &&
                                        (getData("1" + stdOut.get(i)) & 0x1c00) != 0) {
                                    ++i;
                                    while (getPc("1" + stdOut.get(i)) > EXC_INT_BEGIN) {
                                        ++i;
                                    }
                                }
                                str = stdOut.get(i);
                                pos = getNextOut(out, pos);
                                while (getPc(out.get(pos)) > EXC_INT_BEGIN) {
                                    pos = getNextOut(out, pos);
                                }
                                continue;
                            }
                        }

                        System.out.printf("期望输出%s，实际输出%s", str, deleteTime(out.get(pos)));
                        return;
                    }

                    if (getPc(out.get(pos)) == 0x4180 && interrupt) {
                        ++intCount;
                        interrupt = false;
                    }

                    break;
                }
            }
            pos = getNextOut(out, pos);
            //排除循环到7000的情况
            if (pos < out.size() && !out.get(pos).matches(".*@00007000: .*")) {
                System.out.printf("行数多于标准答案，期望输出为空，实际输出为%s\n", deleteTime(out.get(pos)));
                return;
            }

            if (intCount != stdIntCount) {
                System.out.printf("缺少中断，需要%d，实际%d\n", stdIntCount, intCount);
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
            return matcher.group(2);
        }
        return null;
    }

    /**
     * 获取输出中的使劲按
     * @param str 输出
     * @return 时间
     */
    public static int getTime(String str) {
        Pattern pattern = Pattern.compile(OUT);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    /**
     * 获取输出的pc
     * @param str 输出
     * @return pc
     */
    public static int getPc(String str) {
        Pattern pattern = Pattern.compile(OUT);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            Hex hex = new Hex();
            hex.set(matcher.group(3));
            return hex.toDec();
        }
        return 0;
    }

    /**
     * 获取输出的数据
     * @param str 输出
     * @return 数据
     */
    public static long getData(String str) {
        Pattern pattern = Pattern.compile(OUT);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            Hex hex = new Hex();
            hex.set(matcher.group(10));
            return UnsignedInt.over(hex.toDec());
        }
        return 0;
    }
}
