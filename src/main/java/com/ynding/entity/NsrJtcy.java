package com.ynding.entity;

import java.io.Serializable;

/**
 * Created by wangdong on 2017/7/16.
 * 纳税人家庭成员
 */
public class NsrJtcy implements Serializable{

    private String nsrId;//纳税人id

    private String xm;//姓名

    private String zjhm;//证件类型

    private String gx;//关系

    private String jzd;//居住地

    private String bz;//备注

    private String yxbj;//有效标记 0表示未有效 1为无效

    public String getNsrId() {
        return nsrId;
    }

    public void setNsrId(String nsrId) {
        this.nsrId = nsrId;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getGx() {
        return gx;
    }

    public void setGx(String gx) {
        this.gx = gx;
    }

    public String getJzd() {
        return jzd;
    }

    public void setJzd(String jzd) {
        this.jzd = jzd;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getYxbj() {
        return yxbj;
    }

    public void setYxbj(String yxbj) {
        this.yxbj = yxbj;
    }
}
