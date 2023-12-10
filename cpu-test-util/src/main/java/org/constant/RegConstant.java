package org.constant;

/**
 * 寄存器相关常数
 */
public interface RegConstant {

    //高级寄存器起始
    int HIGH_REG_START = 1;

    //高级寄存器截止
    int HIGH_REG_END = 15;

    //中级寄存器起始
    int MID_REG_START = 16;

    //中级寄存器截止
    int MID_REG_END = 25;

    //低级寄存器起始
    int LOW_REG_START = 28;

    //低级寄存器截止
    int LOW_REG_END = 30;

    //复用寄存器数量，决定高概率使用的寄存器为前几次出现的寄存器
    int COUNT_REGS_BEFORE = 3;
}
