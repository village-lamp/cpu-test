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
    int PC_END = 0X3f00;

    //向后跳转极限
    int JUMP_MAX = 100;

    //生成跳转指令尝试次数
    int TRY_TIMES = 3;

    //生成跳转指令最大运行次数（死循环判定）
    int MAX_RUNTIMES = 2000;

    //匹配输出正则表达式
    String OUT = "@\\w{8}: ((\\$(( [1-9])|(\\d{2})))|(\\*\\w{8})) <= \\w{8}";
}
