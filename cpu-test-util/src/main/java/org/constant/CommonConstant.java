package org.constant;

/**
 * 通用常数
 */
public interface CommonConstant {

    //dm的结束位置
    int DM_END = 0x2fff;

    //tc0开始位置
    int TC0_BEGIN = 0x7f00;

    //tc0结束位置
    int TC0_END = 0x7f0b;

    //tc0 count寄存器地址
    int TC0_COUNT_ADDR = 0x7f08;

    //tc1开始位置
    int TC1_BEGIN = 0x7f10;

    //tc1结束位置
    int TC1_END = 0x7f1b;

    //tc1 count寄存器地址
    int TC1_COUNT_ADDR = 0x7f18;

    //中断生成器开始地址
    int IG_BEGIN = 0x7f20;

    //中断生成器结束地址
    int IG_END = 0x7f23;

    //pc的起始位置
    int PC_BEGIN = 0X3000;

    //pc的结束位置
    int PC_END = 0X3f00;

    //异常处理程序入口
    int EXC_INT_BEGIN = 0x4180;

    //向后跳转极限
    int JUMP_MAX = 100;

    //生成跳转指令尝试次数
    int TRY_TIMES = 3;

    //生成跳转指令最大运行次数（死循环判定）
    int MAX_RUNTIMES = 2000;

    //匹配输出正则表达式
    String OUT = ".*?(\\d+)(@(\\w{8}): ((\\$(( [1-9])|(\\d{2})))|(\\*\\w{8})) <= (\\w{8}))";
}
