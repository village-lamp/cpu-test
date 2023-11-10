
package org.data_generator;

import org.constant.CommonConstant;
import org.Mips;
import org.constant.RegConstant;
import org.generator.*;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.util.RandomUtil;
import org.util.UnsignedInt;

import java.io.*;
import java.util.*;

/**
 * 数据生成管理类
 */

public class Manager implements CommonConstant, RegConstant {
    //生成器列表
    private static final ArrayList<Generator> generators = new ArrayList<>();
    private static Mips mips;
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

    //生成代码
    public static void generate() {
        while (mips.getPc() <= PC_END) {
            if (mips.getBlock() != null) {
                if (mips.getPc() + 12 == mips.getBlockPc()) {
                    if ("beq".equals(mips.getBlock())) {
                        //beq跳出空白块
                        int rs = randomUtil.randomReg(true);
                        mips.putCodeStr(String.format("beq $%d, $%d, line%d",
                                rs, rs, randomUtil.getLine(mips.getBlockPc())));
                    } else {
                        //jal跳出空白块
                        mips.putCodeStr("jr $ra");
                    }
                    mips.addPc(4);
                    mips.putCodeStr("nop");
                    mips.setPc(mips.getBlockPc());
                    continue;
                }
            }
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
        for (int i = HIGH_REG_START; i <= HIGH_REG_END; ++i) {
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

    //打印代码
    public static void print(String path) {
        path += "\\test.asm";
        TreeMap<Integer, String> code = new TreeMap<>(mips.getCodeStr());
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            for (Map.Entry<Integer, String> entry : code.entrySet()) {
                String str;
                if (entry.getKey() == 0x3000) {
                    str = ".ktext\r\n";
                    fileOutputStream.write(str.getBytes());
                }
                str = String.format("line%d:", randomUtil.getLine(entry.getKey()));
                str += entry.getValue() + "\r\n";
                fileOutputStream.write(str.getBytes());
            }
        } catch (Exception e) {
            System.out.println("写入test.asm失败");
            return;
        }
        System.out.println("生成test.asm成功");
    }

    public static void init() {
        Random random = new Random();
        long seed = random.nextLong();
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
