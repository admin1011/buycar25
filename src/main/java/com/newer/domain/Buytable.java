package com.newer.domain;

import java.io.Serializable;
import java.sql.Date;

public class Buytable implements Serializable {
    private Integer buyId;//采购单ID
    private Integer fid;//供应商ID
    private String fname;//供应商名称
    private Integer uid;//采购员编号
    private Date indentTime;//创建时间
    private String uname;//创建者姓名
    private Date payerTime;//付头款时间
    private Date incomeTime;//收货时间
    private float dprice;//单价
    private Integer number;//数量
    private float zprice;//总价
    private Date alterTime;//完结时间
    private String indentType;//订单状态
    private String remark1;//备用列1

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getIndentTime() {
        return indentTime;
    }

    public void setIndentTime(Date indentTime) {
        this.indentTime = indentTime;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getPayerTime() {
        return payerTime;
    }

    public void setPayerTime(Date payerTime) {
        this.payerTime = payerTime;
    }

    public Date getIncomeTime() {
        return incomeTime;
    }

    public void setIncomeTime(Date incomeTime) {
        this.incomeTime = incomeTime;
    }

    public float getDprice() {
        return dprice;
    }

    public void setDprice(float dprice) {
        this.dprice = dprice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public float getZprice() {
        return zprice;
    }

    public void setZprice(float zprice) {
        this.zprice = zprice;
    }

    public Date getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(Date alterTime) {
        this.alterTime = alterTime;
    }

    public String getIndentType() {
        return indentType;
    }

    public void setIndentType(String indentType) {
        this.indentType = indentType;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
}
