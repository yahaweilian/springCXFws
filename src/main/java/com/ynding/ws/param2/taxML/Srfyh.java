package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.*;

/**
 * 购买方优惠
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
@XmlType(name="srfyh",propOrder = {"yhdm"})
public class Srfyh {
	@XmlElement(required = true)
    protected String yhdm;//优惠代码

	public String getYhdm() {
		return yhdm;
	}

	public void setYhdm(String yhdm) {
		this.yhdm = yhdm;
	}
	
	
}
