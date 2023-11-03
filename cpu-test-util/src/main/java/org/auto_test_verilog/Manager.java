package org.auto_test_verilog;
import org.Constant;
import org.auto_test_verilog.Check.Check;
import org.auto_test_verilog.Check.CheckFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager implements Constant {

    private static final HashMap<Integer, Long> regs = new HashMap<>();
    private static final HashMap<Integer, Long> dm = new HashMap<>();
    private static long pc = 0x3000;

    public static void work(String[] args) throws IOException {
        init();
        analyseCode(args);
    }

    public static void analyseCode(String[] args) throws IOException {
        String codePath = args[0];
        String outPath = args[1];
        ArrayList<String> code = (ArrayList<String>) Files.readAllLines(Paths.get(codePath));
        ArrayList<String> out = (ArrayList<String>) Files.readAllLines(Paths.get(outPath));
        int pos = -1;
        while (pc <= PC_END) {
            int index = (int) ((pc - 0x3000) >> 2);
            CheckFactory checkFactory = new CheckFactory();
            Check check = checkFactory.create(Check.analyse(code.get(index)));
            String outCome = check.generate(code.get(index));
            if (outCome != null) {
                pos = getNextOut(out, pos);
                if (pos >= out.size()) {
                    System.out.printf("行数少于标准答案，期望输出%s，实际输出为空\n", outCome);
                    return;
                }
                if (!outCome.equals(out.get(pos))) {
                    System.out.printf("期望输出%s，实际输出%s", outCome, out.get(pos));
                    return;
                }
            }
        }
        pos = getNextOut(out, pos);
        if (pos < out.size()) {
            System.out.printf("行数多于标准答案，期望输出为空，实际输出为%s\n", out.get(pos));
            return;
        }
        System.out.println("答案正确");
    }

    public static int getNextOut(ArrayList<String> out, int pos) {
        ++pos;
        int size = out.size();
        while (pos < size && !out.get(pos).matches(OUT)) {
            ++pos;
        }
        return pos;
    }

    public static void init() {
        for (int i = 0; i <= 31; ++i) {
            regs.put(i, 0L);
        }
        int size = DM_END >> 2;
        for (int i = 0; i <= size; ++i) {
            dm.put(i, 0L);
        }
    }

    public static HashMap<Integer, Long> getRegs() {
        return regs;
    }

    public static HashMap<Integer, Long> getDm() {
        return dm;
    }

    public static long getPc() {
        return pc;
    }

    public static void setPc(long npc) {
        pc = npc;
    }

    public static void addPc(long val) {
        pc += val;
    }
}
