package org.check;

import org.Mips;
import org.util.Hex;

import java.util.HashMap;

/**
 * 验证抽象类
 */
public abstract class Checker {

    //opcode到指令的映射
    public static HashMap<Integer, String> opcodeMap;
    //funct到指令的映射
    public static HashMap<Integer, String> functMap;

    //映射初始化
    static {
        opcodeMap = new HashMap<>();
        functMap = new HashMap<>();
        opcodeMap.put(0b000000, "R");
        opcodeMap.put(0b001101, "ori");
        opcodeMap.put(0b001000, "addi");
        opcodeMap.put(0b001100, "andi");
        opcodeMap.put(0b100011, "lw");
        opcodeMap.put(0b100001, "lh");
        opcodeMap.put(0b100000, "lb");
        opcodeMap.put(0b101011, "sw");
        opcodeMap.put(0b101001, "sh");
        opcodeMap.put(0b101000, "sb");
        opcodeMap.put(0b000100, "beq");
        opcodeMap.put(0b000101, "bne");
        opcodeMap.put(0b001111, "lui");
        opcodeMap.put(0b000011, "jal");
        functMap.put(0b100000, "add");
        functMap.put(0b100010, "sub");
        functMap.put(0b100100, "and");
        functMap.put(0b100101, "or");
        functMap.put(0b101010, "slt");
        functMap.put(0b101011, "sltu");
        functMap.put(0b001000, "jr");
        functMap.put(0b011000, "mult");
        functMap.put(0b011001, "multu");
        functMap.put(0b011010, "div");
        functMap.put(0b011011, "divu");
        functMap.put(0b010010, "mflo");
        functMap.put(0b010000, "mfhi");
        functMap.put(0b010011, "mtlo");
        functMap.put(0b010001, "mthi");
        functMap.put(0b000000, "nop");
    }

    /**
     * 验证
     * @param code 十六进制代码
     * @param mips mips
     * @return 输出
     */
    public abstract String check(String code, Mips mips);

    /**
     * 分析代码种类
     * @param code 十六进制代码
     * @return 指令种类
     */
    public static String analyse(String code) {
        String type;
        Hex im = new Hex();
        im.set(code);
        int opcode = getOpcode(im);
        int funct = getFunct(im);
        type = opcodeMap.get(opcode);
        if ("R".equals(type)) {
            type = functMap.get(funct);
        }
        return type;
    }

    //分线
    public static int getRs(Hex im) {
        return im.toDec(21, 25);
    }

    public static int getRt(Hex im) {
        return im.toDec(16, 20);
    }

    public static int getRd(Hex im) {
        return im.toDec(11, 15);
    }

    public static int getImm16(Hex im) {
        return im.toDec(0, 15);
    }

    public static int getImm26(Hex im) {
        return im.toDec(0, 25);
    }

    public static int getOpcode(Hex im) {
        return im.toDec(26, 31);
    }

    public static int getFunct(Hex im) {
        return im.toDec(0, 5);
    }
}
