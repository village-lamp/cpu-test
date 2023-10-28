package org.data_generator;

import org.data_generator.generator.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Manager implements Constant {
    private static final Manager instance = new Manager();
    private final ArrayList<Generator> generators;

    private Manager() {
        generators = new ArrayList<>();
    }

    public static Manager getManager() {
        return instance;
    }

    public void work(String path) {
        init();
        File file = new File(path + "\\testfirst.asm");
        try (FileOutputStream o = new FileOutputStream(file)) {
            for (int i = 31; i >= 1; --i) {
                Generator.setNow(i);
                Random random = new Random();
                int value = random.nextInt();
                int hi = (value >> 16) & 0xffff;
                int lo = value & 0xffff;
                if (hi != 0) {
                    Generator.setNowImm(hi - 0x8000);
                    generators.get(6).generate(o);
                }
                Generator.setNowImm(lo - 0x8000);
                generators.get(2).generate(o);
            }
            Generator.setNow(0);
            while (Generator.getPc() <= PC_END - 16) {
                Random random = new Random();
                int op = random.nextInt(generators.size() - 1);
                generators.get(op).generate(o);
            }
        } catch (IOException e) {
            System.out.println("文件写入失败" + file.getAbsoluteFile());
            return ;
        }
        System.out.println("生成\"" + file.getAbsoluteFile() + "\"成功");
        revise(path);
    }

    public void init() {
        generators.add(new AddGenerator());
        generators.add(new SubGenerator());
        generators.add(new OriGenerator());
        generators.add(new LwGenerator());
        generators.add(new SwGenerator());
        generators.add(new BeqGenerator());
        generators.add(new LuiGenerator());
    }

    public void revise(String path) {
        File fileIn = new File(path + "\\testfirst.asm");
        File file = new File(path + "\\test.asm");
        try (FileInputStream in = new FileInputStream(fileIn)) {
            Scanner scanner = new Scanner(in);
            ArrayList<String> list = new ArrayList<>();
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            list.add("");
            int size = list.size();
            int count = 0;
            for (int i = 0; i < size; ++i) {
                String str = list.get(i);
                String[] strings = str.split("[ ,]+");
                if (strings.length <= 2) {
                    continue;
                }
                if (Objects.equals(strings[0], "beq")) {
                    int offset = Integer.parseInt(strings[3]);
                    String toStr = list.get(i + offset + 1);
                    String[] toStrings = toStr.split("[ ,]+");
                    int num;
                    if (toStrings[0].matches(".*:")) {
                        String[] str1 = toStrings[0].split("[beq:]");
                        num = Integer.parseInt(str1[3]);
                    }
                    else {
                        list.add(i + offset + 1, "beq" + count + ": " + list.get(i + offset + 1));
                        list.remove(i + offset + 2);
                        num = count;
                        count++;
                    }
                    list.add(i, "beq " + strings[1] + ", " + strings[2] + ", " + "beq" + num);
                    list.remove(i + 1);
                }
                if (Objects.equals(strings[1], "beq")) {
                    int offset = Integer.parseInt(strings[4]);
                    String toStr = list.get(i + offset + 1);
                    String[] toStrings = toStr.split("[ ,]+");
                    int num;
                    if (toStrings[0].matches(".*:")) {
                        String[] str1 = toStrings[0].split("[beq:]");
                        num = Integer.parseInt(str1[3]);
                    }
                    else {
                        list.add(i + offset + 1, "beq" + count + ": " + list.get(i + offset + 1));
                        list.remove(i + offset + 2);
                        num = count;
                        count++;
                    }
                    list.add(i, strings[0] + " beq " + strings[2] + ", " + strings[3] + ", " + "beq" + num);
                    list.remove(i + 1);
                }
            }
            FileOutputStream o = new FileOutputStream(file);
            for (int i = 0; i < size; ++i) {
                String str = list.get(i) + "\r\n";
                o.write(str.getBytes());
            }
            o.close();
        } catch (Exception e) {
            System.out.println("写入文件失败" + file.getAbsoluteFile());
            return;
        }
        System.out.println("生成\"" + file.getAbsoluteFile() + "\"成功");
    }
}
