package com.ynding.jaxb2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ynding.ws.param2.Head;
import com.ynding.ws.param2.ServiceXmlPackage;
import com.ynding.ws.param2.TaxDoc;

public class JaxbUtilTest {

	@Test
	public void testConvertToXmlObject() {
		String xml = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?>"
				+ "<ns2:serviceXmlPackage xmlns:ns2='http://ynding.com/hr/schemas'>"
				+ "<ns2:head>"
				+ "<ns2:channel_id>ahds</ns2:channel_id>"
				+ "<ns2:tran_seq>83ef30074c024abca51b584d535a140d</ns2:tran_seq>"
				+ "<ns2:tran_date>20180223</ns2:tran_date>"
				+ "</ns2:head>"
				+ "<ns2:body/>"
				+ "</ns2:serviceXmlPackage>";
		ServiceXmlPackage serviceXmlPackage = JaxbUtil.converToJavaBean(xml, ServiceXmlPackage.class);
		System.out.println(serviceXmlPackage.getHead().getChannel_id());
		
	}

	@Test
	public void testConvertToXmlObjectString() {
		ServiceXmlPackage params = new ServiceXmlPackage();
		Head head = new Head();
		TaxDoc body = new TaxDoc();
		params.setHead(head);
		params.setBody(body);
		String string = JaxbUtil.convertToXml(params, "UTF-8");
		System.err.println(string);
	}

	@Test
	public void testConverToJavaBean() {
		fail("Not yet implemented");
	}

}
