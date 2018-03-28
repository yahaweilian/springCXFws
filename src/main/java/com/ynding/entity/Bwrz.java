package com.ynding.entity;

import java.sql.Date;

/*******
 * 报文日志实体
 * tianrui0518
 * 2017-1-1
 * 
 * *******/
public class Bwrz {
 private String transeq;
 private String transid;
 private String channelid;
 private String trandate;
 private String xml;
public String getTranseq() {
	return transeq;
}
public void setTranseq(String transeq) {
	this.transeq = transeq;
}
public String getTransid() {
	return transid;
}
public void setTransid(String transid) {
	this.transid = transid;
}
public String getChannelid() {
	return channelid;
}
public void setChannelid(String channelid) {
	this.channelid = channelid;
}
public String getTrandate() {
	return trandate;
}
public void setTrandate(String trandate) {
	this.trandate = trandate;
}
public String getXml() {
	return xml;
}
public void setXml(String xml) {
	this.xml = xml;
}
 
 
 
 
}
