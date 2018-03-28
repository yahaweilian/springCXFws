package com.ynding.ws.param2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * service报文包类 报文根节点
 * 
 * @since 1.8
 * @author zzy 2017.06.27
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceXmlPackage", propOrder = { "head", "body" })
public class ServiceXmlPackage implements Serializable {

	private static final long serialVersionUID = -1894544123339348315L;

	private Head head;
	protected TaxDoc body;

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public TaxDoc getBody() {
		return body;
	}

	public void setBody(TaxDoc body) {
		this.body = body;
	}

	public ServiceXmlPackage setSuccess() {
		this.getHead().setSuccess();
		return this;
	}

	public ServiceXmlPackage setReturn(String code, String message) {
		this.getHead().setReturn(code, message);
		return this;
	}

}
