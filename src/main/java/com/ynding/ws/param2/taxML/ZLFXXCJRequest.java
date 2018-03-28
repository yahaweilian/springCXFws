//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.10.26 ʱ�� 03:40:08 PM CST 
//

package com.ynding.ws.param2.taxML;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.*;

import com.ynding.ws.param2.TaxDoc;


/**
 * 增量房信息采集请求报文
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
@XmlType(name = "ZLFXXCJRequest", propOrder = { "fwuuid", "fcbm", "cshdjzh", "htbh","ssd","fwyt","barq", "xzqhDm", "swjgbm", "xqmc",
		"fwwzdz", "zlc", "szlc", "jzmj", "tnmj", "jzjg", "jzjgmc", "jcnd", "qszydx", "qszyyt", "qszyfs", "htqdrq",
		"htje", "fwdh", "dy", "fanghao","jdxz","acceptcode", "srfyjxx","kfsxxlb", "srfxxlb", "srfjtcylb", "srfyhlb", "fctpfjsy","zzsse","bhzzsje","dbgsnsrsbh","kfsnsrsbh","dbgsmc"})
// @XmlRootElement(name="taxML")
public class ZLFXXCJRequest extends TaxDoc implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(required = true)
	protected String fwuuid;// 房屋uuid
	@XmlElement(required = true)
	protected String fcbm;// 房产编码
	@XmlElement(required = true)
	protected String cshdjzh;// 初始化登记证号(合同编号)
	@XmlElement(required = true)
	protected String htbh;// 合同编号
	@XmlElement(required = true)
	protected String barq;// 备案日期
	protected String xzqhDm;// 行政区划代码
	protected String swjgbm;// 税务机构编码
	protected String xqmc;// 小区名称
	@XmlElement(required = true)
	protected String fwwzdz;// 房屋完整地址
	protected int zlc;// 总楼层
	protected int szlc;// 所在楼层
	@XmlElement(required = true)
	protected double jzmj;// 建筑面积
	@XmlElement(required = true)
	protected double tnmj;// 套内面积
	@XmlElement(required = true)
	protected String jzjg;// 建筑结构
	protected String jzjgmc;// 建筑结构名称
	protected String jcnd;// 建成年代
	@XmlElement(required = true)
	protected String qszydx;// 权属转移对象
	@XmlElement(required = true)
	protected String qszyyt;// 权属转移用途
	protected String qszyfs;// 权属转移类别
	@XmlElement(required = true)
	protected String htqdrq;// 合同签订日期
	@XmlElement(required = true)
	protected BigDecimal htje;// 合同金额
	@XmlElement(required = true)
	protected String fwdh;// 房屋栋号
	@XmlElement(required = true)
	protected String dy;// 单元
	@XmlElement(required = true)
	protected String fanghao;// 房号
	@XmlElement(required = true)
	protected String jdxz;// j街道乡镇
	@XmlElement(required = true)
	protected String acceptcode;//房管图片code
	

	protected String dbgsmc;//代办公司名称

	protected String dbgsnsrsbh;//代办公司纳税人识别号

	protected String kfsnsrsbh;//开发商纳税人识别号
	
	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "yjxx", type = Yjxx.class) })
	protected List<Yjxx> srfyjxx;// 受让方邮寄信息
	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "kfsxx", type = Kfsxx.class) })
	protected List<Kfsxx> kfsxxlb;// 开发商信息
	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "srfxx", type = Srfxx.class) })
	protected List<Srfxx> srfxxlb;// 购房人信息
	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "nsrjtcy", type = NsrJtcy.class) })
	protected List<NsrJtcy> srfjtcylb;// 纳税人家庭成员信息
	@XmlElementWrapper
	@XmlElements(value = { @XmlElement(name = "srfyh", type = Srfyh.class) })
	protected List<Srfyh> srfyhlb;// 购买方优惠
	@XmlElement(required = true)
	protected Fctpfjsy fctpfjsy;// 图片索引
	private String zzsse;
	private String bhzzsje;
	private String ssd;
	private String fwyt;
	

	public String getFwyt() {
		return fwyt;
	}

	public void setFwyt(String fwyt) {
		this.fwyt = fwyt;
	}

	public String getZzsse() {
		return zzsse;
	}

	public void setZzsse(String zzsse) {
		this.zzsse = zzsse;
	}

	public String getBhzzsje() {
		return bhzzsje;
	}

	public void setBhzzsje(String bhzzsje) {
		this.bhzzsje = bhzzsje;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}

	public String getFwuuid() {
		return fwuuid;
	}

	public void setFwuuid(String fwuuid) {
		this.fwuuid = fwuuid;
	}

	public String getFcbm() {
		return fcbm;
	}

	public void setFcbm(String fcbm) {
		this.fcbm = fcbm;
	}

	public String getCshdjzh() {
		return cshdjzh;
	}

	public void setCshdjzh(String cshdjzh) {
		this.cshdjzh = cshdjzh;
	}

	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}

	public String getBarq() {
		return barq;
	}

	public void setBarq(String barq) {
		this.barq = barq;
	}

	public String getXzqhDm() {
		return xzqhDm;
	}

	public void setXzqhDm(String xzqhDm) {
		this.xzqhDm = xzqhDm;
	}

	public String getSwjgbm() {
		return swjgbm;
	}

	public void setSwjgbm(String swjgbm) {
		this.swjgbm = swjgbm;
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

	public double getJzmj() {
		return jzmj;
	}

	public void setJzmj(double jzmj) {
		this.jzmj = jzmj;
	}

	public double getTnmj() {
		return tnmj;
	}

	public void setTnmj(double tnmj) {
		this.tnmj = tnmj;
	}

	public String getJzjg() {
		return jzjg;
	}

	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}

	public String getJzjgmc() {
		return jzjgmc;
	}

	public void setJzjgmc(String jzjgmc) {
		this.jzjgmc = jzjgmc;
	}

	public String getJcnd() {
		return jcnd;
	}

	public void setJcnd(String jcnd) {
		this.jcnd = jcnd;
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

	public String getHtqdrq() {
		return htqdrq;
	}

	public void setHtqdrq(String htqdrq) {
		this.htqdrq = htqdrq;
	}

	public BigDecimal getHtje() {
		return htje;
	}

	public void setHtje(BigDecimal htje) {
		this.htje = htje;
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

	public String getFanghao() {
		return fanghao;
	}

	public void setFanghao(String fanghao) {
		this.fanghao = fanghao;
	}

	public List<Kfsxx> getKfsxxlb() {
		return kfsxxlb;
	}

	public void setKfsxxlb(List<Kfsxx> kfsxxlb) {
		this.kfsxxlb = kfsxxlb;
	}

	public List<Srfxx> getSrfxxlb() {
		return srfxxlb;
	}

	public void setSrfxxlb(List<Srfxx> srfxxlb) {
		this.srfxxlb = srfxxlb;
	}

	public List<NsrJtcy> getSrfjtcylb() {
		return srfjtcylb;
	}

	public void setSrfjtcylb(List<NsrJtcy> srfjtcylb) {
		this.srfjtcylb = srfjtcylb;
	}

	public List<Srfyh> getSrfyhlb() {
		return srfyhlb;
	}

	public void setSrfyhlb(List<Srfyh> srfyhlb) {
		this.srfyhlb = srfyhlb;
	}

	public Fctpfjsy getFctpfjsy() {
		return fctpfjsy;
	}

	public void setFctpfjsy(Fctpfjsy fctpfjsy) {
		this.fctpfjsy = fctpfjsy;
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

	public String getDbgsmc() {
		return dbgsmc;
	}

	public void setDbgsmc(String dbgsmc) {
		this.dbgsmc = dbgsmc;
	}

	public String getDbgsnsrsbh() {
		return dbgsnsrsbh;
	}

	public void setDbgsnsrsbh(String dbgsnsrsbh) {
		this.dbgsnsrsbh = dbgsnsrsbh;
	}

	public String getKfsnsrsbh() {
		return kfsnsrsbh;
	}

	public void setKfsnsrsbh(String kfsnsrsbh) {
		this.kfsnsrsbh = kfsnsrsbh;
	}
	
   
}
