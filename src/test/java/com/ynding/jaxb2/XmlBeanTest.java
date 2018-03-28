package com.ynding.jaxb2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ynding.ws.param2.Head;
import com.ynding.ws.param2.ServiceXmlPackage;
import com.ynding.ws.param2.TaxDoc;

public class XmlBeanTest {

	@Test
	public void testBean2XmlObject() {
		ServiceXmlPackage params = new ServiceXmlPackage();
		Head head = new Head();
		TaxDoc body = new TaxDoc();
		params.setHead(head);
		params.setBody(body);
		String string = XmlBean.bean2Xml(params);
				
		System.err.println(string);
	}
	
	@Test
	public void test2() {
		String xml = "<?xml version='1.0' encoding='UTF-8'?>"
				+ "<ns2:serviceXmlPackage xmlns:ns2='http://ynding.com/hr/schemas'>"
				+ "<ns2:head><ns2:channel_id>ahds</ns2:channel_id>"
				+ "<ns2:tran_seq>1fa1eb74939845f5b30d21b11a036d99</ns2:tran_seq>"
				+ "<ns2:tran_date>20180223</ns2:tran_date>"
				+ "</ns2:head><ns2:body/></ns2:serviceXmlPackage>";
		ServiceXmlPackage serviceXmlPackage = XmlBean.xml2Bean(xml, ServiceXmlPackage.class);
		System.out.println(serviceXmlPackage.getHead().getChannel_id());

	}







}
