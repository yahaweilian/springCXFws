
package com.ynding.ws.param2.taxML;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import com.ynding.ws.param2.TaxDoc;



/**
 * 
 * 
 * @date 2017-6-27
 * 
 * @author tianrui0518
 * 
 * 
 * 返回的信息包含提交的信息 还要包含状态、装修情况、房屋类型等情况
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZLFXXQKCXResponse", propOrder = {
	    "fwuuid",
	    "fcbm",
	    "cshdjzh",
	    "barq",
	    "xzqhDm",
	    "xzqhmc",
	    "jdxzDm",
	    "jdxzmc",
	    "xqmc",
	    "fwwzdz",
	    "zlc",
	    "szlc",
	    "jzmj",
	    "jzjg",
	    "jzcxDm",
	    "jzcxmc",
	    "jcnd",
	    "fwyt",
	    "sbjg",
	    "qszydx",
	    "htqdrq",
	    "htje",
	    "zt",
	    "srfxxlb",
	    "kfsxx",
	    "htbh",
	    "swjgbm",
	    "tnmj",
	    "dj",
	    "jzjgmc",
	    "qszydxmc",
	    "qszyyt",
	    "qszyytmc",
	    "qszyfsmc",
	    "fwdh",
	    "dy",
	    "fjh",
	    "qszyfs"
	})
public class ZLFXXQKCXResponse
    extends TaxDoc
{
	 @XmlElement(required = true)
	    protected String fwuuid;//房屋uuid
	    @XmlElement(required = true)
	    protected String fcbm;//房产编码
	    @XmlElement(required = true)
	    protected String cshdjzh;//初始化登记证号
	    @XmlElement(required = true)
	    protected String barq;//备案日期
	   
	    protected String xzqhDm;//行政区划代码
	   
	    protected String xzqhmc;//行政区划名称
	   
	    protected String jdxzDm;//街道乡镇代码
	  
	    protected String jdxzmc;//街道乡镇名称
	   
	    protected String xqmc;//小区名称
	    @XmlElement(required = true)
	    protected String fwwzdz;//房屋完整地址
	    @XmlElement(required = true)
	    protected int zlc;//总楼层
	    @XmlElement(required = true)
	    protected int szlc;//所在楼层
	    @XmlElement(required = true)
	    protected double jzmj;//建筑面积
	    @XmlElement(required = true)
	    protected String jzjg;//建筑结构
	   
	    protected String jzcxDm;//建筑朝向代码
	    
	    protected String jzcxmc;//建筑朝向名称
	   
	    protected String jcnd;//建成年代
	    @XmlElement(required = true)
	    protected String fwyt;//房屋用途             1111
	    @XmlElement(required = true)
	    protected double sbjg;//申报价格
//	    @XmlElement(required = true)
//	    protected double jydj;//交易单价          2222
	    @XmlElement(required = true)
	    protected String qszydx;//权属转移对象     333
	    @XmlElement(required = true)
	    protected String htqdrq;//合同签订日期
	 
//	    protected String ysxkid;//预售许可id
	    @XmlElement(required = true)
	    protected double htje;//合同金额
	    @XmlElement(required = true)
	    protected String zt;//该笔交易的当前状态
	    
	     @XmlElementWrapper
	     @XmlElements( value = { @XmlElement(name = "srfxx", type = Srfxx.class) })
	     protected List<Srfxx> srfxxlb;//购买方信息
	    @XmlElement(required = true)
	    protected List<Kfsxx> kfsxx;//开发商信息
	//==========================================================================    
	    protected String htbh;
	    protected String swjgbm;
	   
	  
	    protected float tnmj;

	    protected BigDecimal dj;
	    protected String jzjgmc;
	    protected String qszydxmc;
	    protected String qszyyt;
	    protected String qszyytmc;
	    protected String qszyfsmc;
	    protected String fwdh;
	    protected String dy;
	    protected String fjh;
	    protected String qszyfs;
	    
	    
        public String getQszyfs() {
			return qszyfs;
		}
		public void setQszyfs(String qszyfs) {
			this.qszyfs = qszyfs;
		}
		public String getHtbh() {
			return htbh;
		}
		public void setHtbh(String htbh) {
			this.htbh = htbh;
		}
		public String getSwjgbm() {
			return swjgbm;
		}
		public void setSwjgbm(String swjgbm) {
			this.swjgbm = swjgbm;
		}
		public float getTnmj() {
			return tnmj;
		}
		public void setTnmj(float tnmj) {
			this.tnmj = tnmj;
		}
		
		public BigDecimal getDj() {
			return dj;
		}
		public void setDj(BigDecimal dj) {
			this.dj = dj;
		}
		public String getJzjgmc() {
			return jzjgmc;
		}
		public void setJzjgmc(String jzjgmc) {
			this.jzjgmc = jzjgmc;
		}
		public String getQszydxmc() {
			return qszydxmc;
		}
		public void setQszydxmc(String qszydxmc) {
			this.qszydxmc = qszydxmc;
		}
		public String getQszyyt() {
			return qszyyt;
		}
		public void setQszyyt(String qszyyt) {
			this.qszyyt = qszyyt;
		}
		public String getQszyytmc() {
			return qszyytmc;
		}
		public void setQszyytmc(String qszyytmc) {
			this.qszyytmc = qszyytmc;
		}
		public String getQszyfsmc() {
			return qszyfsmc;
		}
		public void setQszyfsmc(String qszyfsmc) {
			this.qszyfsmc = qszyfsmc;
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
        public String getXzqhmc() {
            return xzqhmc;
        }
        public void setXzqhmc(String xzqhmc) {
            this.xzqhmc = xzqhmc;
        }
        public String getJdxzDm() {
            return jdxzDm;
        }
        public void setJdxzDm(String jdxzDm) {
            this.jdxzDm = jdxzDm;
        }
        public String getJdxzmc() {
            return jdxzmc;
        }
        public void setJdxzmc(String jdxzmc) {
            this.jdxzmc = jdxzmc;
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
        public String getJzjg() {
            return jzjg;
        }
        public void setJzjg(String jzjg) {
            this.jzjg = jzjg;
        }
        public String getJzcxDm() {
            return jzcxDm;
        }
        public void setJzcxDm(String jzcxDm) {
            this.jzcxDm = jzcxDm;
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
        public double getSbjg() {
            return sbjg;
        }
        public void setSbjg(double sbjg) {
            this.sbjg = sbjg;
        }
        public String getQszydx() {
            return qszydx;
        }
        public void setQszydx(String qszydx) {
            this.qszydx = qszydx;
        }
        public String getHtqdrq() {
            return htqdrq;
        }
        public void setHtqdrq(String htqdrq) {
            this.htqdrq = htqdrq;
        }
        public double getHtje() {
            return htje;
        }
        public void setHtje(double htje) {
            this.htje = htje;
        }
        public String getZt() {
            return zt;
        }
        public void setZt(String zt) {
            this.zt = zt;
        }
        
        public List<Srfxx> getSrfxxlb() {
			return srfxxlb;
		}
		public void setSrfxxlb(List<Srfxx> srfxxlb) {
			this.srfxxlb = srfxxlb;
		}
		public List<Kfsxx> getKfsxx() {
            return kfsxx;
        }
        public void setKfsxx(List<Kfsxx> kfsxx) {
            this.kfsxx = kfsxx;
        }
	    
	    
    
}