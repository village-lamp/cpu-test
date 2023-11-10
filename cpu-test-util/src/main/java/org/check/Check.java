package org.check;

import org.auto_test_verilog.Manager;
import org.util.Hex;

public abstract class Check {

    public abstract String generate(String code);

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

    public static Long over(Long num) {
        return (num + 0x100000000L) % 0x100000000L;
    }

    public static String writeToGrf(long pc, int target, long data) {
        if (target == 0) {
            return null;
        }
        Manager.getRegs().put(target, data);
        return String.format("@%s: $%2d <= %s", Hex.toHex(pc).print(),
                target, Hex.toHex(data).print());
    }

    public static String writeToDm(long pc, long addr, long data) {
        Manager.getDm().put((int) (addr >> 2), data);
        return String.format("@%s: *%s <= %s", Hex.toHex(pc).print(),
                Hex.toHex(addr).print(), Hex.toHex(data).print());
    }
}
