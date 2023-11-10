package org.util;

import org.Mips;
import org.constant.CommonConstant;
import org.constant.RegConstant;

import java.util.ArrayList;
import java.util.Random;

/**
 * 随机工具类
 * 生成随机的寄存器等值
 * 将寄存器分为1-15高级寄存器（存储任意数值）
 * 16-25中级寄存器（存储0-65535值，用于存取dm）
 * 26-30低级寄存器（存储0-3，用于beq判断）
 */
public class RandomUtil implements RegConstant, CommonConstant {
    //随机器
    private final Random random;
    //前几条指令使用的高级寄存器
    private final int[] lastHigh;
    private final int[] lastMid;
    private final int[] lastLow;
    private final int[] last;
    private final ArrayList<Integer> dmValue;

    public RandomUtil(long seed) {
        random = new Random();
        random.setSeed(seed);
        lastHigh = new int[COUNT_REGS_BEFORE + 1];
        lastMid = new int[COUNT_REGS_BEFORE + 1];
        lastLow = new int[COUNT_REGS_BEFORE + 1];
        last = new int[COUNT_REGS_BEFORE + 1];
        dmValue = new ArrayList<>();
    }

    /**
     * 随机寄存器
     * @param isUse 是否需要大概率为前几次使用过的寄存器
     * @return 寄存器编号
     */
    public int randomReg(boolean isUse) {
        last[COUNT_REGS_BEFORE] = randInt(1, 30);
        int index = (isUse) ? randInt(COUNT_REGS_BEFORE) : COUNT_REGS_BEFORE;
        return last[index];
    }

    /**
     * 随机寄存器
     * @param isUse 是否需要大概率为前几次使用过的寄存器
     * @param reg 生成与reg相同类型的寄存器编号
     * @return 寄存器编号
     */
    public int randomReg(boolean isUse, int reg) {
        switch (getRegType(reg)) {
            case "low":
                return randomLow(isUse);
            case "mid":
                return randomMid(isUse);
            case "high":
                return randomHigh(isUse);
        }
        return 0;
    }

    /**
     * 随机低级寄存器，lastLow[COUNT_REGS_BEFORE]存储的为随机寄存器
     * @param isUse 是否需要大概率为前几次使用过的寄存器
     * @return 寄存器编号
     */
    public int randomLow(boolean isUse) {
        lastLow[COUNT_REGS_BEFORE] = randInt(LOW_REG_START, LOW_REG_END);
        int index = (isUse) ? randInt(COUNT_REGS_BEFORE) : COUNT_REGS_BEFORE;
        return lastLow[index];
    }

    /**
     * 随机中级寄存器，lastMid[COUNT_REGS_BEFORE]存储的为随机寄存器
     * @param isUse 是否需要大概率为前几次使用过的寄存器
     * @return 寄存器编号
     */
    public int randomMid(boolean isUse) {
        lastMid[COUNT_REGS_BEFORE] = randInt(MID_REG_START, MID_REG_END);
        int index = (isUse) ? randInt(COUNT_REGS_BEFORE) : COUNT_REGS_BEFORE;
        return lastMid[index];
    }

    /**
     * 随机高级寄存器，lastHigh[COUNT_REGS_BEFORE]存储的为随机寄存器
     * @param isUse 是否需要大概率为前几次使用过的寄存器
     * @return 寄存器编号
     */
    public int randomHigh(boolean isUse) {
        lastHigh[COUNT_REGS_BEFORE] = randInt(HIGH_REG_START, HIGH_REG_END);
        int index = (isUse) ? randInt(COUNT_REGS_BEFORE) : COUNT_REGS_BEFORE;
        return lastHigh[index];
    }

    /**
     * 更新低级寄存器的取值
     * @param useReg 当前指令存储数值的寄存器
     */
    public void updateLow(int useReg) {
        for (int i = 0; i < COUNT_REGS_BEFORE; ++i) {
            lastLow[i] = lastLow[i + 1];
        }
        lastLow[COUNT_REGS_BEFORE] = useReg;
        update(useReg);
    }

