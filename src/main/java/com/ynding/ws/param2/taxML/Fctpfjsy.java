package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 房产附件图片索引
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
@XmlType(name = "fctpfjsy", propOrder = {
    "fctpzs",
    "fctpfjlb"
})
public class Fctpfjsy {
	@XmlElement(required = true)
    protected int fctpzs;//图片总数
	@XmlElement(required = true)
    protected Fctpfjlb fctpfjlb;//房产附件图片列表
	public int getFctpzs() {
		return fctpzs;
	}
	public void setFctpzs(int fctpzs) {
		this.fctpzs = fctpzs;
	}
	public Fctpfjlb getFctpfjlb() {
		return fctpfjlb;
	}
	public void setFctpfjlb(Fctpfjlb fctpfjlb) {
		this.fctpfjlb = fctpfjlb;
	}
    
	
    
}
