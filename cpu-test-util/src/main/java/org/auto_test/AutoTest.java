package org.auto_test;

public class AutoTest {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            args = new String[3];
            args[0] = "C:\\Users\\24949\\Desktop\\tools\\co-eda-vm\\share\\logisim\\P3\\cpu.circ";
            args[1] = "C:\\Users\\24949\\Desktop\\tools\\co-eda-vm\\share\\logisim\\P3\\test.asm";
            args[2] = "C:\\Users\\24949\\Desktop\\tools\\co-eda-vm\\share\\logisim\\P3";
        }
        Manager.getManager().work(args);
    }
}