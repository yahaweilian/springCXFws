package com.ynding.entity;
/*
 * 中介实体
 */
@SuppressWarnings("all")
public class Zjxx {
	private String zjId;//中介ID ZJ_ID
	private String nsrsbh;//纳税人识别号（税务部门中介id） NSRSBH
	private String zjmc;//中介名称 ZJMC
	private String sfqy;//是否启用（0为启用 1为不启用） SFQY
	public String getZjId() {
		return zjId;
	}
	public void setZjId(String zjId) {
		this.zjId = zjId;
	}
	public String getNsrsbh() {
		return nsrsbh;
	}
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
	public String getZjmc() {
		return zjmc;
	}
	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}
	public String getSfqy() {
		return sfqy;
	}
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}
	
	
	

}
