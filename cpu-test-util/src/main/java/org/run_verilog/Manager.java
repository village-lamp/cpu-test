package org.run_verilog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Manager {

    public static final String MIPS_PATH = "./resources/mips";

    public static void work(String[] args) {
        boolean ret = true;
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
        /*ret = translate(args[1]);
        if (!ret) {
            System.out.println("翻译失败");
            return;
        } else {
            System.out.println("翻译成功");
        }
        ret = run();
        if (!ret) {
            System.out.println("运行失败");
            return;
        } else {
            System.out.println("运行成功");
        }*/
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
                String name = entry.getName();
                if (!name.matches(".*\\.v")) {
                    entry = zip.getNextEntry();
                    continue;
                }
                if (entry.getName().equals("mips_tb.v")) {
                    continue;
                }
                File file = new File(MIPS_PATH, entry.getName());
                try (FileOutputStream out = new FileOutputStream(file)) {
                    int len;
                    while ((len = zip.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                } catch (Exception e) {
                    return false;
                }
                entry = zip.getNextEntry();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
