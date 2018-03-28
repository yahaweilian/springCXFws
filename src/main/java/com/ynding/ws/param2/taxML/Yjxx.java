package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/********
 * 
 * 邮寄信息实体bean
 * 
 * tianrui0518
 * 
 * 20170808
 * ******/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Yjxx",propOrder = {"xm","dh","dz"})
public class Yjxx {

	private String xm;//姓名
	private String dh;//电话
	private String dz;//地址

	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
}
