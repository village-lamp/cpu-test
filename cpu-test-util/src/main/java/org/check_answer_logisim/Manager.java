package org.check_answer_logisim;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 答案检测管理类
 */
public class Manager {
    private static final Manager instance = new Manager();
    //错误统计
    private int errors = 0;
    //pc值
    private int pc;
    //dm值
    private final long[] dm = new long[3072];
    //reg值
    private final long[] reg = new long[32];
    //寄存器组写使能
    private int regWrite;
    //寄存器组写地址
    private int regAddr;
    //寄存器组写数据
    private long regData;
    //dm写使能
    private int memWrite;
    //dm写地址
    private int memAddr;
    //dm写数据
    private long memData;

    private Manager() {}

    public static Manager getManager() {
        return instance;
    }

    /**
     * 检验答案
     * @param args 输入
     */
    public void work(String[] args) throws IOException {
        String outPath = args[0];
        String asmPath = args[1];
        String txtPath = args[2];
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(asmPath));
        ArrayList<String> im = (ArrayList<String>) Files.readAllLines(Paths.get(txtPath));
        try (FileInputStream in = new FileInputStream(outPath)) {
            Scanner scanner = new Scanner(in);
            int i;
            pc = 0x3000;
            while (scanner.hasNext()) {
                i = (pc - 0x3000) >> 2;
                if (i >= 689) break;
                long inStr = hex2Long(im.get(i));
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
            return;
        }
        if (errors == 0) {
            System.out.println("答案正确");
        }
    }

    /**
     * 运行add指令
     * @param op 指令
     */
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

    /**
     * 运行sub指令
     * @param op 指令
     */
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

    /**
     * 运行ori指令
     * @param op 指令
     */
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

    /**
     * 运行lw指令
     * @param op 指令
     */
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

    /**
     * 运行sw指令
     * @param op 指令
     */
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

    /**
     * 运行beq指令
     * @param op 指令
     */
    public void beq(String op) {
        String[] strings = op.split("[ ,$()]+");
        int rs = Integer.parseInt(strings[1]);
        int rt = Integer.parseInt(strings[2]);
        int offset = Integer.parseInt(strings[3]);
        if (reg[rs] == reg[rt]) {
            pc += (offset << 2);
        }
    }

    /**
     * 运行lui指令
     * @param op 指令
     */
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

    /**
     * 检验结果是否正确
     * @param len 检验长度
     * @param value 应得值
     * @param pos 当前读到的位置
     * @param str 结果字符串
     * @param row 当前行数
     * @return pos
     */
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
            errors++;
        }
        return pos;
    }

    /**
     * 将long转化为无符号整型
     */
    public long long2UnsignedInt(long val) {
        return val % 0xffffffffL;
    }

    /**
     * 将指令码转化为长整型
     * @param str 指令码
     * @return 长整型
     */
    public long hex2Long(String str) {
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
