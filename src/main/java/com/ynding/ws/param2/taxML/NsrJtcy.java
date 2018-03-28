package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by wangdong on 2017/7/16.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nsrjtcy", propOrder = {
        "xm",
        "zjhm",
        "gx",
        "jzd",
        "bz"
})
public class NsrJtcy {

    @XmlElement(required = true)
    protected String xm;//姓名
    @XmlElement(required = true)
    protected String zjhm;//证件号码
    @XmlElement(required = true)
    protected String gx;//关系
    @XmlElement(required = true)
    protected String jzd;//居住地
    protected String bz;//备注

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
}
