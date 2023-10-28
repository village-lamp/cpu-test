package org.check_answer;

import java.io.IOException;

public class CheckAnswer {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            args = new String[3];
            args[0] = "C:\\Users\\24949\\Desktop\\tools\\co-eda-vm\\share\\logisim\\P3\\out.txt";
            args[1] = "C:\\Users\\24949\\Desktop\\tools\\co-eda-vm\\share\\logisim\\P3\\auto-test\\testfirst.asm";
            args[2] = "C:\\Users\\24949\\Desktop\\tools\\co-eda-vm\\share\\logisim\\P3\\auto-test\\test.txt";
        }
        Manager.getManager().work(args);
    }
}
