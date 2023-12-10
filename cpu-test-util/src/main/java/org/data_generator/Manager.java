
package org.data_generator;

import org.constant.CommonConstant;
import org.generator.mfc0_generator.Mfc0Generator;
import org.generator.mtc0_generator.Mtc0Generator;
import org.generator.ri_generator.RiGenerator;
import org.generator.store_generator.StoreTcGenerator;
import org.generator.syscall_generator.SyscallGenerator;
import org.mips.Mips;
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
import org.util.Hex;
import org.util.MipsCode;
import org.util.RandomUtil;
import org.util.UnsignedInt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    //指令生成权重
    private static final ArrayList<Integer> weights = new ArrayList<>();
    //指令生成总权重
    private static int totalWeight;

    /**
     * 生成指令
     * @param path 指令存放的路径
     */
    public static void work(String path) {
        init();
        loadExcInt();
        initCtrl();
        initReg();
        generateInt();
        generate();
        print(path);
    }

    /**
     * 生成初始配置
     */
    public static void initCtrl() {
        int im = 0;
        for (int i = 0; i <= 5; ++i) {
            im |= randomUtil.randInt(0, 1) << i;
        }
        im |= 0b100;
        long sr = 1 + ((long) im << 10);
        int rt = randomUtil.randomMid(false);
        String codeStr = String.format("ori $%d, $0, %d", rt, sr);
        mips.putCodeStr(codeStr);
        mips.putCode(generators.get(2).translate(codeStr));
        mips.check();

        codeStr = String.format("mtc0 $%d, $12", rt);
        mips.putCodeStr(codeStr);
        mips.putCode(generators.get(29).translate(codeStr));
        mips.check();
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
            if (mips.getPc() == 0x38d0) {
                int j = 0;
            }
            generateSingle();
        }
    }

    /**
     * 生成单条指令
     */
    public static void generateSingle() {
        int op = 0;
        int sum = 0;
        int rand = randomUtil.randInt(1, totalWeight);
        for (int weight : weights) {
            sum += weight;
            if (rand <= sum) {
                generators.get(op).generate();
                break;
            }
            ++op;
        }
    }

    /**
     * 生成延迟槽指令
     */
    public static void generateDelaySlot() {
        mips.setDelaySlot(true);
        mips.addPc(4);
        do {
            generateSingle();
        } while(mips.isDelaySlot());
        mips.addPc(-4);
    }

    /**
     * 生成中断生成器中断
     */
    public static void generateInt() {
        int begin = randomUtil.getLine(PC_BEGIN + 8);
        int end = randomUtil.getLine(PC_END);
        int d = end - begin;
        d /= 10;
        for (int i = begin; i <= end - d; i += d) {
            int line = randomUtil.randInt(i, i + d - 1);
            int pc = randomUtil.getPc(line);
            mips.getInterrupts().add(pc);
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
     * 加载异常处理程序
     */
    public static void loadExcInt() {
        String path = "./resources";
        try {
            ArrayList<String> code = (ArrayList<String>)
                    Files.readAllLines(Paths.get(path + "/code.txt"));
            ArrayList<String> codeStr = (ArrayList<String>)
                    Files.readAllLines(Paths.get(path + "/codeStr.asm"));
            mips.setPc(EXC_INT_BEGIN);
            for (int i = 0; i < code.size(); ++i) {
                mips.getCode().put(mips.getPc(), code.get(i));
                mips.putCodeStr(codeStr.get(i));
                mips.addPc(4);
            }
        } catch (Exception e) {
            System.out.println("加载异常处理程序失败");
        }
        mips.setPc(PC_BEGIN);
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
                for (int i = PC_END + 4; i < EXC_INT_BEGIN; i += 4) {
                    String strTxt = "00000000\n";
                    txt.write(strTxt.getBytes());
                }
                asm.write(".ktext 0x4180\n".getBytes());
                int i = EXC_INT_BEGIN;
                while (mips.getCodeStr().get(i) != null) {
                    String str = mips.getCodeStr().get(i) + "\r\n";
                    String strTxt = mips.getCode().get(i) + '\n';
                    asm.write(str.getBytes());
                    txt.write(strTxt.getBytes());
                    i += 4;
                }
            }

            try (FileOutputStream tb = new FileOutputStream(path + "\\mips_tb.v")) {
                ArrayList<String> out = (ArrayList<String>)
                        Files.readAllLines(Paths.get("./resources/mips_tb.v"));
                int lines = 125;
                for (int i = 0; i <= 9; ++i) {
                    int pc = mips.getInterrupts().get(i);
                    if ("nop".equals(mips.getCodeStr().get(pc)) || mips.isMulDiv(pc)) {
                        pc = 0x10000;
                    }
                    out.add(lines, String.format("\t\t\tif (fixed_macroscopic_pc == 32'h%s) begin",
                            Hex.toHex(pc)));
                    lines++;
                    out.add(lines, "\t\t\t\tinterrupt = 1;");
                    lines++;
                    out.add(lines, "\t\t\tend");
                    lines++;
                }
                for (String str : out) {
                    tb.write((str + '\n').getBytes());
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
//        seed = 5002017596163405957L;
//        System.out.println(seed);
        mips = new Mips();
        mips.setGenerate(true);
        randomUtil = new RandomUtil(seed);
        generators.add(new AddGenerator(mips, randomUtil)); //0
        weights.add(10);
        generators.add(new SubGenerator(mips, randomUtil)); //1
        weights.add(10);
        generators.add(new OriGenerator(mips, randomUtil)); //2
        weights.add(10);
        generators.add(new LwGenerator(mips, randomUtil)); //3
        weights.add(10);
        generators.add(new SwGenerator(mips, randomUtil)); //4
        weights.add(10);
        generators.add(new BeqGenerator(mips, randomUtil)); //5
        weights.add(10);
        generators.add(new LuiGenerator(mips, randomUtil)); //6
        weights.add(10);
        generators.add(new JalGenerator(mips, randomUtil)); //7
        weights.add(10);
        generators.add(new JrGenerator(mips, randomUtil)); //8
        weights.add(10);
        generators.add(new OrGenerator(mips, randomUtil)); //9
        weights.add(10);
        generators.add(new AndGenerator(mips, randomUtil)); //10
        weights.add(10);
        generators.add(new SltGenerator(mips, randomUtil)); //11
        weights.add(1);
        generators.add(new SltuGenerator(mips, randomUtil)); //12
        weights.add(1);
        generators.add(new AndiGenerator(mips, randomUtil)); //13
        weights.add(5);
        generators.add(new AddiGenerator(mips, randomUtil)); //14
        weights.add(10);
        generators.add(new ShGenerator(mips, randomUtil)); //15
        weights.add(5);
        generators.add(new SbGenerator(mips, randomUtil)); //16
        weights.add(3);
        generators.add(new LhGenerator(mips, randomUtil)); //17
        weights.add(5);
        generators.add(new LbGenerator(mips, randomUtil)); //18
        weights.add(3);
        generators.add(new BneGenerator(mips, randomUtil)); //19
        weights.add(10);
        generators.add(new MultGenerator(mips, randomUtil)); //20
        weights.add(3);
        generators.add(new MultuGenerator(mips, randomUtil)); //21
        weights.add(3);
        generators.add(new DivGenerator(mips, randomUtil)); //22
        weights.add(3);
        generators.add(new DivuGenerator(mips, randomUtil)); //23
        weights.add(3);
        generators.add(new MfhiGenerator(mips, randomUtil)); //24
        weights.add(3);
        generators.add(new MfloGenerator(mips, randomUtil)); //25
        weights.add(3);
        generators.add(new MthiGenerator(mips, randomUtil)); //26
        weights.add(3);
        generators.add(new MtloGenerator(mips, randomUtil)); //27
        weights.add(3);
        generators.add(new Mfc0Generator(mips, randomUtil)); //28
        weights.add(5);
        generators.add(new Mtc0Generator(mips, randomUtil)); //29
        weights.add(5);
        generators.add(new SyscallGenerator(mips, randomUtil)); //30
        weights.add(1);
        generators.add(new RiGenerator(mips, randomUtil)); //31
        weights.add(1);
        generators.add(new StoreTcGenerator(mips, randomUtil)); //32
        weights.add(2);
        totalWeight = 0;
        for (int weight : weights) {
           totalWeight += weight;
        }
    }
}
