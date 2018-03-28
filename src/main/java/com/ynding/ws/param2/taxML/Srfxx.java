package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 购买人信息实体
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
@XmlType(name = "Srfxx", propOrder = {
    "xm",
    "zjlx",
    "zjlxmc",
    "zjhm",
    "dh",
    "dz",
    "gj",
    "szfe",
    "gyrbj",
    "jyfe",
    "djxh",
    "clr",
    "fcbh",
    "htbh",
    "jyrlx"
})
public class Srfxx {
	  //房产编号FCXX_ID
	protected String fcbh;
	  //合同编号(添加) HTBH
	protected String htbh;
	  //交易人类型(NSRLX) 纳税人类型 个人：100000010  公司：100000020
	protected String jyrlx;
	@XmlElement(required = true)
    protected String xm;//购买方姓名  NSRXM
	@XmlElement(required = true)
    protected String zjlx;//证件类型  NSRZJLX_DM
	@XmlElement(required = true)
    protected String zjhm;//证件号码 NSRZJHM
	@XmlElement(required = true)
    protected String dh;//联系电话 DH
	@XmlElement(required = true)
    protected String dz;//地址 DZ
	@XmlElement(required = true)
    protected String gj;//国籍 GJ_DM
	@XmlElement(required = true)
    protected String gyrbj;//是否共有人标记 GYRBJ  共有人标记  0不是共有人 1是共有人
	//交易份额 JYFE
	private String jyfe; 
	@XmlElement(required = true)
    protected String szfe;//所占份额 SZFE
	//登记序号 DJXH
	private String djxh;
	private String clr;
	protected String zjlxmc;//证件类型名称 NSRZJLX_DM

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
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

	public String getGj() {
		return gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	public String getGyrbj() {
		return gyrbj;
	}

	public void setGyrbj(String gyrbj) {
		this.gyrbj = gyrbj;
	}

	public String getSzfe() {
		return szfe;
	}

	public void setSzfe(String szfe) {
		this.szfe = szfe;
	}

	public String getZjlxmc() {
		return zjlxmc;
	}

	public void setZjlxmc(String zjlxmc) {
		this.zjlxmc = zjlxmc;
	}

	public String getFcbh() {
		return fcbh;
	}

	public void setFcbh(String fcbh) {
		this.fcbh = fcbh;
	}

	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}

	public String getJyrlx() {
		return jyrlx;
	}

	public void setJyrlx(String jyrlx) {
		this.jyrlx = jyrlx;
	}

	public String getJyfe() {
		return jyfe;
	}

	public void setJyfe(String jyfe) {
		this.jyfe = jyfe;
	}

	public String getDjxh() {
		return djxh;
	}

	public void setDjxh(String djxh) {
		this.djxh = djxh;
	}

	public String getClr() {
		return clr;
	}

	public void setClr(String clr) {
		this.clr = clr;
	}

	
	
}
