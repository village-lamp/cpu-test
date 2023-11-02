package org;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 * 常数
 */

public interface Constant {
    int DM_END = 0x2fff;

    //pc的起始位置
    int PC_BEGIN = 0X3000;

    //pc的结束位置
    int PC_END = 0X3f00;

    //分块大小
    int BLOCK_SIZE = 400;

    //最大循环次数
    int MAX_LOOP = 10;

    String OUT = "@.*: .*<=.*";
}
