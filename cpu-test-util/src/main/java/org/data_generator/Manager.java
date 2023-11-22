
package org.data_generator;

import org.constant.CommonConstant;
import org.Mips;
import org.constant.RegConstant;
import org.generator.*;
import org.generator.br_r2_generator.BeqGenerator;
import org.generator.br_r2_generator.BneGenerator;
import org.generator.cal_ri_generator.AddiGenerator;
import org.generator.cal_ri_generator.AndiGenerator;
import org.generator.cal_ri_generator.OriGenerator;
import org.generator.cal_rr_generator.*;
import org.generator.jal_generator.JalGenerator;
import org.generator.jr_generator.JrGenerator;
import org.generator.load_generator.LbGenerator;
import org.generator.load_generator.LhGenerator;
import org.generator.load_generator.LwGenerator;
import org.generator.lui_generator.LuiGenerator;
import org.generator.mul_div_generator.DivGenerator;
import org.generator.mul_div_generator.DivuGenerator;
import org.generator.mul_div_generator.MultGenerator;
import org.generator.mul_div_generator.MultuGenerator;
import org.generator.mv_fr_generator.MfhiGenerator;
import org.generator.mv_fr_generator.MfloGenerator;
import org.generator.mv_to_generator.MthiGenerator;
import org.generator.mv_to_generator.MtloGenerator;
import org.generator.store_generator.SbGenerator;
import org.generator.store_generator.ShGenerator;
import org.generator.store_generator.SwGenerator;
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
    //种子
    private static long seed;

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

            if (mips.getPc() == 0x3268) {
                int j = 0;
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
        try (FileOutputStream asm = new FileOutputStream(path + "\\" + seed + ".asm")) {
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
        seed = random.nextLong();
//        seed = -5906435837150503271L;
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
        generators.add(new OrGenerator(mips, randomUtil));
        generators.add(new AndGenerator(mips, randomUtil));
        generators.add(new SltGenerator(mips, randomUtil));
        generators.add(new SltuGenerator(mips, randomUtil));
        generators.add(new AndiGenerator(mips, randomUtil));
        generators.add(new AddiGenerator(mips, randomUtil));
        generators.add(new ShGenerator(mips, randomUtil));
        generators.add(new SbGenerator(mips, randomUtil));
        generators.add(new LhGenerator(mips, randomUtil));
        generators.add(new LbGenerator(mips, randomUtil));
        generators.add(new BneGenerator(mips, randomUtil));
        generators.add(new MultGenerator(mips, randomUtil));
        generators.add(new MultuGenerator(mips, randomUtil));
        generators.add(new DivGenerator(mips, randomUtil));
        generators.add(new DivuGenerator(mips, randomUtil));
        generators.add(new MfhiGenerator(mips, randomUtil));
        generators.add(new MfloGenerator(mips, randomUtil));
        generators.add(new MthiGenerator(mips, randomUtil));
        generators.add(new MtloGenerator(mips, randomUtil));
    }
}
