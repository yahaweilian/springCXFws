package com.ynding.entity;

import java.io.Serializable;

public class Jyskb implements Serializable{

	/**
	 * 交易税款表
	 */
	private static final long serialVersionUID = 1L;
	
	
	 private  String  skbid ; //税款表ID	 
	 private  String  mmfbz; //买卖方标志（买方0卖方1）
	 private  String  zsxmDm; //征收项目代码
	 private  String  zsxmmc; //征收项目代码名称
	 private  String  syqk; //适用情况
	 private  float   sl; //税率
	 private  String  jmxzdm; //减免性质代码
	 private  String  jmxzmc; //减免性质名称
	 private  String  jmsxdmjmc; //减免事项代码及名称
	 private  String  qybz; //启用标志
	 private  String  clfzlfbz; //存量房增量房标志（0增量房1存量房）
	 private  String  zxpmDm; //征收品目
	 private  String  zszmDm; //征收子目
	 private  String  sfhtjejz; //是否合同金额计征
	 private  double  jsje;//计税金额
     private  double  se;//税额
    private  String  nsrid;//纳税人ID
    private  String  fcxxId; //房产交易ID
    private  float   jyfe;   //交易份额   
    private  String  szZsxmDm;
	public String getSkbid() {
		return skbid;
	}
	public void setSkbid(String skbid) {
		this.skbid = skbid;
	}
	public String getMmfbz() {
		return mmfbz;
	}
	public void setMmfbz(String mmfbz) {
		this.mmfbz = mmfbz;
	}
	public String getZsxmDm() {
		return zsxmDm;
	}
	public void setZsxmDm(String zsxmDm) {
		this.zsxmDm = zsxmDm;
	}
	public String getZsxmmc() {
		return zsxmmc;
	}
	public void setZsxmmc(String zsxmmc) {
		this.zsxmmc = zsxmmc;
	}
	public String getSyqk() {
		return syqk;
	}
	public void setSyqk(String syqk) {
		this.syqk = syqk;
	}
	public float getSl() {
		return sl;
	}
	public void setSl(float sl) {
		this.sl = sl;
	}
	public String getJmxzdm() {
		return jmxzdm;
	}
	public void setJmxzdm(String jmxzdm) {
		this.jmxzdm = jmxzdm;
	}
	public String getJmxzmc() {
		return jmxzmc;
	}
	public void setJmxzmc(String jmxzmc) {
		this.jmxzmc = jmxzmc;
	}
	public String getJmsxdmjmc() {
		return jmsxdmjmc;
	}
	public void setJmsxdmjmc(String jmsxdmjmc) {
		this.jmsxdmjmc = jmsxdmjmc;
	}
	public String getQybz() {
		return qybz;
	}
	public void setQybz(String qybz) {
		this.qybz = qybz;
	}
	public String getClfzlfbz() {
		return clfzlfbz;
	}
	public void setClfzlfbz(String clfzlfbz) {
		this.clfzlfbz = clfzlfbz;
	}
	public String getZxpmDm() {
		return zxpmDm;
	}
	public void setZxpmDm(String zxpmDm) {
		this.zxpmDm = zxpmDm;
	}
	public String getZszmDm() {
		return zszmDm;
	}
	public void setZszmDm(String zszmDm) {
		this.zszmDm = zszmDm;
	}
	public String getSfhtjejz() {
		return sfhtjejz;
	}
	public void setSfhtjejz(String sfhtjejz) {
		this.sfhtjejz = sfhtjejz;
	}
	public double getJsje() {
		return jsje;
	}
	public void setJsje(double jsje) {
		this.jsje = jsje;
	}
	public double getSe() {
		return se;
	}
	public void setSe(double se) {
		this.se = se;
	}
	public String getNsrid() {
		return nsrid;
	}
	public void setNsrid(String nsrid) {
		this.nsrid = nsrid;
	}
	public String getFcxxId() {
		return fcxxId;
	}
	public void setFcxxId(String fcxxId) {
		this.fcxxId = fcxxId;
	}
	public float getJyfe() {
		return jyfe;
	}
	public void setJyfe(float jyfe) {
		this.jyfe = jyfe;
	}
	public String getSzZsxmDm() {
		return szZsxmDm;
	}
	public void setSzZsxmDm(String szZsxmDm) {
		this.szZsxmDm = szZsxmDm;
	}
	
	 	 
	 
     
   
}