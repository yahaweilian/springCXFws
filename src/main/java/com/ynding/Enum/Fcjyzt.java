package com.ynding.Enum;

/**
 * 房产交易办税状态
 * Created by zzy on 2017/6/29.
 */
public enum Fcjyzt {
    TJDSH("100","提交待审核",100),
    ZDSHZ("200","自动审核中",200),ZDSHZRG("201","自动审核转人工",201),ZDSHYC("202","自动审核异常",202),ZDSHYCZRG("203","自动审核异常转人工",203),
    RGSHZ("210","人工审核中",210),
    ZDHJZ("220","自动核价计税中",220),ZDHJZRG("221","自动核价计税转人工",221),ZDHJYC("222","自动核价计税异常",222),ZDHJYCZRG("223","自动核价计税异常转人工",223),
    RGHJZ("230","人工核价计税中",230),
    RGFSZ("240","人工复审中",240),
    SHTG("300","审核通过待申报",300),
    YSBDJK("400","已申报代缴款",400),
    YJYJK("500","已缴款",500),
    YFKWBM("600","已反馈外部门",600),
    SHTH("900","审核退回",900),
    QX("901","取消",901),
    YZF("000","已作废",0);


    Fcjyzt(String ztdm,String ztmc , int id){
        _no = ztdm;
        _name = ztmc;
        _id = id;
    }

    private String _no;
    private String _name;
    private int _id;


    public String getFcjyztName(){
        return _name;
    }
    public String getFcjyztNo(){
        return _no;
    }
    public int getFcjyztId(){
        return _id;
    }
}
