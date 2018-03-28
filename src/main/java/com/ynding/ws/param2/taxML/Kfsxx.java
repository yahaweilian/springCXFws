package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 开发商信息实体
 * 
 * @date 2017-6-27
 * 
 * @author tianrui0518
 * 
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kfsxx", propOrder = {
    "kfsmc"
})
public class Kfsxx {
	@XmlElement(required = true)
    protected String kfsmc;//开发商名称
	public String getKfsmc() {
		return kfsmc;
	}
	public void setKfsmc(String kfsmc) {
		this.kfsmc = kfsmc;
	}
}
