package org.run_asm;

import org.constant.CommonConstant;
import org.mips.Mips;
import org.util.Hex;
import org.util.RandomUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 运行代码
 */
public class Manager implements CommonConstant {

    /**
     * 运行代码
     * @param args code.txt路径
     */
    public static void work(String[] args) {
        Mips mips = new Mips();
        String path = args[0];
        HashMap<Integer, String> code = new HashMap<>();

        //读取code，写入mips中
        try {
            ArrayList<String> strings = (ArrayList<String>)
                    Files.readAllLines(Paths.get(path + "\\code.txt"));
            int pc = PC_BEGIN;
            for (int i = 0; i < strings.size(); ++i) {
                if (".ktext 4180".equals(strings.get(i))) {
                    pc = EXC_INT_BEGIN;
                    continue;
                }
                code.put(pc, strings.get(i));
                pc += 4;
            }
        } catch (Exception e) {
            System.out.println("运行失败");
            return;
        }
        mips.setCode(code);

        //读取中断
        try {
            ArrayList<String> tb = (ArrayList<String>)
                    Files.readAllLines(Paths.get(path + "\\mips_tb.v"));
            ArrayList<Integer> interrupts = new ArrayList<>();
            for (int i = 125; i <= 152; i += 3) {
                String str = tb.get(i);
                Pattern pattern = Pattern.compile(".+32'h(\\w+)");
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    Hex pc = new Hex();
                    pc.set(matcher.group(1));
                    interrupts.add(pc.toDec());
                }
            }
            mips.setInterrupts(interrupts);
        } catch (Exception e) {
            System.out.println("运行失败");
            return;
        }

        //运行mips
        File out = new File(path + "\\stdout.txt");
        ArrayList<String> outs = mips.run(0, 200000);

        //写入out.txt
        try (FileOutputStream o = new FileOutputStream(out)) {
            for (String str : outs) {
                if (str != null) {
                    o.write(str.getBytes());
                }
            }
        } catch (Exception e) {
            System.out.println("运行失败");
            return;
        }
        System.out.println("运行成功，结果保存在" + out.getAbsoluteFile());
    }
}
