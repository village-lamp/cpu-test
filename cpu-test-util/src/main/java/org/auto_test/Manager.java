package org.auto_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Manager {
    private static final Manager instance = new Manager();

    private Manager() {}

    public static Manager getManager() {
        return instance;
    }

    public void work(String[] args) throws IOException{
        getResource(args[0]);
        getCode(args[1]);
        writeRom();
        runCirc(args[2]);
    }

    public void getResource(String circAdr) throws IOException {
        File circ = new File(circAdr);
        Path circPath = Paths.get("cpu.circ");
        File resCirc = new File(circPath.toUri());
        if (resCirc.exists()) {
            Files.delete(circPath);
        }
        Files.copy(circ.toPath(), resCirc.toPath());
    }

    public void getCode(String path) throws IOException {
        String command = "java -jar Mars4_5.jar " +
                path + " nc mc CompactTextAtZero a dump .text HexText " +
                "test.txt";
        Process process = Runtime.getRuntime().exec(command);
        while (process.isAlive());
    }

    public void writeRom() throws IOException {
        Path test = Paths.get("test.txt");
        Path circ = Paths.get("cpu.circ");
        String testStr = new String(Files.readAllBytes(test));
        String circStr = new String(Files.readAllBytes(circ));
        circStr = circStr.replaceAll("addr/data: 12 32\n[^<]*", "addr/data: 12 32\n" + testStr);
        Files.write(circ, circStr.getBytes());
    }

    public void runCirc(String path) {
        String command = "java -jar logisim.jar " +
                "cpu_test.circ -tty table > " + path;
        File bat = new File("run.bat");
        try (FileOutputStream out = new FileOutputStream(bat)) {
            out.write(command.getBytes());
        } catch (Exception e) {
            System.out.println("写入文件失败" + bat.getAbsoluteFile());
        }
    }
}
