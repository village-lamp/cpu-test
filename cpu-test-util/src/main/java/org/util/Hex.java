package org.util;

/**
 * 十六进制工具类
 */
public class Hex {
    private static final char[] HEX_CODE = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    //存储的值
    private final char[] hex;

    public Hex() {
        this(8);
    }

    /**
     * @param length 十六进制的长度
     */
    public Hex(int length) {
        hex = new char[length];
        for (int i = 0; i < length; ++i) {
            hex[i] = HEX_CODE[0];
        }
    }

    /**
     * 转为十进制
     * @return 对应的十进制数
     */
    public Integer toDec() {
        return toDec(0, (hex.length << 2) - 1);
    }

    /**
     * 截取出二进制的[l, r]，翻译为十进制
     * @param l 左边界
     * @param r 有边界
     * @return 十进制数
     */
    public Integer toDec(Integer l, Integer r) {
        Integer sum = 0;
        int lBlock = l >> 2;
        int rBlock = r >> 2;
        //在边界之间的块全部计算
        for (int i = 1; i < rBlock - lBlock; ++i) {
            sum += toDec(hex[i + lBlock]) << (4 * i);
        }
        //分别计算边界的值
        if (lBlock == rBlock) {
            sum += toDec(hex[lBlock], 3 - l % 4, 3 - r % 4);
        }
        else {
            sum += toDec(hex[lBlock], 0, 3 - l % 4);
            sum += toDec(hex[rBlock], 3 - r % 4, 3) << (rBlock * 4 - l);
        }
        return sum;
    }

    /**
     * 将字符翻译为十进制数
     * @param c 十六进制字符
     * @return 十进制数
     */
    public static Integer toDec(char c) {
        int dec = c - '0';
        if (dec > 9) {
            dec = c - 'a' + 10;
        }
        return dec;
    }

    /**
     * 将字符按二进制截取[l, r]得到十进制数
     * @param c 字符
     * @param l 左边界
     * @param r 右边界
     * @return 十进制数
     */
    public static Integer toDec(char c, int l, int r) {
        int dec = toDec(c);
        return (int) ((dec % (int) Math.pow(2, 4 - l)) / Math.pow(2, 3 - r));
    }

    /**
     * 通过反向字符串为十六进制赋值
     * @param str 字符串
     */
    public void set(String str) {
        //只是用前hex.length个字符
        if (str.length() > hex.length) {
            str = str.substring(0, hex.length);
        }
        int size = str.length();
        //使用小写格式
        str = str.toLowerCase();
        byte[] bytes = str.getBytes();
        int i = 0;
        for (; i < size; ++i) {
            hex[i] = (char) bytes[size - i - 1];
        }
        //补足0
        while (i < hex.length) {
            hex[i] = HEX_CODE[0];
            ++i;
        }
    }

    /**
     * 将十六进制字符串转为Hex
     * @param str 十六进制字符串
     */
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

    /**
     * 将二进制字符串转为十六进制
     * @param bin 二进制字符串
     * @return 十六进制值
     */
    public static Hex toHex(String bin) {
        byte[] bytes = bin.getBytes();
        long num = 0;
        for (int i = 0; i < bin.length(); ++i) {
            num <<= 1;
            num += (bytes[i] == '0') ? 0 : 1;
        }
        return toHex(num);
    }

    /**
     * 将长整型转为十六进制
     * @param num 长整型
     * @return 十六进制值
     */
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = hex.length - 1; i >= 0; --i) {
            str.append(hex[i]);
        }
        return str.toString();
    }
}
