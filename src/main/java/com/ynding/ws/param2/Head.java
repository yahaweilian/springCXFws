package com.ynding.ws.param2;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
/**
 * 
 * @author zzy
 * 2016.06.21
 * @since 1.8
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="head",propOrder = {
	    "tran_id",
	    "channel_id",
	    "tran_seq",
	    "tran_date",
	    "rtn_code",
	    "rtn_msg"
	})
public class Head implements Serializable {
	
	protected static final long serialVersionUID = 1588492536480696614L;
	/**
	 * 交易ID（或服务ID,参见报文说明）
	 */
	protected String tran_id;
	/**
	 * 渠道ID(省局分配值,从配置文件中读取)
	 */
	protected String channel_id;
	/**
	 * 全局交易流水号(Uuid)
	 */
	protected String tran_seq;
	/**
	 * 交易日期(格式:20160511)
	 */
	protected String tran_date;
	
	/**
	 * 返回代码
	 */
	protected String rtn_code;
	/**
	 * 返回信息
	 */
	protected String rtn_msg;
	
	
	public Head(){
		this.channel_id = "ahds";
//		this.expand = new ArrayList<Expand>();
//		this.expand.add(new Expand(PackageConfig.IDENTITYTYPE,"AHDS.NFWB.HFWTDZ"));
//		this.expand.add(new Expand(PackageConfig.SJJG,PackageConfig.getSjjg()));
//		this.expand.add(new Expand(PackageConfig.SJRY,PackageConfig.getSjry()));
//				new Expand[] {
//				new Expand(PackageConfig.IDENTITYTYPE,PackageConfig.getIdentityType()),
//				new Expand(PackageConfig.SJJG,PackageConfig.getSjjg()),
//				new Expand(PackageConfig.SJRY,PackageConfig.getSjry())
//		};
		this.tran_seq = java.util.UUID.randomUUID().toString().replace("-", "");
		Date now = new Date();
		
//		this.tran_date = new SimpleDateFormat("yyyyMMdd").format(now);
//		this.tran_time = String.valueOf(now.getTime());
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateStr = sf.format(new Date());
		this.tran_date = dateStr.substring(0, 8);
	}
	
	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tranId) {
		tran_id = tranId;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channelId) {
		channel_id = channelId;
	}

	public String getTran_seq() {
		return tran_seq;
	}

	public void setTran_seq(String tranSeq) {
		tran_seq = tranSeq;
	}

	public String getTran_date() {
		return tran_date;
	}

	public void setTran_date(String tranDate) {
		tran_date = tranDate;
	}

	public String getRtn_code() {
		return rtn_code;
	}

	public void setRtn_code(String rtnCode) {
		rtn_code = rtnCode;
	}

	public String getRtn_msg() {
		return rtn_msg;
	}

	public void setRtn_msg(String rtnMsg) {
		rtn_msg = rtnMsg;
	}

	public Head setSuccess(){
		rtn_code = "0";
		rtn_msg = "成功";
		return this;
	}
	public Head setReturn(String code ,String msg){
		rtn_code = code;
		rtn_msg = msg;
		return this;
	}

	@Override
	public String toString() {
		return "Head [tran_id=" + tran_id + ", channel_id=" + channel_id
				+ ", tran_seq=" + tran_seq + ", tran_date=" + tran_date
				+ ", rtn_code=" + rtn_code + ", rtn_msg=" + rtn_msg
				+ ", getTran_id()=" + getTran_id() + ", getChannel_id()="
				+ getChannel_id() + ", getTran_seq()=" + getTran_seq()
				+ ", getTran_date()=" + getTran_date() + ", getRtn_code()="
				+ getRtn_code() + ", getRtn_msg()=" + getRtn_msg() + "]";
	}

}
