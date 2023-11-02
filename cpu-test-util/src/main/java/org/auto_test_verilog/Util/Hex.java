package org.auto_test_verilog.Util;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.auto_test_verilog.Manager;

public class Hex {
    private static final char[] HEX_CODE = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private char[] hex;

    public Hex() {
        this(8);
    }

    public Hex(int length) {
        hex = new char[length];
        for (int i = 0; i < length; ++i) {
            hex[i] = HEX_CODE[0];
        }
    }

    public Integer toDec() {
        return toDec(0, (hex.length << 2) - 1);
    }

    public Integer toDec(Integer l, Integer r) {
        Integer sum = 0;
        int lBlock = l >> 2;
        int rBlock = r >> 2;
        for (int i = 1; i < rBlock - lBlock; ++i) {
            sum += toDec(hex[i + lBlock]) << (4 * i);
        }
        if (lBlock == rBlock) {
            sum += toDec(hex[lBlock], l % 4, r % 4);
        }
        else {
            sum += toDec(hex[lBlock], 0, 3 - l % 4);
            sum += toDec(hex[rBlock], 3 - r % 4, 3) << (rBlock * 4 - l);
        }
        return sum;
    }

    public static Integer toDec(char c) {
        int dec = c - '0';
        if (dec > 9) {
            dec = c - 'a' + 10;
        }
        return dec;
    }

    public static Integer toDec(char c, int l, int r) {
        int dec = toDec(c);
        return (int) ((dec % (int) Math.pow(2, 4 - l)) / Math.pow(2, 3 - r));
    }

    public void set(String str) {
        if (str.length() > hex.length) {
            str = str.substring(0, hex.length);
        }
        int size = str.length();
        str = str.toLowerCase();
        byte[] bytes = str.getBytes();
        int i = 0;
        for (; i < size; ++i) {
            hex[i] = (char) bytes[size - i - 1];
        }
        while (i < hex.length) {
            hex[i] = HEX_CODE[0];
            ++i;
        }
    }

    public void setSimple(String str) {
        byte[] bytes = str.getBytes();
        int i = 0;
        for (; i < str.length(); ++i) {
            hex[i] = (char) bytes[i];
        }
        for (; i < hex.length; ++i) {
            hex[i] = HEX_CODE[0];
        }
    }

    public static Hex toHex(long num) {
        Hex hex = new Hex();
        StringBuilder str = new StringBuilder();
        while (num != 0) {
            str.append(HEX_CODE[(int) (num % 16)]);
            num >>= 4;
        }
        hex.setSimple(str.toString());
        return hex;
    }

    public String print() {
        StringBuilder str = new StringBuilder();
        for (int i = hex.length - 1; i >= 0; --i) {
            str.append(hex[i]);
        }
        return str.toString();
    }
}
