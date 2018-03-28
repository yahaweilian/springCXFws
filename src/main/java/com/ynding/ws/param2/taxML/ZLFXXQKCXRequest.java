//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.10.26 ʱ�� 03:40:08 PM CST 
//


package com.ynding.ws.param2.taxML;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ynding.ws.param2.TaxDoc;



/**
 * 增量房根据jyuuid查询已经提交的信息（查询房产网上交易办税系统的数据）
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
@XmlType(name = "ZLFXXQKCXRequest")
//@XmlRootElement(name="taxML")
public class ZLFXXQKCXRequest
    extends TaxDoc
{
	@XmlElement(required = true)
    protected String jyuuid;//交易UUID
	@XmlElement(required = true)
	protected String cshdjzh;//合同编号

	
	public String getJyuuid() {
		return jyuuid;
	}

	public void setJyuuid(String jyuuid) {
		this.jyuuid = jyuuid;
	}

	public String getCshdjzh() {
		return cshdjzh;
	}

	public void setCshdjzh(String cshdjzh) {
		this.cshdjzh = cshdjzh;
	}

   
        
}
