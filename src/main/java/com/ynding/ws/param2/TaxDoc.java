//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2017.06.23 ʱ�� 11:12:43 AM CST 
//


package com.ynding.ws.param2;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.ynding.ws.param2.taxML.CLFXQCXRequest;
import com.ynding.ws.param2.taxML.CLFXXCJRequest;
import com.ynding.ws.param2.taxML.CLFXXCJResponse;
import com.ynding.ws.param2.taxML.FWXXCXLBResponse;
import com.ynding.ws.param2.taxML.ZLFXXQKCXRequest;


/**,SBXXBCResponse.class,SBXXBCRequest.class,
 * 请求 响应基类
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body")
@XmlSeeAlso({CLFXXCJRequest.class, CLFXXCJResponse.class,
       CLFXQCXRequest.class,FWXXCXLBResponse.class,ZLFXXQKCXRequest.class})
public class TaxDoc implements Serializable {

    private static final long serialVersionUID = -1894542323339348315L;
    public TaxDoc(){

    }
}
