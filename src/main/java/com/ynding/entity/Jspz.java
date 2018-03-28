package com.ynding.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import java.io.Serializable;

/**
 * 计税配置
 * 
 * @author zzy
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Jspz", propOrder = { "uuid", "zsxmDm", "zspmDm", "sycs",
		"sfsz", "sfszzsz", "szZsxmDm", "szZspmDm", "mmfbz", "sfqy", "plsx",
		"sl", "zszmDm", "sfzrr", "sfzz", "fwmj", "jynx", "jtzfts", "sfhtjejz",
		"sxxzbj", "jmxzDm", "clfzlfbz", "syfw" })
public class Jspz {

	@XmlElement(required = true)
	protected String uuid; // 配置编码
	protected String zsxmDm; // 税种
	protected String zspmDm; // 科目
	protected String sycs; // 使用城市
	protected String sfsz; // 是否随征
	protected String sfszzsz; // 是否是随征主税种
	protected String szZsxmDm; // 随征税种
	protected String szZspmDm; // 随征税目
	@XmlElement(required = true)
	protected String mmfbz; // 买卖方标记 1买方0卖方
	@XmlElement(required = true)
	protected String sfqy; // 启用标记
	protected Integer plsx; // 排列顺序
	@XmlElement(required = true)
	protected Double sl; // 税率
	protected String zszmDm; // 征收子目
	protected String sfzrr; // 是否自然人
	protected String sfzz; // 是否住宅
	@XmlElement(required = true)
	protected String fwmj; // 房屋面积
	@XmlElement(required = true)
	protected String jynx; // 交易年限
	@XmlElement(required = true)
	protected String jtzfts; // 家庭住房套数
	protected String sfhtjejz; // 是否合同金额计征
	protected String sxxzbj; // 市县乡镇标记(0市1县乡镇2非市县乡镇)
	protected String jmxzDm; // 减免性质代码
	@XmlElement(required = true)
	protected String clfzlfbz; // 存量房增量房标志（0增量房1存量房）
	@XmlElement(required = true)
	public String syfw; // 适用范围

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getZsxmDm() {
		return zsxmDm;
	}

	public void setZsxmDm(String zsxmDm) {
		this.zsxmDm = zsxmDm;
	}

	public String getZspmDm() {
		return zspmDm;
	}

	public void setZspmDm(String zspmDm) {
		this.zspmDm = zspmDm;
	}

	public String getSycs() {
		return sycs;
	}

	public void setSycs(String sycs) {
		this.sycs = sycs;
	}

	public String getSfsz() {
		return sfsz;
	}

	public void setSfsz(String sfsz) {
		this.sfsz = sfsz;
	}

	public String getSfszzsz() {
		return sfszzsz;
	}

	public void setSfszzsz(String sfszzsz) {
		this.sfszzsz = sfszzsz;
	}

	public String getSzZsxmDm() {
		return szZsxmDm;
	}

	public void setSzZsxmDm(String szZsxmDm) {
		this.szZsxmDm = szZsxmDm;
	}

	public String getSzZspmDm() {
		return szZspmDm;
	}

	public void setSzZspmDm(String szZspmDm) {
		this.szZspmDm = szZspmDm;
	}

	public String getMmfbz() {
		return mmfbz;
	}

	public void setMmfbz(String mmfbz) {
		this.mmfbz = mmfbz;
	}

	public String getSfqy() {
		return sfqy;
	}

	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}

	public Integer getPlsx() {
		return plsx;
	}

	public void setPlsx(Integer plsx) {
		this.plsx = plsx;
	}

	public Double getSl() {
		return sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public String getZszmDm() {
		return zszmDm;
	}

	public void setZszmDm(String zszmDm) {
		this.zszmDm = zszmDm;
	}

	public String getSfzrr() {
		return sfzrr;
	}

	public void setSfzrr(String sfzrr) {
		this.sfzrr = sfzrr;
	}

	public String getSfzz() {
		return sfzz;
	}

	public void setSfzz(String sfzz) {
		this.sfzz = sfzz;
	}

	public String getFwmj() {
		return fwmj;
	}

	public void setFwmj(String fwmj) {
		this.fwmj = fwmj;
	}

	public String getJynx() {
		return jynx;
	}

	public void setJynx(String jynx) {
		this.jynx = jynx;
	}

	public String getJtzfts() {
		return jtzfts;
	}

	public void setJtzfts(String jtzfts) {
		this.jtzfts = jtzfts;
	}

	public String getSfhtjejz() {
		return sfhtjejz;
	}

	public void setSfhtjejz(String sfhtjejz) {
		this.sfhtjejz = sfhtjejz;
	}

	public String getSxxzbj() {
		return sxxzbj;
	}

	public void setSxxzbj(String sxxzbj) {
		this.sxxzbj = sxxzbj;
	}

	public String getJmxzDm() {
		return jmxzDm;
	}

	public void setJmxzDm(String jmxzDm) {
		this.jmxzDm = jmxzDm;
	}

	public String getClfzlfbz() {
		return clfzlfbz;
	}

	public void setClfzlfbz(String clfzlfbz) {
		this.clfzlfbz = clfzlfbz;
	}

	public String getSyfw() {
		return syfw;
	}

	public void setSyfw(String syfw) {
		if (syfw == null) {
			this.syfw = "";
		} else {
			this.syfw = syfw;
		}
	}

}
