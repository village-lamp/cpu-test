package org.util;

import org.constant.CommonConstant;
import org.constant.RegConstant;

import java.util.ArrayList;
import java.util.HashMap;
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
    //前几条指令使用的中级寄存器
    private final int[] lastMid;
    //前几条指令使用的低级寄存器
    private final int[] lastLow;
    //前几条指令使用的寄存器
    private final int[] last;
    //dm中使用过的地址
    private final HashMap<Integer, String> dmValue;
    //中级寄存器生成ra的概率的倒数
    private final int MID_RA_RATIO = 4;

    /**
     * @param seed 随机数种子
     */
    public RandomUtil(long seed) {
        random = new Random();
        random.setSeed(seed);
        lastHigh = new int[COUNT_REGS_BEFORE + 1];
        lastMid = new int[COUNT_REGS_BEFORE + 1];
        lastLow = new int[COUNT_REGS_BEFORE + 1];
        last = new int[COUNT_REGS_BEFORE + 1];
        for (int i = 0; i < COUNT_REGS_BEFORE; ++i) {
            lastHigh[i] = randInt(HIGH_REG_START, HIGH_REG_END);
            lastMid[i] = randInt(MID_REG_START, MID_REG_END);
            lastLow[i] = randInt(LOW_REG_START, LOW_REG_END);
            last[i] = randInt(1, 30);
        }
        dmValue = new HashMap<>();
        dmValue.put(TC0_BEGIN + 4, "mid");
        dmValue.put(TC1_BEGIN + 4, "mid");
    }

    /**
     * 随机寄存器
     * @param isUse 是否需要大概率为前几次使用过的寄存器
     * @return 寄存器编号
     */
    public int randomReg(boolean isUse) {
        do {
            if (isUse) {
                last[COUNT_REGS_BEFORE] = randInt(1, 31);
            } else {
                last[COUNT_REGS_BEFORE] = randInt(1, 30);
            }
        } while("none".equals(getRegType(last[COUNT_REGS_BEFORE])));
        int index = (isUse) ? randInt(COUNT_REGS_BEFORE) : COUNT_REGS_BEFORE;
        return last[index];
    }

    /**
     * 随机寄存器
     * @param isUse 是否需要大概率为前几次使用过的寄存器
     * @param reg 生成比reg低级的寄存器编号
     * @return 寄存器编号
     */
    public int randomReg(boolean isUse, int reg) {
        switch (getRegType(reg)) {
            case "low":
                return randomLow(isUse);
            case "mid":
                int low = randomLow(isUse);
                int mid = randomMid(isUse);
                int choose = randInt(1);
                return (choose == 1) ? mid : low;
            case "high":
                return randomReg(isUse);
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
        //不写入值时，可以尝试使用31号寄存器
        if (isUse) {
            int isRa = randInt(1, MID_RA_RATIO);
            lastMid[COUNT_REGS_BEFORE] = (isRa == 1) ? 31 : lastMid[COUNT_REGS_BEFORE];
        }
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
        lastLow[COUNT_REGS_BEFORE - 1] = useReg;
    }

    /**
     * 更新中级寄存器的取值
     * @param useReg 当前指令存储数值的寄存器
     */
    public void updateMid(int useReg) {
        for (int i = 0; i < COUNT_REGS_BEFORE; ++i) {
            lastMid[i] = lastMid[i + 1];
        }
        lastMid[COUNT_REGS_BEFORE - 1] = useReg;
    }

    /**
     * 更新高级寄存器的取值
     * @param useReg 当前指令存储数值的寄存器
     */
    public void updateHigh(int useReg) {
        for (int i = 0; i < COUNT_REGS_BEFORE; ++i) {
            lastHigh[i] = lastHigh[i + 1];
        }
        lastHigh[COUNT_REGS_BEFORE - 1] = useReg;
    }

    /**
     * 更新寄存器的取值
     * @param useReg 当前指令存储数值的寄存器
     */
    public void update(int useReg) {
        for (int i = 0; i < COUNT_REGS_BEFORE; ++i) {
            last[i] = last[i + 1];
        }
        last[COUNT_REGS_BEFORE - 1] = useReg;
        switch (getRegType(useReg)) {
            case "low":
                updateLow(useReg);
            case "mid":
                updateMid(useReg);
            case "high":
                updateHigh(useReg);
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
     * 随机有符号立即数
     * @return 有符号立即数
     */
    public int randomSignedImm() {
        return randInt(-0x8000, 0x7fff);
    }

    /**
     * 随机无符号立即数
     * @param reg 寄存器编号
     * @return 寄存器对应的无符号立即数
     */
    public int randomUnsignedImm(int reg) {
        if ("low".equals(getRegType(reg))) {
            return randInt(1);
        } else {
            return randomUnsignedImm();
        }
    }

    public int randomSignedImm(int reg) {
        if ("low".equals(getRegType(reg))) {
            return randInt(3);
        } else {
            return randomSignedImm();
        }
    }

    /**
     * 获取寄存器的类型
     * @param reg 寄存器编号
     * @return 类型
     */
    public String getRegType(int reg) {
        if (LOW_REG_START <= reg && reg <= LOW_REG_END) {
            return "low";
        } else if (MID_REG_START <= reg && reg <= MID_REG_END) {
            return "mid";
        } else if (HIGH_REG_START <= reg && reg <= HIGH_REG_END) {
            return "high";
        } else if (reg == 31) {
            return "mid";
        }
        return "none";
    }

    /**
     * 记录dm中已用的位置
     * @param val 使用过的地址
     */
    public void addValueToDm(int val, String type) {
        dmValue.put(val, type);
    }

    /**
     * 依据base寄存器的值生成offset
     * @param baseVal base寄存器的值
     * @return offset
     */
    public int randomDm(int baseVal, int reg) {
        ArrayList<Integer> list = new ArrayList<>(dmValue.keySet());
        if (list.isEmpty()) {
            return baseVal;
        }
        int index = randInt(list.size() - 1);
        for (int i = index; i < list.size(); ++i) {
            if (Math.abs(list.get(i) - baseVal) <= 0x7fff &&
                    getRegType(reg).equals(dmValue.get(list.get(i)))) {
                return list.get(i) - baseVal;
            }
        }
        for (int i = 0; i < index; ++i) {
            if (Math.abs(list.get(i) - baseVal) <= 0x7fff &&
                    getRegType(reg).equals(dmValue.get(list.get(i)))) {
                return list.get(i) - baseVal;
            }
        }
        return -baseVal;
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

    /**
     * 通过行数得到pc值
     * @param line 行数
     * @return pc值
     */
    public int getPc(int line) {
        return 4 * line + PC_BEGIN - 4;
    }

    /**
     * 判断数值是否合法
     * @param reg 寄存器
     * @param data 数值
     * @return 是否合法
     */
    public boolean isLegal(int reg, long data) {
        switch (getRegType(reg)) {
            case "high":
                return true;
            case "mid":
                return (data >= -0x8000 && data <= 0x7fff);
            case "low":
                return (data <= 1 && data >= 0);
        }
        return false;
    }

    public HashMap<Integer, String> getDmValue() {
        return dmValue;
    }

    public Random getRandom() {
        return random;
    }
}
