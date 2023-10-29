package org.auto_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 自动测试管理类
 */
public class Manager {
    private static final Manager instance = new Manager();

    private Manager() {}

    public static Manager getManager() {
        return instance;
    }

    /**
     * 测试
     * @param args 输入
     */
    public void work(String[] args) throws IOException{
        getResource(args[0]);
        getCode(args[1]);
        writeRom();
        runCirc(args[2]);
    }

    /**
     * 将电路文件转移
     * @param circAdr 电路文件路径
     */
    public void getResource(String circAdr) throws IOException {
        File circ = new File(circAdr);
        Path circPath = Paths.get("./resources/cpu.circ");
        File resCirc = new File(circPath.toUri());
        if (resCirc.exists()) {
            Files.delete(circPath);
        }
        Files.copy(circ.toPath(), resCirc.toPath());
    }

    /**
     * 将指令文件转化为指令码
     * @param path 指令文件路径
     */
    public void getCode(String path) throws IOException {
        String command = "java -jar ./resources/Mars4_5.jar " +
                path + " nc mc CompactTextAtZero a dump .text HexText " +
                "./resources/test.txt";
        Process process = Runtime.getRuntime().exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向转移后的电路文件填入指令码
     */
    public void writeRom() throws IOException {
        Path test = Paths.get("./resources/test.txt");
        Path circ = Paths.get("./resources/cpu.circ");
        String testStr = new String(Files.readAllBytes(test));
        String circStr = new String(Files.readAllBytes(circ));
        circStr = circStr.replaceAll("addr/data: 12 32\n[^<]*", "addr/data: 12 32\n" + testStr);
        Files.write(circ, circStr.getBytes());
    }

    /**
     * 生成运行测试电路的批文件，存放在resources中
     * @param path 结果存放路径
     */
    public void runCirc(String path) {
        String command = "java -jar ./resources/logisim.jar " +
                "./resources/cpu_test.circ -tty table > " + path;
        File bat = new File("run.bat");
        try (FileOutputStream out = new FileOutputStream(bat)) {
            out.write(command.getBytes());
        } catch (Exception e) {
            System.out.println("写入文件失败" + bat.getAbsoluteFile());
        }
    }
}
