package org.check;

import org.Mips;
import org.util.Hex;

/**
 * 验证抽象类
 */
public abstract class Check {

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
        switch (opcode) {
            case 0b000000:
                type = "R";
                break;
            case 0b001101:
                type = "ori";
                break;
            case 0b100011:
                type = "lw";
                break;
            case 0b101011:
                type = "sw";
                break;
            case 0b000100:
                type = "beq";
                break;
            case 0b001111:
                type = "lui";
                break;
            case 0b000011:
                type = "jal";
                break;
            default:
                type = "nop";
        }
        if (type.equals("R")) {
            int funct = getFunct(im);
            switch (funct) {
                case 0b100000:
                    type = "add";
                    break;
                case 0b100010:
                    type = "sub";
                    break;
                case 0b001000:
                    type = "jr";
                    break;
                default:
                    type = "nop";
            }
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
