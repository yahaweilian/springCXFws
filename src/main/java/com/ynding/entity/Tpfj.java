package com.ynding.entity;

import java.io.Serializable;
import java.util.Date;

public class Tpfj implements Serializable{

	/**
	 * 房产图片附件
	 */
	private static final long serialVersionUID = 1L;
	private   String  uuid; //
	private   String  fcxxId;  //房产ID 
	private   String  fctplx;  //图片类型 CQZ房屋产权证 CRFSFZJ 出让方身份证件  SRFSFZJ 受让方身份证件 CRFJHZ 出让方结婚证  SRFJHZ 
	                           //   受让方结婚证 FCJGB 房查结果表 GFQEFP购房全额发票 CRFHKB 受让方户口本 CRFHKB 出让方户口本   
	private   int     plsx;    //排序顺序 
	private   String  url;     //
	private   String  sfqy;    //是否启用 
	private   String  fctpId;  //图片id  
	private   String  nsrId;   //房产纳税人表id 
	private   String  fctpZt;  //图片状态    0图片通过(启用）     1图片不通过（不启用） 
	private   String  swryDm;  //税务人员账号id  
	private   Date    czsh;    //操作时间   
	private   String  fctpMc;  //图片名称(图片描述)
	private   String  fctpWjm;  //文件名  
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFcxxId() {
		return fcxxId;
	}
	public void setFcxxId(String fcxxId) {
		this.fcxxId = fcxxId;
	}
	public String getFctplx() {
		return fctplx;
	}
	public void setFctplx(String fctplx) {
		this.fctplx = fctplx;
	}
	public int getPlsx() {
		return plsx;
	}
	public void setPlsx(int plsx) {
		this.plsx = plsx;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSfqy() {
		return sfqy;
	}
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}
	public String getFctpId() {
		return fctpId;
	}
	public void setFctpId(String fctpId) {
		this.fctpId = fctpId;
	}
	public String getNsrId() {
		return nsrId;
	}
	public void setNsrId(String nsrId) {
		this.nsrId = nsrId;
	}
	public String getFctpZt() {
		return fctpZt;
	}
	public void setFctpZt(String fctpZt) {
		this.fctpZt = fctpZt;
	}
	public String getSwryDm() {
		return swryDm;
	}
	public void setSwryDm(String swryDm) {
		this.swryDm = swryDm;
	}
	public Date getCzsh() {
		return czsh;
	}
	public void setCzsh(Date czsh) {
		this.czsh = czsh;
	}		
	public String getFctpMc() {
		return fctpMc;
	}
	public void setFctpMc(String fctpMc) {
		this.fctpMc = fctpMc;
	}
	public String getFctpWjm() {
		return fctpWjm;
	}
	public void setFctpWjm(String fctpWjm) {
		this.fctpWjm = fctpWjm;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
