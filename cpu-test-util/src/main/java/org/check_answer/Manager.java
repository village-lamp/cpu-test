package org.check_answer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private static final Manager instance = new Manager();
    private int pc;
    private long[] dm = new long[3072];
    private long[] reg = new long[32];
    private long inStr;
    private int regWrite;
    private int regAddr;
    private long regData;
    private int memWrite;
    private int memAddr;
    private long memData;

    private Manager() {}

    public static Manager getManager() {
        return instance;
    }

    public void work(String[] args) throws IOException {
        String outPath = args[0];
        String asmPath = args[1];
        String txtPath = args[2];
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(asmPath));
        ArrayList<String> im = (ArrayList<String>) Files.readAllLines(Paths.get(txtPath));
        try (FileInputStream in = new FileInputStream(outPath)) {
            Scanner scanner = new Scanner(in);
            int i = 0;
            pc = 0x3000;
            while (scanner.hasNext()) {
                i = (pc - 0x3000) >> 2;
                if (i >= 689) break;
                if (i == 74) {
                    int j = 0;
                }
                inStr = hex2Int(im.get(i));
                memAddr = -1;
                memWrite = -1;
                memData = -1;
                regData = -1;
                regWrite = -1;
                regAddr = -1;
                String op = list.get(i);
                String str = scanner.nextLine();
                int pos = 0;
                pos = check(32, inStr, pos, str, i);
                pos = check(32, pc, pos, str, i);
                if (op.matches("add.*")) {
                    add(op);
                } else if (op.matches("sub.*")) {
                    sub(op);
                } else if (op.matches("ori.*")) {
                    ori(op);
                } else if (op.matches("lw.*")) {
                    lw(op);
                } else if (op.matches("sw.*")) {
                    sw(op);
                } else if (op.matches("beq.*")) {
                    beq(op);
                } else if (op.matches("lui.*")) {
                    lui(op);
                }
                pos = check(1, regWrite, pos, str, i);
                pos = check(5, regAddr, pos, str, i);
                pos = check(32, regData, pos, str, i);
                pos = check(1, memWrite, pos, str, i);
                pos = check(32, (long) memAddr << 2, pos, str, i);
                check(32, memData, pos, str, i);
                pc += 4;
                reg[0] = 0;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void add(String op) {
        String[] strings = op.split("[ ,$()]+");
        int rd = Integer.parseInt(strings[1]);
        int rs = Integer.parseInt(strings[2]);
        int rt = Integer.parseInt(strings[3]);
        regWrite = 1;
        regData = reg[rs] + reg[rt];
        if (regData > 0xffffffffL) {
            regData--;
        }
        regData = long2UnsignedInt(regData);
        regAddr = rd;
        reg[rd] = regData;
    }

    public void sub(String op) {
        String[] strings = op.split("[ ,$()]+");
        int rd = Integer.parseInt(strings[1]);
        int rs = Integer.parseInt(strings[2]);
        int rt = Integer.parseInt(strings[3]);
        regWrite = 1;
        regData = reg[rs] - reg[rt];
        if (regData > 0xffffffffL) {
            regData--;
        }
        regData = long2UnsignedInt(regData);
        regAddr = rd;
        reg[rd] = regData;
    }

    public void ori(String op) {
        String[] strings = op.split("[ ,$()]+");
        int rt = Integer.parseInt(strings[1]);
        int rs = Integer.parseInt(strings[2]);
        int imm = Integer.parseInt(strings[3]);
        regWrite = 1;
        regData = long2UnsignedInt(reg[rs] | imm);
        regAddr = rt;
        reg[rt] = regData;
    }

    public void lw(String op) {
        String[] strings = op.split("[ ,$()]+");
        int rt = Integer.parseInt(strings[1]);
        int offset = Integer.parseInt(strings[2]);
        int base = Integer.parseInt(strings[3]);
        regWrite = 1;
        regData = dm[(int) (reg[base] + offset) >> 2];
        regAddr = rt;
        regData = long2UnsignedInt(regData);
        reg[rt] = regData;
    }

    public void sw(String op) {
        String[] strings = op.split("[ ,$()]+");
        int rt = Integer.parseInt(strings[1]);
        int offset = Integer.parseInt(strings[2]);
        int base = Integer.parseInt(strings[3]);
        memWrite = 1;
        memData = reg[rt];
        memAddr = (int) ((reg[base] + offset) >> 2);
        memData = long2UnsignedInt(memData);
        dm[memAddr] = memData;
    }

    public void beq(String op) {
        String[] strings = op.split("[ ,$()]+");
        int rs = Integer.parseInt(strings[1]);
        int rt = Integer.parseInt(strings[2]);
        int offset = Integer.parseInt(strings[3]);
        if (reg[rs] == reg[rt]) {
            pc += (offset << 2);
        }
    }

    public void lui(String op) {
        String[] strings = op.split("[ ,$()]+");
        int rt = Integer.parseInt(strings[1]);
        int imm = Integer.parseInt(strings[2]);
        regWrite = 1;
        regData = (long) imm << 16 + (reg[rt] & 0xffff);
        regAddr = rt;
        regData = long2UnsignedInt(regData);
        reg[rt] = regData;
    }

    public int check(int len, long value, int pos, String str, int row) {
        long num = 0;
        byte[] bytes = str.getBytes();
        while (len > 0) {
            if (bytes[pos] == '0') {
                num = (num << 1);
                --len;
            } else if (bytes[pos] == '1') {
                num = (num << 1) + 1;
                --len;
            }
            ++pos;
        }
        if (num != value && value >= 0) {
            System.out.printf("row:%d - suppose:%d\tactual:%d\n", row, value, num);
        }
        return pos;
    }

    public long long2UnsignedInt(long val) {
        return val % 0xffffffffL;
    }

    public long hex2Int(String str) {
        int size = str.length();
        byte[] bytes = str.getBytes();
        long num = 0;
        for (int i = 0; i < size; ++i) {
            int x = bytes[i] - '0';
            if (x > 9) {
                x = bytes[i] - 'a' + 10;
            }
            num = (num << 4) + x;
        }
        return num;
    }
}
