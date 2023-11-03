package org.run_verilog;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Manager {

    public static final String MIPS_PATH = "./resources/mips";

    public static void work(String[] args) {
        boolean ret;
        ret = clear();
        if (!ret) {
            System.out.println("清理资源文件夹失败");
            return;
        } else {
            System.out.println("清理资源文件夹成功");
        }
        ret = depress(args[0]);
        if (!ret) {
            System.out.println("解压失败");
            return;
        } else {
            System.out.println("解压成功");
        }
        ret = translate(args[1]);
        if (!ret) {
            System.out.println("翻译失败");
            return;
        } else {
            System.out.println("翻译成功");
        }
        ret = run();
        if (!ret) {
            System.out.println("重编文件失败");
        } else {
            System.out.println("重编文件成功");
        }
    }

    public static boolean clear() {
        File folder = new File(MIPS_PATH);
        File[] files = folder.listFiles();
        try {
            for (File file : files) {
                if (file.isDirectory()) {
                    continue;
                }
                if (file.getName().equals("mips_tb.v")) {
                    continue;
                }
                file.delete();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean depress(String zipPath){
        byte[] buffer = new byte[1024];
        try (ZipInputStream zip = new ZipInputStream(Files.newInputStream(Paths.get(zipPath)))) {
            ZipEntry entry = zip.getNextEntry();
            while (entry != null) {
                if (!entry.isDirectory()) {
                    String name = entry.getName();
                    String[] str = name.split("/");
                    name = str[str.length - 1];
                    if (!name.matches(".*\\.v")) {
                        entry = zip.getNextEntry();
                        continue;
                    }
                    if (entry.getName().equals("mips_tb.v")) {
                        entry = zip.getNextEntry();
                        continue;
                    }
                    File file = new File(MIPS_PATH, name);
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        int len;
                        while ((len = zip.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
                entry = zip.getNextEntry();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean translate(String path){
        Path testTxt = Paths.get("./resources/mips/code.txt");
        try {
            if (Files.exists(testTxt)) {
                Files.delete(testTxt);
            }
            String command = "java -jar ./resources/Mars4_5.jar " +
                    path + " nc mc CompactDataAtZero a dump .text HexText " +
                    "./resources/mips/code.txt";
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
            return false;
        }
        return Files.exists(testTxt);
    }

    public static boolean run() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("./resources/mips/mips.v"));
            try (FileOutputStream out = new FileOutputStream("./resources/mips/mips.v")) {
                File folder = new File("./resources/mips");
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (!file.getName().equals("mips.v") &&
                        !file.getName().equals("mips_tb.v") &&
                        file.getName().matches(".*\\.v")) {
                        String str = String.format("`include \"%s\"\n", file.getName());
                        out.write(str.getBytes());
                    }
                }
                out.write(bytes);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
