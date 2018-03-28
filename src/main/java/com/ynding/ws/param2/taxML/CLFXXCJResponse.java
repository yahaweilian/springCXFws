//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.10.26 ʱ�� 03:44:13 PM CST 
//


package com.ynding.ws.param2.taxML;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import com.ynding.ws.param2.TaxDoc;


/**
 * 存量房采集返回报文
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
@XmlType(name = "CLFXXCJResponse")
public class CLFXXCJResponse
    extends TaxDoc
{
	//@XmlList
		//@XmlElementWrapper
		protected String jyUuid;
		protected String htbh;

		public String getJyUuid() {
			return jyUuid;
		}

		public void setJyUuid(String jyUuid) {
			this.jyUuid = jyUuid;
		}

		public String getHtbh() {
			return htbh;
		}

		public void setHtbh(String htbh) {
			this.htbh = htbh;
		}
		
		
	
}
