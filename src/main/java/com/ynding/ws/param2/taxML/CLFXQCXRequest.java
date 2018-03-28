package com.ynding.ws.param2.taxML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.ynding.ws.param2.TaxDoc;


/**
 * 存量房信息查询请求报文
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
@XmlType(name = "CLFXQCXRequest", propOrder = {
	    "fwuuid",
	    "htbh"
	})
  public class CLFXQCXRequest extends TaxDoc{
	   protected String fwuuid;//房屋uuid
	   protected String htbh;//合同编号
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
	
	  
}
