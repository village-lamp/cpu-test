package org.mips;

import org.util.Hex;

/**
 * cp0协处理器类
 */
public class Cp0 implements Cloneable {
    //cause寄存器id
    private static final int CAUSE_ID = 13;
    //sr寄存器id
    private static final int SR_ID = 12;
    //epc寄存器id
    private static final int EPC_ID = 14;
    //存储异常信息的寄存器
    private long cause;
    //存储异常地址的寄存器
    private long epc;
    //存储配置的寄存器
    private long sr;

    public Cp0() {
        cause = 0;
        epc = 0;
        sr = 0;
    }

    /**
     * 向cp0写入值
     * @param val 值
     * @param id 寄存器编号
     */
    public void write(long val, int id) {
        switch (id) {
            case EPC_ID:
                setEpc(val);
                break;
            case SR_ID:
                setSr(val);
                break;
            default:
        }
    }

    /**
     * 从cp0读值
     * @param id 寄存器编号
     * @return 读取结果
     */
    public long read(int id) {
        switch (id) {
            case EPC_ID:
                return getEpc();
            case SR_ID:
                return getSr();
            case CAUSE_ID:
                return getCause();
            default:
                return 0L;
        }
    }

    /**
     * 获取ExcCode, Cause[2:6]
     * @return ExcCode
     */
    public long getExcCode() {
        return Hex.toHex(cause).toDec(2, 6);
    }

    /**
     * 设置ExcCode
     * @param excCode 设置值
     */
    public void setExcCode(int excCode) {
        setCause(getBd(), getIp(), excCode);
    }

    /**
     * 获取BD, Cause[31]
     * @return BD
     */
    public long getBd() {
        return Hex.toHex(cause).toDec(31, 31);
    }

    /**
     * 设置BD
     * @param bd 设置值
     */
    public void setBd(int bd) {
        setCause(bd, getIp(), getExcCode());
    }

    /**
     * 获取IP, Cause[10:15]
     * @return IP
     */
    public long getIp() {
        return Hex.toHex(cause).toDec(10, 15);
    }

    /**
     * 设置IP
     * @param ip 设置值
     */
    public void setIp(int ip) {
        setCause(getBd(), ip, getExcCode());
    }

    /**
     * 通过各个分量设置Cause
     * @param bd BD
     * @param ip IP
     * @param excCode ExcCode
     */
    public void setCause(long bd, long ip, long excCode) {
        cause = (bd << 31) + (ip << 10) + (excCode << 2);
    }

    /**
     * 获取IE, SR[0]
     * @return IE
     */
    public long getIe() {
        return Hex.toHex(sr).toDec(0, 0);
    }

    /**
     * 设置IE
     * @param ie 设置值
     */
    public void setIe(int ie) {
        setSr(getIm(), getExl(), ie);
    }

    /**
     * 获取EXL, SR[1]
     * @return EXL
     */
    public long getExl() {
        return Hex.toHex(sr).toDec(1, 1);
    }

    /**
     * 设置EXL
     * @param exl 设置值
     */
    public void setExl(int exl) {
        setSr(getIm(), exl, getIe());
    }

    /**
     * 获取IM, SR[10:15]
     * @return IM
     */
    public long getIm() {
        return Hex.toHex(sr).toDec(10, 15);
    }

    /**
     * 设置IM
     * @param im 设置值
     */
    public void setIm(int im) {
        setSr(im, getExl(), getIe());
    }

    /**
     * 通过各个分量设置SR
     * @param im IM
     * @param exl EXL
     * @param ie IE
     */
    public void setSr(long im, long exl, long ie) {
        sr = (im << 10) + (exl << 1) + ie;
    }

    public long getCause() {
        return cause;
    }

    public void setCause(long cause) {
        this.cause = cause;
    }

    public long getEpc() {
        return epc;
    }

    public void setEpc(long epc) {
        this.epc = epc;
    }

    public long getSr() {
        return sr;
    }

    public void setSr(long sr) {
        this.sr = sr;
    }

    @Override
    public Cp0 clone() {
        try {
            Cp0 clone = (Cp0) super.clone();
            clone.setSr(sr);
            clone.setEpc(epc);
            clone.setCause(cause);
            return clone;
        } catch (Exception e) {
            return null;
        }
    }
}
