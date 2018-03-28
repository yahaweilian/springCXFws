package com.ynding.ws.param2.taxML;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ynding.ws.param2.TaxDoc;


/**
 * 房屋信息查询列表的返回报文
 * 
 * @date 2017-7-20
 * 
 * @author tianrui0518
 * 
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FWXXCXLBResponse", propOrder = {
		"zys","dqy","mysl","Fwxxlb"
})
//@XmlRootElement(name="taxML")
public class FWXXCXLBResponse
    extends TaxDoc
{
	
	protected int zys;//总页数
	protected int dqy;//当前页
	protected int mysl;//每页数量
	 @XmlElementWrapper
 	 @XmlElements( value = { @XmlElement(name = "fwxx", type = Fwxx.class) })
    protected List<Fwxx> Fwxxlb;//房屋信息查询时的纳税人列表

	public List<Fwxx> getFwxxlb() {
		return Fwxxlb;
	}

	public void setFwxxlb(List<Fwxx> fwxxlb) {
		Fwxxlb = fwxxlb;
	}

	public int getZys() {
		return zys;
	}

	public void setZys(int zys) {
		this.zys = zys;
	}

	public int getDqy() {
		return dqy;
	}

	public void setDqy(int dqy) {
		this.dqy = dqy;
	}

	public int getMysl() {
		return mysl;
	}

	public void setMysl(int mysl) {
		this.mysl = mysl;
	}
	
}
