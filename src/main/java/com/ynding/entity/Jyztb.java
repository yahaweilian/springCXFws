package com.ynding.entity;

import java.io.Serializable;
import java.util.Date;


public class Jyztb implements Serializable {

	/**
	 * 交易状态实体
	 */
	private static final long serialVersionUID = 1L;
	
	private String  fcxxId;//房产id 
	private String  jyId;//交易id 
	private String  jyzt;//交易状态 
	private String  shSwryDm;//审核操作人员 
	private Date    shsj;//审核时间 
	private String  hjjsSwryDm;//核价计税人员 
	private Date  hjjssj;//核价计税时间  
	private String  fsSwryDm;//复审人员 
	private Date    fssj;//复审时间 
	private String  shyj;//审核意见 
	private String  hjjsyj;//核价计税意见 
	private Date    zfsj;    //作废时间
	private String  zfSswryDm; //作废人员
	private Date    lrsj;//录入时间
	private Date    wssj;//完税时间
	private String  qszydx;//权属转移对象
	private String  qszyyt;//权属转移用途
	private float   tnmj;//套内面积
	private String  fssslx;//附属设施类型
	private float   fsmj;//附属物面积
	private String  zjId;//中介信息表的id
	private float   htjg; //合同价格
	private  Date  htqdrq; //合同签订日期
	private String  channelId; //渠道id
	private String  xzqhDm; //这里保存的是金三的行政区划代码
	private String  jdxzDm; //这里保存的是金三的街道乡镇代码
	private String hzzsse; //含增值税税额
	private String bhzzsse;//不含增值税税额
	private String  qszylb;//权属转移类别（方式）
	private String zjmc;//中介名称
	
	private String zjgsbm; // 中介公司代码
	private String zjysbh; // 中介公司办理人识别号
	
	private String acceptcode;//房管图片code
	private String fwnm;//房屋内码

	public String getZjgsbm() {
		return zjgsbm;
	}

	public void setZjgsbm(String zjgsbm) {
		this.zjgsbm = zjgsbm;
	}

	public String getZjysbh() {
		return zjysbh;
	}

	public void setZjysbh(String zjysbh) {
		this.zjysbh = zjysbh;
	}

	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}
	
	public String getQszylb() {
		return qszylb;
	}
	public void setQszylb(String qszylb) {
		this.qszylb = qszylb;
	}
	public String getFcxxId() {
		return fcxxId;
	}
	public void setFcxxId(String fcxxId) {
		this.fcxxId = fcxxId;
	}
	public String getJyId() {
		return jyId;
	}
	public void setJyId(String jyId) {
		this.jyId = jyId;
	}
	public String getJyzt() {
		return jyzt;
	}
	public void setJyzt(String jyzt) {
		this.jyzt = jyzt;
	}
	public String getShSwryDm() {
		return shSwryDm;
	}
	public void setShSwryDm(String shSwryDm) {
		this.shSwryDm = shSwryDm;
	}
	public Date getShsj() {
		return shsj;
	}
	public void setShsj(Date shsj) {
		this.shsj = shsj;
	}
	public String getHjjsSwryDm() {
		return hjjsSwryDm;
	}
	public void setHjjsSwryDm(String hjjsSwryDm) {
		this.hjjsSwryDm = hjjsSwryDm;
	}	
	public Date getHjjssj() {
		return hjjssj;
	}
	public void setHjjssj(Date hjjssj) {
		this.hjjssj = hjjssj;
	}
	public String getFsSwryDm() {
		return fsSwryDm;
	}
	public void setFsSwryDm(String fsSwryDm) {
		this.fsSwryDm = fsSwryDm;
	}
	public Date getFssj() {
		return fssj;
	}
	public void setFssj(Date fssj) {
		this.fssj = fssj;
	}
	public String getShyj() {
		return shyj;
	}
	public void setShyj(String shyj) {
		this.shyj = shyj;
	}
	public String getHjjsyj() {
		return hjjsyj;
	}
	public void setHjjsyj(String hjjsyj) {
		this.hjjsyj = hjjsyj;
	}	
	public Date getZfsj() {
		return zfsj;
	}
	public void setZfsj(Date zfsj) {
		this.zfsj = zfsj;
	}
	public String getZfSswryDm() {
		return zfSswryDm;
	}
	public void setZfSswryDm(String zfSswryDm) {
		this.zfSswryDm = zfSswryDm;
	}
	public Date getLrsj() {
		return lrsj;
	}
	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}
	public Date getWssj() {
		return wssj;
	}
	public void setWssj(Date wssj) {
		this.wssj = wssj;
	}
	public String getQszydx() {
		return qszydx;
	}
	public void setQszydx(String qszydx) {
		this.qszydx = qszydx;
	}
	public String getQszyyt() {
		return qszyyt;
	}
	public void setQszyyt(String qszyyt) {
		this.qszyyt = qszyyt;
	}
	public float getTnmj() {
		return tnmj;
	}
	public void setTnmj(float tnmj) {
		this.tnmj = tnmj;
	}
	public String getFssslx() {
		return fssslx;
	}
	public void setFssslx(String fssslx) {
		this.fssslx = fssslx;
	}
	public float getFsmj() {
		return fsmj;
	}
	public void setFsmj(float fsmj) {
		this.fsmj = fsmj;
	}
	public String getZjId() {
		return zjId;
	}
	public void setZjId(String zjId) {
		this.zjId = zjId;
	}
	public float getHtjg() {
		return htjg;
	}
	public void setHtjg(float htjg) {
		this.htjg = htjg;
	}
	public Date getHtqdrq() {
		return htqdrq;
	}
	public void setHtqdrq(Date htqdrq) {
		this.htqdrq = htqdrq;
	}	
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	public String getXzqhDm() {
		return xzqhDm;
	}
	public void setXzqhDm(String xzqhDm) {
		this.xzqhDm = xzqhDm;
	}
	public String getJdxzDm() {
		return jdxzDm;
	}
	public void setJdxzDm(String jdxzDm) {
		this.jdxzDm = jdxzDm;
	}
	public String getHzzsse() {
		return hzzsse;
	}
	public void setHzzsse(String hzzsse) {
		this.hzzsse = hzzsse;
	}
	public String getBhzzsse() {
		return bhzzsse;
	}
	public void setBhzzsse(String bhzzsse) {
		this.bhzzsse = bhzzsse;
	}

	public String getAcceptcode() {
		return acceptcode;
	}

	public void setAcceptcode(String acceptcode) {
		this.acceptcode = acceptcode;
	}

	public String getFwnm() {
		return fwnm;
	}

	public void setFwnm(String fwnm) {
		this.fwnm = fwnm;
	}
	
	
	

}
