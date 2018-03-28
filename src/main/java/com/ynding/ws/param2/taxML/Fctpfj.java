package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 房产附件图片
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
@XmlType(name = "Fctpfj", propOrder = {
    "fcxxid",
    "fctpid",
    "fctplx",
    "fctp"
})
public class Fctpfj {
	@XmlElement(required = true)
    protected String fcxxid;//房产信息id
	@XmlElement(required = true)
    protected String fctpid;//房产图片id
	@XmlElement(required = true)
    protected String fctplx;//房产图片类型CQZ房屋产权证 CRFSFZJ 出让方身份证件  SRFSFZJ 受让方身份证件 CRFJHZ 出让方结婚证  SRFJHZ 受让方结婚证 FCJGB房查结果表 GFQEFP购房全额发票 CRFHKB 受让方户口本 CRFHKB 出让方户口本
	//@XmlElement(required = true)
    protected String fctp;//房产图片  base64位编码传送
	public String getFcxxid() {
		return fcxxid;
	}
	public void setFcxxid(String fcxxid) {
		this.fcxxid = fcxxid;
	}
	public String getFctpid() {
		return fctpid;
	}
	public void setFctpid(String fctpid) {
		this.fctpid = fctpid;
	}
	public String getFctplx() {
		return fctplx;
	}
	public void setFctplx(String fctplx) {
		this.fctplx = fctplx;
	}
	public String getFctp() {
		return fctp;
	}
	public void setFctp(String fctp) {
		this.fctp = fctp;
	}
	
}
