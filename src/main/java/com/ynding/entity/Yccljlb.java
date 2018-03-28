package com.ynding.entity;

import java.io.Serializable;

public class Yccljlb implements Serializable {

	/**
	 * 异常处理
	 */
	private static final long serialVersionUID = 1L;
	
	private String fcxx_id;//交易id
	private String dqyczt;//当前异常状态（根据当前状态判断是继续自动审核还是自动核价计税）
	private String dqsj;//当前异常时间
	private String sdzt;//锁定状态（1为锁定状态，说明异常已经在处理，其他操作无法处理改交易）
	public String getFcxx_id() {
		return fcxx_id;
	}
	public void setFcxx_id(String fcxx_id) {
		this.fcxx_id = fcxx_id;
	}
	public String getDqyczt() {
		return dqyczt;
	}
	public void setDqyczt(String dqyczt) {
		this.dqyczt = dqyczt;
	}
	public String getDqsj() {
		return dqsj;
	}
	public void setDqsj(String dqsj) {
		this.dqsj = dqsj;
	}
	public String getSdzt() {
		return sdzt;
	}
	public void setSdzt(String sdzt) {
		this.sdzt = sdzt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
     
	

}
