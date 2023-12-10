package org.mips;

import org.util.Hex;

/**
 * 时钟计数器类
 */
public class Tc implements Cloneable {

    //是否能够发送IRQ
    private boolean irq;
    //是否启动
    private boolean start;
    //present寄存器
    private long present;
    //count寄存器
    private long count;
    //ctrl寄存器
    private long ctrl;
    //状态
    private Cp0States state;
    //irq结束的pc
    private int irqPcEnd;

    public Tc() {
        irq = false;
        present = 0;
        count = 0;
        ctrl = 0;
        state = Cp0States.IDLE;
        irqPcEnd = 0;
    }

    /**
     * 运行一周期计数
     * @param pc 当前pc
     */
    public void check(int pc) {
        switch (state) {
            case IDLE:
                if (getEnable() == 1) {
                    state = Cp0States.LOAD;
                }
                break;
            case LOAD:
                count = present;
                state = Cp0States.CNT;
                break;
            case CNT:
                if (getEnable() == 1) {
                    count--;
                    if (count == 0) {
                        state = Cp0States.INT;
                        irq = true;
                        irqPcEnd = (int) (pc + (((present + 1) << 4)));
                    }
                }
                else {
                    state = Cp0States.IDLE;
                }
                break;
            default:
        }
        if (pc == irqPcEnd) {
            reset();
        }
    }

    /**
     * 响应中断后，更新寄存器
     */
    public void reset() {
        state = Cp0States.IDLE;
        ctrl = 0;
        irq = false;
        start = false;
    }

    /**
     * 获取ctrl[0]位enable信号
     * @return enable信号
     */
    public long getEnable() {
        return Hex.toHex(ctrl).toDec(0, 0);
    }

    /**
     * 从tc读值
     * @param addr 地址
     * @return 读取结果
     */
    public long read(long addr) {
        int id = (int) addr & 0xf;
        switch (id) {
            case 0:
                return getCtrl();
            case 4:
                return getPresent();
            default:
                return 0L;
        }
    }

    /**
     * 向tc写值
     * @param addr 地址
     * @param data 值
     */
    public void write(long addr, long data) {
        int id = (int) addr & 0xf;
        switch (id) {
            case 0:
                setCtrl(data);
                break;
            case 4:
                setPresent(data);
                break;
            default:
        }
    }

    @Override
    public Tc clone() {
        try {
            Tc clone = (Tc) super.clone();
            clone.setCtrl(ctrl);
            clone.setIrq(irq);
            clone.setPresent(present);
            return clone;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean isIrq() {
        return irq;
    }

    public void setIrq(boolean irq) {
        this.irq = irq;
    }

    public long getPresent() {
        return present;
    }

    public void setPresent(long present) {
        this.present = present;
    }

    public long getCount() {
        return count;
    }

    public long getCtrl() {
        return ctrl;
    }

    public void setCtrl(long ctrl) {
        this.ctrl = ctrl;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }
}
