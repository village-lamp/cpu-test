package org.constant;

/**
 * 通用常数
 */
public interface CommonConstant {

    //dm的结束位置
    int DM_END = 0x2fff;

    //pc的起始位置
    int PC_BEGIN = 0X3000;

    //pc的结束位置
    int PC_END = 0X4f00;

    //向后跳转极限
    int JUMP_MAX = 100;

    //匹配输出正则表达式
    String OUT = "@\\w{8}: ((\\$(( [1-9])|(\\d{2})))|(\\*\\w{8})) <= \\w{8}";
}
