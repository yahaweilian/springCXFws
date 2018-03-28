package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 承受方信息实体
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
@XmlType(name = "Crfxx", propOrder = {
		    "xm",
		    "zjlx",
		    "zjhm",
		    "dh",
		    "dz",
		    "gj",
		    "szfe",
		    "gyrbj",
		    "jyfe",
		    "djxh",
		    "fcbh",
		    "htbh",
		    "jyrlx",
		    "clr",
		    "zjlxmc"
})
public class Crfxx {
	  //房产编号  
		protected String fcbh;
		
		  //合同编号
		protected String htbh;
		  //交易人类型
		protected String jyrlx;
		
		@XmlElement(required = true)
	    protected String xm;//购买方姓名
		@XmlElement(required = true)
	    protected String zjlx;//证件类型
		@XmlElement(required = true)
	    protected String zjhm;//证件号码
		@XmlElement(required = true)
	    protected String dh;//联系电话
		@XmlElement(required = true)
	    protected String dz;//地址
		@XmlElement(required = true)
	    protected String gj;//国籍
		@XmlElement(required = true)
	    protected String gyrbj;//是否共有人标记
		
		//交易份额 
		private String jyfe;
		
		@XmlElement(required = true)
	    protected String szfe;//所占份额
		
		//登记序号
		private String djxh;
		private String clr;
		protected String zjlxmc;//证件类型名称 NSRZJLX_DM
	
	
	public String getClr() {
			return clr;
		}
		public void setClr(String clr) {
			this.clr = clr;
		}
	public String getGyrbj() {
		return gyrbj;
	}
	public void setGyrbj(String gyrbj) {
		this.gyrbj = gyrbj;
	}
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
	public String getSzfe() {
		return szfe;
	}
	public void setSzfe(String szfe) {
		this.szfe = szfe;
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
	public String getZjlxmc() {
		return zjlxmc;
	}
	public void setZjlxmc(String zjlxmc) {
		this.zjlxmc = zjlxmc;
	}
	


	
}
