package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *查询时请求报文的纳税人信息
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Nsr", propOrder = {
        "xm",
        "zjhm",
})
public class Nsr {

    @XmlElement(required = true)
    protected String xm;//姓名
    @XmlElement(required = true)
    protected String zjhm;//证件号码

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
}
