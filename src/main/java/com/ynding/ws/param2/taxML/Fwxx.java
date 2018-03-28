package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 房屋信息实体
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
@XmlType(name = "Fwxx", propOrder = {
		    "fwuuid",
			"htbh",
			"fwwzdz",
			"crfxm",
			"crfzjhm",
			"srfxm",
			"srfzjhm",
			"zt",
			"ztmc",
			"shyj",
			"clfzlfbz",
			"clrzjhm",
			"crfpzxh",
			"srfpzxh",
			"fybm",
			"xzqh",
			"fpkpbj",
			"spkpbj",
			"crfdjxh",
			"srfdjxh",
			"sl",
			"se",
			"htjg",
			"pgjg",
			"mj",
			"dj",
			"cqzh",
			"fczh",
			"Crfdh",
			"Srfdh"
})
public class Fwxx {
	 protected String fwuuid;//房屋uuid
	    protected String htbh;//合同编号
	    protected String fwwzdz;//房屋完整地址
	    protected String crfxm;//出让方姓名
	    protected String crfzjhm;//出让方证件号码
	    protected String srfxm;//受让方姓名
	    protected String srfzjhm;//受让方证件号码
	    protected String zt;//状态
	    protected String ztmc;//状态名称
	    protected String shyj;//审核意见
	    protected String clfzlfbz;//增量房存量房标志
	    protected String clrzjhm;//处理人证件号码
	    protected String crfpzxh;//出让方凭证序号
	    protected String srfpzxh;//受让发凭证序号
	    protected String fybm;//房源编码
	    protected String xzqh;//行政区划
	    protected String fpkpbj;//发票开票标记
	    protected String spkpbj;//税票开票标记
	    protected String crfdjxh;//出让方登记序号
	    protected String srfdjxh;//受让方登记序号
	    
	    protected String sl;//增值税税率
	    protected String se;//增值税税额
		private double htjg;//合同价格
		private double pgjg;//评估价格
		private double mj;//面积
		private double dj;//单价
		
		private String cqzh;//产权证号
		private String fczh;//房产正号
		private String Crfdh;//电话
		private String Srfdh;//电话
		
		public String getClrzjhm() {
			return clrzjhm;
		}
		public void setClrzjhm(String clrzjhm) {
			this.clrzjhm = clrzjhm;
		}
		public String getFwuuid() {
			return fwuuid;
		}
		public void setFwuuid(String fwuuid) {
			this.fwuuid = fwuuid;
		}
		public String getHtbh() {
			return htbh;
		}
		public void setHtbh(String htbh) {
			this.htbh = htbh;
		}
		public String getFwwzdz() {
			return fwwzdz;
		}
		public void setFwwzdz(String fwwzdz) {
			this.fwwzdz = fwwzdz;
		}
		public String getCrfxm() {
			return crfxm;
		}
		public void setCrfxm(String crfxm) {
			this.crfxm = crfxm;
		}
		public String getCrfzjhm() {
			return crfzjhm;
		}
		public void setCrfzjhm(String crfzjhm) {
			this.crfzjhm = crfzjhm;
		}
		public String getSrfxm() {
			return srfxm;
		}
		public void setSrfxm(String srfxm) {
			this.srfxm = srfxm;
		}
		public String getSrfzjhm() {
			return srfzjhm;
		}
		public void setSrfzjhm(String srfzjhm) {
			this.srfzjhm = srfzjhm;
		}
		public String getZt() {
			return zt;
		}
		public void setZt(String zt) {
			this.zt = zt;
		}
		public String getZtmc() {
			return ztmc;
		}
		public void setZtmc(String ztmc) {
			this.ztmc = ztmc;
		}
		public String getShyj() {
			return shyj;
		}
		public void setShyj(String shyj) {
			this.shyj = shyj;
		}
		public String getClfzlfbz() {
			return clfzlfbz;
		}
		public void setClfzlfbz(String clfzlfbz) {
			this.clfzlfbz = clfzlfbz;
		}
		public String getCrfpzxh() {
			return crfpzxh;
		}
		public void setCrfpzxh(String crfpzxh) {
			this.crfpzxh = crfpzxh;
		}
		public String getSrfpzxh() {
			return srfpzxh;
		}
		public void setSrfpzxh(String srfpzxh) {
			this.srfpzxh = srfpzxh;
		}
		public String getFpkpbj() {
			return fpkpbj;
		}
		public void setFpkpbj(String fpkpbj) {
			this.fpkpbj = fpkpbj;
		}
		public String getSpkpbj() {
			return spkpbj;
		}
		public void setSpkpbj(String spkpbj) {
			this.spkpbj = spkpbj;
		}
		public String getCrfdjxh() {
			return crfdjxh;
		}
		public void setCrfdjxh(String crfdjxh) {
			this.crfdjxh = crfdjxh;
		}
		public String getSrfdjxh() {
			return srfdjxh;
		}
		public void setSrfdjxh(String srfdjxh) {
			this.srfdjxh = srfdjxh;
		}
		public String getSl() {
			return sl;
		}
		public void setSl(String sl) {
			this.sl = sl;
		}
		public String getSe() {
			return se;
		}
		public void setSe(String se) {
			this.se = se;
		}
		public String getFybm() {
			return fybm;
		}
		public void setFybm(String fybm) {
			this.fybm = fybm;
		}
		public String getXzqh() {
			return xzqh;
		}
		public void setXzqh(String xzqh) {
			this.xzqh = xzqh;
		}
		public double getHtjg() {
			return htjg;
		}
		public void setHtjg(double htjg) {
			this.htjg = htjg;
		}
		public double getPgjg() {
			return pgjg;
		}
		public void setPgjg(double pgjg) {
			this.pgjg = pgjg;
		}
		public double getMj() {
			return mj;
		}
		public void setMj(double mj) {
			this.mj = mj;
		}
		public double getDj() {
			return dj;
		}
		public void setDj(double dj) {
			this.dj = dj;
		}
		public String getCqzh() {
			return cqzh;
		}
		public void setCqzh(String cqzh) {
			this.cqzh = cqzh;
		}
		public String getFczh() {
			return fczh;
		}
		public void setFczh(String fczh) {
			this.fczh = fczh;
		}
		public String getCrfdh() {
			return Crfdh;
		}
		public void setCrfdh(String crfdh) {
			Crfdh = crfdh;
		}
		public String getSrfdh() {
			return Srfdh;
		}
		public void setSrfdh(String srfdh) {
			Srfdh = srfdh;
		}

		
}