    /**
     * 更新中级寄存器的取值
     * @param useReg 当前指令存储数值的寄存器
     */
    public void updateMid(int useReg) {
        for (int i = 0; i < COUNT_REGS_BEFORE; ++i) {
            lastMid[i] = lastMid[i + 1];
        }
        lastMid[COUNT_REGS_BEFORE] = useReg;
        update(useReg);
    }

    /**
     * 更新高级寄存器的取值
     * @param useReg 当前指令存储数值的寄存器
     */
    public void updateHigh(int useReg) {
        for (int i = 0; i < COUNT_REGS_BEFORE; ++i) {
            lastHigh[i] = lastHigh[i + 1];
        }
        lastHigh[COUNT_REGS_BEFORE] = useReg;
        update(useReg);
    }

    /**
     * 更新寄存器的取值
     * @param useReg 当前指令存储数值的寄存器
     */
    public void update(int useReg) {
        for (int i = 0; i < COUNT_REGS_BEFORE; ++i) {
            last[i] = last[i + 1];
        }
        last[COUNT_REGS_BEFORE] = useReg;
    }

    /**
     * 根据寄存器的类型更新取值
     * @param reg 寄存器编号
     */
    public void updateByType(int reg) {
        switch (getRegType(reg)) {
            case "low":
                updateLow(reg);
            case "mid":
                updateMid(reg);
            case "high":
                updateHigh(reg);
        }
    }

    /**
     * 随机无符号立即数
     * @return 无符号立即数
     */
    public int randomUnsignedImm() {
        return randInt(0xffff);
    }

    /**
     * 随机无符号立即数
     * @param reg 寄存器编号
     * @return 寄存器对应的无符号立即数
     */
    public int randomUnsignedImm(int reg) {
        if ("low".equals(getRegType(reg))) {
            return randInt(3);
        } else {
            return randomUnsignedImm();
        }
    }

    /**
     * 获取寄存器的类型
     * @param reg 寄存器编号
     * @return 类型
     */
    private String getRegType(int reg) {
        if (LOW_REG_START <= reg && reg <= LOW_REG_END) {
            return "low";
        } else if (MID_REG_START <= reg && reg <= MID_REG_END) {
            return "mid";
        } else if (HIGH_REG_START <= reg && reg <= HIGH_REG_END) {
            return "high";
        }
        return "none";
    }

    /**
     * 记录dm中已用的位置
     * @param val 使用过的地址
     */
    public void addValueToDm(int val) {
        dmValue.add(val);
    }

    /**
     * 依据base寄存器的值生成offset
     * @param baseVal base寄存器的值
     * @return offset
     */
    public int randomDm(int baseVal) {
        if (dmValue.isEmpty()) {
            return baseVal;
        }
        int index = randInt(dmValue.size() - 1);
        for (int i = index; i < dmValue.size(); ++i) {
            if (Math.abs(dmValue.get(i) - baseVal) <= 0x7fff) {
                return dmValue.get(i) - baseVal;
            }
        }
        for (int i = 0; i < index; ++i) {
            if (Math.abs(dmValue.get(i) - baseVal) <= 0x7fff) {
                return dmValue.get(i) - baseVal;
            }
        }
        return baseVal;
    }

    /**
     * 随机[l, r]整数
     * @param l 左边界
     * @param r 右边界
     * @return 整数
     */
    public int randInt(int l, int r) {
        return random.nextInt(r - l + 1) + l;
    }

    /**
     * 随机[0, r]整数
     * @param r 右边界
     * @return 整数
     */
    public int randInt(int r) {
        return randInt(0, r);
    }

    /**
     * 通过pc值得到行数
     * @param pc pc值
     * @return 行数
     */
    public int getLine(int pc) {
        return (pc - PC_BEGIN + 4) / 4;
    }
}
