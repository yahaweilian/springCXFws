package com.ynding.entity;

import java.io.Serializable;
import java.util.Date;

public class Nsr implements Serializable{

	/**
	 * 纳税人
	 */
	private static final long serialVersionUID = 1L;
	private String  nsrId;//纳税人编码
	private String  sfzUrl;//身份证图片url
	private String  fcxxId;//房产编码
	private String  nsrlx;//纳税人类型 个人：100000010  公司：100000020
	private String  nsrxm;//姓名
	private String  nsrzjlxDm;//证件类型
	private String  nsrzjhm;//证件号码
	private String  dz;//地址
	private String  dh;//联系方式
	private String  czryDm;//操作员
	private Date    lrsj;//录入时间
	private String  zgswjgDm;//主管税务机关
	private String  djzclxDm;//登记注册类型
	private String  hyDm;//行业代码
	private String  mmfbj;//买卖方标记(买方1卖方0)
	private String  shbj;//审核标记
	private String  zsbj;//征收标记
	private String  scbj;//删除标记
	private String  gjDm;//国籍
	private String djxh;//登记序号
	private String  gyrbj ;//共有人标记  0不是共有人 1是共有人
	private String  cfjg;//查房结果
	private String  szfe;//所占份额
	
	private String fcbh; //房产编号
	private String htbh; //合同编号
	private String jyrlx;//交易人类型
	private String jyfe;//交易份额
	
	private String zjlxmc;//证件类型名称
	private String clr; //处理人
	
	
	public String getClr() {
		return clr;
	}
	public void setClr(String clr) {
		this.clr = clr;
	}
	public String getNsrId() {
		return nsrId;
	}
	public void setNsrId(String nsrId) {
		this.nsrId = nsrId;
	}
	public String getSfzUrl() {
		return sfzUrl;
	}
	public void setSfzUrl(String sfzUrl) {
		this.sfzUrl = sfzUrl;
	}
	public String getFcxxId() {
		return fcxxId;
	}
	public void setFcxxId(String fcxxId) {
		this.fcxxId = fcxxId;
	}
	public String getNsrlx() {
		return nsrlx;
	}
	public void setNsrlx(String nsrlx) {
		this.nsrlx = nsrlx;
	}
	public String getNsrxm() {
		return nsrxm;
	}
	public void setNsrxm(String nsrxm) {
		this.nsrxm = nsrxm;
	}
	public String getNsrzjlxDm() {
		return nsrzjlxDm;
	}
	public void setNsrzjlxDm(String nsrzjlxDm) {
		this.nsrzjlxDm = nsrzjlxDm;
	}
	public String getNsrzjhm() {
		return nsrzjhm;
	}
	public void setNsrzjhm(String nsrzjhm) {
		this.nsrzjhm = nsrzjhm;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getCzryDm() {
		return czryDm;
	}
	public void setCzryDm(String czryDm) {
		this.czryDm = czryDm;
	}
	public Date getLrsj() {
		return lrsj;
	}
	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}
	public String getZgswjgDm() {
		return zgswjgDm;
	}
	public void setZgswjgDm(String zgswjgDm) {
		this.zgswjgDm = zgswjgDm;
	}
	public String getDjzclxDm() {
		return djzclxDm;
	}
	public void setDjzclxDm(String djzclxDm) {
		this.djzclxDm = djzclxDm;
	}
	public String getHyDm() {
		return hyDm;
	}
	public void setHyDm(String hyDm) {
		this.hyDm = hyDm;
	}
	public String getMmfbj() {
		return mmfbj;
	}
	public void setMmfbj(String mmfbj) {
		this.mmfbj = mmfbj;
	}
	public String getShbj() {
		return shbj;
	}
	public void setShbj(String shbj) {
		this.shbj = shbj;
	}
	public String getZsbj() {
		return zsbj;
	}
	public void setZsbj(String zsbj) {
		this.zsbj = zsbj;
	}
	public String getScbj() {
		return scbj;
	}
	public void setScbj(String scbj) {
		this.scbj = scbj;
	}
	public String getGjDm() {
		return gjDm;
	}
	public void setGjDm(String gjDm) {
		this.gjDm = gjDm;
	}

	public String getDjxh() {
		return djxh;
	}

	public void setDjxh(String djxh) {
		this.djxh = djxh;
	}
	public String getGyrbj() {
		return gyrbj;
	}
	public void setGyrbj(String gyrbj) {
		this.gyrbj = gyrbj;
	}
	public String getCfjg() {
		return cfjg;
	}
	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
	}
	public String getSzfe() {
		return szfe;
	}
	public void setSzfe(String szfe) {
		this.szfe = szfe;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getZjlxmc() {
		return zjlxmc;
	}
	public void setZjlxmc(String zjlxmc) {
		this.zjlxmc = zjlxmc;
	}

}
