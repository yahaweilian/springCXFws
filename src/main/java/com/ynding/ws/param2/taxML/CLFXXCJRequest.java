
package com.ynding.ws.param2.taxML;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.*;

import org.springframework.ws.server.endpoint.annotation.Namespace;

import com.ynding.ws.param2.TaxDoc;

/**
 * 存量房信息采集请求报文
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
@XmlType(name = "CLFXXCJRequest", propOrder = { "fcbm", "htbh", "barq", "xzqh","acceptcode", "xqmc", "fwwzdz", "qztzrq", "zlc",
		"szlc", "jzmj", "jzjg", "jzcxmc", "jcnd", "fwyt", "sbjg", "qcjyjg", "qcjyrq", "htqdrq", "qszydx", "qszyyt",
		"qszyfs", "fwdh", "dy", "fjh", "tlmj", "qcjylx", "fssslx", "fswmj", "fsje", "dj", "zjmc", "zjId", "zxqk",
		"xqdm", "htje", "fwuuid", "cs", "zgjg", "fzf", "leixingfen", "swjgbm","srfyjxx","crfyjxx", "srfxxlb", "srfxxJtcylb", "crfxxlb",
		"crfxxJtcylb", "srfyhlb", "crfyhlb", "fctpfjsy","zjgsbm","zjysbh","jdxz"})

@SuppressWarnings("all")
public class CLFXXCJRequest extends TaxDoc {
	@XmlElement(required = true)
	protected String fcbm;// 房产证号 BIANMA
	@XmlElement(required = true)
	protected String htbh;// 合同编号 HTBH
	@XmlElement(required = true)
	protected Date barq;// 备案日期 BARQ
	protected String xzqh; // 行政区划 XZQHSZ_DM (状态表)
	protected String xqmc;// 小区名称 XQMC
	@XmlElement(required = true)
	protected String fwwzdz;// 地址 DIZHI
	@XmlElement(required = true)
	protected Date qztzrq;// 权证填制日期 QUANZHENG_TIME
	protected int zlc;// 总楼层 LOUCENG_ZONG
	protected int szlc;// 所在楼层 LOUCENG
	@XmlElement(required = true)
	protected BigDecimal jzmj;// 建筑面积 MIANJI
	@XmlElement(required = true)
	protected String jzjg;// 建筑结构 JIEGOU
	protected String jzcxmc;// 建筑朝向 CAOXIANG
	protected String jcnd;// 建成年代 NIANDAI
	@XmlElement(required = true)
	protected String fwyt;// 房屋用途 YONGTU
	@XmlElement(required = true)
	protected BigDecimal sbjg;// 申报价格(交易价格) SHENBAO
	@XmlElement(required = true)
	protected BigDecimal qcjyjg;// 前次交易价格 QIANCI
	@XmlElement(required = true)
	protected Date qcjyrq;// 前次交易日期 QIANCI_TIME
	@XmlElement(required = true)
	protected Date htqdrq;// 合同签订日期 HTQDRQ (状态表)
	@XmlElement(required = true)
	protected String qszydx; // 权属转移对象 QSZYDX (状态表)
	@XmlElement(required = true)
	protected String qszyyt; // 权属转移用途 QSZYYT (状态表)
	@XmlElement(required = true)
	protected String qszyfs; // 权属转移类别 QUANSHU
	@XmlElement(required = true)
	protected String fwdh;// 房屋栋号FWDH
	@XmlElement(required = true)
	protected String dy;// 单元DY
	@XmlElement(required = true)
	protected String fjh; // 房间号FANGHAO
	@XmlElement(required = true)
	protected String tlmj; // 套内面积 TNMJ （状态表）
	@XmlElement(required = true)
	protected String qcjylx; // 前次交易类型QCJYLX
	@XmlElement(required = true)
	protected String fssslx;// 附属设施类型 FSSSLX (状态表)
	protected float fswmj;// 附属物面积 FSMJ(状态表)
	protected BigDecimal fsje; // 附属金额FSJE
	@XmlElement(required = true)
	protected BigDecimal dj; // 单价DJ
	protected String zjmc;// 中介名称 ZJMC （中介表）
	protected String zjId;// 中介ID(纳税人识别号) ZJ_ID (状态表)|(中介表)
	// ====================添加============================================
	protected String zxqk; // 装修情况 ZHUANGXIU
	// protected String Fangwulx;//房屋类型
	protected String xqdm;// 分区
	// ===================================================================================
    protected String acceptcode;//房管图片code
	protected double htje;// 合同金额

	protected String fwuuid;// 房屋uuid

	protected String cs;// 城市

	protected String zgjg;// 主管机关

	protected String fzf;// 非住房

	private String leixingfen;// 房产细类

	private String swjgbm;// 税务机关代码

	private String zjgsbm; // 中介公司代码
	private String zjysbh; // 中介公司办理人识别号
	private String jdxz; // 
	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "yjxx", type = Yjxx.class) })
	protected List<Yjxx> srfyjxx;// 受让方邮寄信息
	
	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "yjxx", type = Yjxx.class) })
	protected List<Yjxx> crfyjxx;// 出让方邮寄信息
	
	
	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "srfxx", type = Srfxx.class) })
	protected List<Srfxx> srfxxlb;// 购买方信息

	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "srfxxJtcy", type = SrfxxJtcy.class) })
	protected List<SrfxxJtcy> srfxxJtcylb;// 购买方家庭成员

	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "crfxx", type = Crfxx.class) })
	protected List<Crfxx> crfxxlb;// 出让方信息

	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "crfxxJtcy", type = CrfxxJtcy.class) })
	protected List<CrfxxJtcy> crfxxJtcylb;// 出让方家庭成员

	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "srfyh", type = Srfyh.class) })
	protected List<Srfyh> srfyhlb;// 购买方优惠

	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "crfyh", type = Crfyh.class) })
	protected List<Crfyh> crfyhlb;// 出让方优惠
	protected Fctpfjsy fctpfjsy;// 图片索引

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

	public String getFcbm() {
		return fcbm;
	}

	public void setFcbm(String fcbm) {
		this.fcbm = fcbm;
	}

	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}

	public Date getBarq() {
		return barq;
	}

	public void setBarq(Date barq) {
		this.barq = barq;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getXqmc() {
		return xqmc;
	}

	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}

	public String getFwwzdz() {
		return fwwzdz;
	}

	public void setFwwzdz(String fwwzdz) {
		this.fwwzdz = fwwzdz;
	}

	public Date getQztzrq() {
		return qztzrq;
	}

	public void setQztzrq(Date qztzrq) {
		this.qztzrq = qztzrq;
	}

	public int getZlc() {
		return zlc;
	}

	public void setZlc(int zlc) {
		this.zlc = zlc;
	}

	public int getSzlc() {
		return szlc;
	}

	public void setSzlc(int szlc) {
		this.szlc = szlc;
	}

	public BigDecimal getJzmj() {
		return jzmj;
	}

	public void setJzmj(BigDecimal jzmj) {
		this.jzmj = jzmj;
	}

	public String getJzjg() {
		return jzjg;
	}

	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}

	public String getJzcxmc() {
		return jzcxmc;
	}

	public void setJzcxmc(String jzcxmc) {
		this.jzcxmc = jzcxmc;
	}

	public String getJcnd() {
		return jcnd;
	}

	public void setJcnd(String jcnd) {
		this.jcnd = jcnd;
	}

	public String getFwyt() {
		return fwyt;
	}

	public void setFwyt(String fwyt) {
		this.fwyt = fwyt;
	}

	public BigDecimal getSbjg() {
		return sbjg;
	}

	public void setSbjg(BigDecimal sbjg) {
		this.sbjg = sbjg;
	}

	public BigDecimal getQcjyjg() {
		return qcjyjg;
	}

	public void setQcjyjg(BigDecimal qcjyjg) {
		this.qcjyjg = qcjyjg;
	}

	public Date getQcjyrq() {
		return qcjyrq;
	}

	public void setQcjyrq(Date qcjyrq) {
		this.qcjyrq = qcjyrq;
	}

	public Date getHtqdrq() {
		return htqdrq;
	}

	public void setHtqdrq(Date htqdrq) {
		this.htqdrq = htqdrq;
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

	public String getQszyfs() {
		return qszyfs;
	}

	public void setQszyfs(String qszyfs) {
		this.qszyfs = qszyfs;
	}

	public String getFwdh() {
		return fwdh;
	}

	public void setFwdh(String fwdh) {
		this.fwdh = fwdh;
	}

	public String getDy() {
		return dy;
	}

	public void setDy(String dy) {
		this.dy = dy;
	}

	public String getFjh() {
		return fjh;
	}

	public void setFjh(String fjh) {
		this.fjh = fjh;
	}

	public String getTlmj() {
		return tlmj;
	}

	public void setTlmj(String tlmj) {
		this.tlmj = tlmj;
	}

	public String getQcjylx() {
		return qcjylx;
	}

	public void setQcjylx(String qcjylx) {
		this.qcjylx = qcjylx;
	}

	public String getFssslx() {
		return fssslx;
	}

	public void setFssslx(String fssslx) {
		this.fssslx = fssslx;
	}

	public float getFswmj() {
		return fswmj;
	}

	public void setFswmj(float fswmj) {
		this.fswmj = fswmj;
	}

	public BigDecimal getFsje() {
		return fsje;
	}

	public void setFsje(BigDecimal fsje) {
		this.fsje = fsje;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}

	public String getZjId() {
		return zjId;
	}

	public void setZjId(String zjId) {
		this.zjId = zjId;
	}

	public String getZxqk() {
		return zxqk;
	}

	public void setZxqk(String zxqk) {
		this.zxqk = zxqk;
	}

	public double getHtje() {
		return htje;
	}

	public void setHtje(double htje) {
		this.htje = htje;
	}

	public String getFwuuid() {
		return fwuuid;
	}

	public void setFwuuid(String fwuuid) {
		this.fwuuid = fwuuid;
	}

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public String getZgjg() {
		return zgjg;
	}

	public void setZgjg(String zgjg) {
		this.zgjg = zgjg;
	}

	public String getFzf() {
		return fzf;
	}

	public void setFzf(String fzf) {
		this.fzf = fzf;
	}

	public String getLeixingfen() {
		return leixingfen;
	}

	public void setLeixingfen(String leixingfen) {
		this.leixingfen = leixingfen;
	}

	public List<Srfxx> getSrfxxlb() {
		return srfxxlb;
	}

	public void setSrfxxlb(List<Srfxx> srfxxlb) {
		this.srfxxlb = srfxxlb;
	}

	public List<Crfxx> getCrfxxlb() {
		return crfxxlb;
	}

	public void setCrfxxlb(List<Crfxx> crfxxlb) {
		this.crfxxlb = crfxxlb;
	}

	public List<Srfyh> getSrfyhlb() {
		return srfyhlb;
	}

	public void setSrfyhlb(List<Srfyh> srfyhlb) {
		this.srfyhlb = srfyhlb;
	}

	public List<Crfyh> getCrfyhlb() {
		return crfyhlb;
	}

	public void setCrfyhlb(List<Crfyh> crfyhlb) {
		this.crfyhlb = crfyhlb;
	}

	public Fctpfjsy getFctpfjsy() {
		return fctpfjsy;
	}

	public void setFctpfjsy(Fctpfjsy fctpfjsy) {
		this.fctpfjsy = fctpfjsy;
	}

	public List<SrfxxJtcy> getSrfxxJtcylb() {
		return srfxxJtcylb;
	}

	public void setSrfxxJtcylb(List<SrfxxJtcy> srfxxJtcylb) {
		this.srfxxJtcylb = srfxxJtcylb;
	}

	public List<CrfxxJtcy> getCrfxxJtcylb() {
		return crfxxJtcylb;
	}

	public void setCrfxxJtcylb(List<CrfxxJtcy> crfxxJtcylb) {
		this.crfxxJtcylb = crfxxJtcylb;
	}

	public String getXqdm() {
		return xqdm;
	}

	public void setXqdm(String xqdm) {
		this.xqdm = xqdm;
	}

	public String getSwjgbm() {
		return swjgbm;
	}

	public void setSwjgbm(String swjgbm) {
		this.swjgbm = swjgbm;
	}

	public String getJdxz() {
		return jdxz;
	}

	public void setJdxz(String jdxz) {
		this.jdxz = jdxz;
	}

	public String getAcceptcode() {
		return acceptcode;
	}

	public void setAcceptcode(String acceptcode) {
		this.acceptcode = acceptcode;
	}

	public List<Yjxx> getSrfyjxx() {
		return srfyjxx;
	}

	public void setSrfyjxx(List<Yjxx> srfyjxx) {
		this.srfyjxx = srfyjxx;
	}

	public List<Yjxx> getCrfyjxx() {
		return crfyjxx;
	}

	public void setCrfyjxx(List<Yjxx> crfyjxx) {
		this.crfyjxx = crfyjxx;
	}

}
