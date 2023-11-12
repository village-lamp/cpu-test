package org.generator;

import org.Mips;
import org.util.RandomUtil;

/**
 * 生成器抽象类
 */
public abstract class Generator {

    //mips
    private final Mips mips;
    //随机工具
    private final RandomUtil random;

    public Generator(Mips mips, RandomUtil random) {
        this.mips = mips;
        this.random = random;
    }

    /**
     * 生成指令
     */
    public abstract void generate();

    /**
     * 将指令翻译为二进制码
     * @param codeStr 指令字符串
     * @return 二进制码
     */
    public abstract String translate(String codeStr);

    public Mips getMips() {
        return mips;
    }

    public RandomUtil getRandom() {
        return random;
    }
}
