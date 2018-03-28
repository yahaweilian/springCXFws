package com.ynding.ws.param2.taxML;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 房产附件图片列表
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
public class Fctpfjlb {
	//@XmlElement(required = true)
    protected List<Fctpfj> fctpfj;//房产附件图片列表

	public List<Fctpfj> getFctpfj() {
		return fctpfj;
	}

	public void setFctpfj(List<Fctpfj> fctpfj) {
		this.fctpfj = fctpfj;
	}
    
    
    
}
