
package org.data_generator;

import org.constant.CommonConstant;
import org.Mips;
import org.constant.RegConstant;
import org.generator.*;
import org.util.RandomUtil;
import org.util.UnsignedInt;

import java.io.*;
import java.util.*;

/**
 * 数据生成
 */
public class Manager implements CommonConstant, RegConstant {

    //生成器列表
    private static final ArrayList<Generator> generators = new ArrayList<>();
    //mips
    private static Mips mips;
    //随机工具
    private static RandomUtil randomUtil;

    /**
     * 生成指令
     * @param path 指令存放的路径
     */
    public static void work(String path) {
        init();
        initReg();
        generate();
        print(path);
    }

    /**
     * 生成代码
     */
    public static void generate() {
        while (mips.getPc() <= PC_END) {
            //空块判定
            if (mips.getBlock() != null) {
                if (mips.getCodeStr().get(mips.getPc() + 8) != null) {
                    if ("beq".equals(mips.getBlock())) {
                        //beq跳出空白块
                        int rs = randomUtil.randomReg(true);
                        String codeStr = String.format("beq $%d, $%d, line%d",
                                rs, rs, randomUtil.getLine(mips.getBlockPc()));
                        mips.putCodeStr(codeStr);
                        mips.putCode(generators.get(5).translate(codeStr));
                    } else {
                        //jal跳出空白块
                        String codeStr = "jr $31";
                        mips.putCodeStr(codeStr);
                        mips.putCode(generators.get(8).translate(codeStr));
                    }
                    mips.addPc(4);
                    mips.putCodeStr("nop");
                    mips.putCode("00000000");
                    mips.setPc(mips.getBlockPc());
                    mips.setBlock(null, 0);
                    continue;
                }
            }

            //随机指令
            int op = randomUtil.randInt(generators.size() - 1);
            generators.get(op).generate();
        }
    }

    /**
     * 初始化寄存器
     */
    public static void initReg() {
        //初始化初级和中级寄存器
        for (int i = MID_REG_START ; i <= LOW_REG_END; ++i) {
            int val = randomUtil.randomUnsignedImm(i);
            String codeStr = String.format("ori $%d, $0, %d", i, val);
            mips.putCodeStr(codeStr);
            mips.putCode(generators.get(2).translate(codeStr));
            mips.setReg(i, val);
            mips.addPc(4);
        }
        //初始化高级寄存器
        for (int i = HIGH_REG_START + 1; i <= HIGH_REG_END; ++i) {
            int hi = randomUtil.randomUnsignedImm();
            int lo = randomUtil.randomUnsignedImm();
            String codeStr = String.format("lui $%d, %d", i, hi);
            mips.putCodeStr(codeStr);
            mips.putCode(generators.get(6).translate(codeStr));
            mips.addPc(4);
            codeStr = String.format("ori $%d, $%d, %d", i, i, lo);
            mips.putCodeStr(codeStr);
            mips.putCode(generators.get(2).translate(codeStr));
            mips.addPc(4);
            mips.setReg(i, UnsignedInt.toUnsignedInt(hi, lo));
        }
    }

    /**
     * 打印代码
     * @param path 存放路径
     */
    public static void print(String path) {
        //统计没有运行到的指令的数量
        int nopCount = 0;
        try (FileOutputStream asm = new FileOutputStream(path + "\\test.asm")) {
            try (FileOutputStream txt = new FileOutputStream(path + "\\code.txt")) {
                for (int i = PC_BEGIN; i <= PC_END; i += 4) {
                    String str = mips.getCodeStr().get(i);
                    String strTxt = mips.getCode().get(i) + '\n';
                    //无指令，则输出nop
                    if (str == null) {
                        str = "nop";
                        strTxt = "00000000\n";
                        ++nopCount;
                    }
                    //每行前加上line
                    str = String.format("line%d: ", randomUtil.getLine(i)) + str + "\r\n";
                    asm.write(str.getBytes());
                    txt.write(strTxt.getBytes());
                }
            }
        } catch (Exception e) {
            System.out.println("写入失败");
            return;
        }
        System.out.println("生成成功");
        double cover = 1 - ((nopCount << 2) / (double) (PC_END - PC_BEGIN));
        System.out.println("指令生成率:" + cover);
    }

    /**
     * 初始化
     */
    public static void init() {
        Random random = new Random();
        long seed = random.nextLong();
//        long seed = 1586263055370399576L;
        System.out.printf("开始生成数据，种子为%d\n", seed);
        mips = new Mips();
        randomUtil = new RandomUtil(seed);
        generators.add(new AddGenerator(mips, randomUtil));
        generators.add(new SubGenerator(mips, randomUtil));
        generators.add(new OriGenerator(mips, randomUtil));
        generators.add(new LwGenerator(mips, randomUtil));
        generators.add(new SwGenerator(mips, randomUtil));
        generators.add(new BeqGenerator(mips, randomUtil));
        generators.add(new LuiGenerator(mips, randomUtil));
        generators.add(new JalGenerator(mips, randomUtil));
        generators.add(new JrGenerator(mips, randomUtil));
    }
}
