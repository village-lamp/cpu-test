package org.data_generator;

import org.Constant;
import org.data_generator.generator.*;

import java.io.*;
import java.util.*;

/**
 * 数据生成管理类
 */

public class Manager implements Constant {
    //生成器列表
    private static final ArrayList<Generator> generators = new ArrayList<>();
    private static final ArrayList<String> code = new ArrayList<>();
    private static final TreeMap<Integer, TreeSet<Integer>> addBeqLabel = new TreeMap<>();
    private static final Random random = new Random();
    private static int pc = PC_BEGIN;
    private static int lastBeq = PC_BEGIN;
    private static int blocks = 0;
    private static int max;
    private static int beqs = 0;

    /**
     * 生成初级指令
     * @param path 初级指令存放的路径
     */
    public static void work(String path) {
        random.setSeed(2143242L);
        init();
        initReg();
        generateMain();
        for (int i = 1; i <= blocks; ++i) {
            generateBlock(i);
        }
        code.add("end:");
        addBeqLabels();
        print(path);
    }

    public static void initReg() {
        generators.get(2).generate(new ArrayList<>(Arrays.asList(0, 30, 1)));
        for (int i = 29; i >= 1; --i) {
            generators.get(6).generate(new ArrayList<>(
                    Arrays.asList(i, Generator.randUnsignedImm())
            ));
            generators.get(2).generate(new ArrayList<>(
                    Arrays.asList(i, i, Generator.randUnsignedImm())
            ));
        }
    }

    public static void generateMain() {
        max = PC_BEGIN + BLOCK_SIZE - 1;
        int mainMax = PC_END;
        while (pc < mainMax) {
            int op = Generator.randInt(0, generators.size() - 1);
            if (op == 7) {
                if (mainMax - pc <= BLOCK_SIZE) {
                    continue;
                }
                mainMax -= BLOCK_SIZE;
                blocks++;
            }
            if (op == 8) {
                continue;
            }
            if ((op == 3 || op == 4) && pc + 4 >= max) {
                continue;
            }
            if (op == 5 && pc + 12 >= max) {
                continue;
            }
            generators.get(op).generate(null);
        }
        code.add("beq $0, $0, end");
        pc += 4;
    }

    public static void generateBlock(int id) {
        max = PC_END - (blocks - id) * BLOCK_SIZE;
        while (pc < max) {
            int op = Generator.randInt(0, generators.size() - 1);
            if (op == 8 || op == 7) {
                continue;
            }
            if ((op == 3 || op == 4) && pc + 4 >= max) {
                continue;
            }
            if (op == 5 && pc + 12 >= max) {
                continue;
            }
            generators.get(op).generate(null);
        }
        int start = PC_END - (blocks - id + 1) * BLOCK_SIZE - PC_BEGIN + 5;
        start >>= 2;
        code.add(start, "block" + id + ": " + code.get(start));
        code.remove(start + 1);
        generators.get(8).generate(null);
    }

    public static void addBeqLabels() {
        int count = 0;
        while (!addBeqLabel.isEmpty()) {
            Map.Entry<Integer, TreeSet<Integer>> entry = addBeqLabel.firstEntry();
            addBeqLabel.remove(entry.getKey());
            for (int value : entry.getValue()) {
                int key = entry.getKey() + count;
                while (code.get(key).matches(".*[ls]w.*")) {
                    ++key;
                }
                code.add(key, "beq" + value + ":");
                ++count;
            }
        }
    }

    public static void print(String path) {
        path += "\\test.asm";
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            for (String str : code) {
                str += "\r\n";
                fileOutputStream.write(str.getBytes());
            }
        } catch (Exception e) {
            System.out.println("写入test.asm失败");
            return;
        }
        System.out.println("生成test.asm成功");
    }

    /**
     * 初始化生成器列表
     */
    public static void init() {
        generators.add(new AddGenerator());
        generators.add(new SubGenerator());
        generators.add(new OriGenerator());
        generators.add(new LwGenerator());
        generators.add(new SwGenerator());
        generators.add(new BeqGenerator());
        generators.add(new LuiGenerator());
        generators.add(new JalGenerator());
        generators.add(new JrGenerator());
    }

    public static Random getRandom() {
        return random;
    }

    public static int getPc() {
        return pc;
    }

    public static void setPc(int npc) {
        pc = npc;
    }

    public static ArrayList<String> getCode() {
        return code;
    }

    public static int getLastBeq() {
        return lastBeq;
    }

    public static int getMax() {
        return max;
    }

    public static int getBeqs() {
        return beqs;
    }

    public static void addBeqs() {
        beqs++;
    }

    public static void putAddBeqLabel(int key, int value) {
        if (addBeqLabel.containsKey(key)) {
            addBeqLabel.get(key).add(value);
        } else {
            TreeSet<Integer> set = new TreeSet<>();
            set.add(value);
            addBeqLabel.put(key, set);
        }
    }

    public static int getBlocks() {
        return blocks;
    }

    public static void addBlocks() {
        blocks++;
    }

    public static void setLastBeq(int val) {
        lastBeq = val;
    }
}
