package org.run_asm;

import org.Mips;
import org.util.RandomUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    public static void work(String[] args) {
        Mips mips = new Mips();
        String path = args[0];
        HashMap<Integer, String> code = new HashMap<>();
        try {
            ArrayList<String> strings = (ArrayList<String>) Files.readAllLines(Paths.get(path + "\\test.txt"));
            RandomUtil random = new RandomUtil(0L);
            for (int i = 0; i < strings.size(); ++i) {
                int pc = random.getPc(i + 1);
                code.put(pc, strings.get(i));
            }
        } catch (Exception e) {
            System.out.println("运行失败");
            return;
        }
        mips.setCode(code);
        File out = new File(path + "\\out.txt");
        ArrayList<String> outs = mips.run(0, -1);
        try (FileOutputStream in = new FileOutputStream(out)) {
            for (String str : outs) {
                if (str != null) {
                    in.write(str.getBytes());
                }
            }
        } catch (Exception e) {
            System.out.println("运行失败");
            return;
        }
        System.out.println("运行成功，结果保存在" + out.getAbsoluteFile());
    }
}
