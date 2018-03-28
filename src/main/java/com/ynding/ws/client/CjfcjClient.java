package com.ynding.ws.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.transform.Source;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.ResourceSource;
import org.springframework.xml.transform.StringResult;

import com.ynding.jaxb2.JaxbUtil;
import com.ynding.jaxb2.XmlBean;
import com.ynding.ws.param2.Head;
import com.ynding.ws.param2.ServiceXmlPackage;
import com.ynding.ws.param2.TaxDoc;
import com.ynding.ws.service.LthAipWebService;

public class CjfcjClient {

    private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
	
	public void setDefaultUri(String defaultUri) {
		webServiceTemplate.setDefaultUri(defaultUri);
	}
	
	public void simpleSendAndReceive() throws IOException {
		Source source = new ResourceSource(new ClassPathResource("com/ynding/ws/client/ClfcjRequest.xml"));
		StringResult result = new StringResult();
		webServiceTemplate.sendSourceAndReceiveToResult(source, result);

		System.out.println("-------");
		System.out.println(JaxbUtil.converToJavaBean(result.toString(), ServiceXmlPackage.class));
		System.out.println("-------");
	}
	
	public static void main(String[] args) throws Exception {
		JaxWsClientFactoryBean jaxWsClientFactoryBean = new JaxWsClientFactoryBean();
		jaxWsClientFactoryBean.setAddress("http://localhost:8888/springCXFws/webservice/LthAipWebService?wsdl");
		jaxWsClientFactoryBean.setServiceClass(LthAipWebService.class);
		
		Client client = jaxWsClientFactoryBean.create();
		
		File file = new File("D:\\workspace4fun\\springCXFws\\target\\classes\\com\\ynding\\ws\\client\\ClfcjRequest.xml");
	    FileInputStream fileInputStream = new FileInputStream(file);
	    byte all[] = new byte[(int) file.length()];
	    fileInputStream.read(all);
	    String xmlString = all.toString();
		ServiceXmlPackage serviceXmlPackage = JaxbUtil.converToJavaBean(xmlString, ServiceXmlPackage.class);
		System.out.println(serviceXmlPackage.getHead().getChannel_id());
	    
	    
	    
//		ServiceXmlPackage params = new ServiceXmlPackage();
//		Head head = new Head();
//		TaxDoc body = new TaxDoc();
//		params.setHead(head);
//		params.setBody(body);
//		String string = JaxbUtil.convertToXml(params, "UTF-8");
//		String dd = XmlBean.bean2Xml(params);
//		System.err.println(dd);
		
		
		//Object[] response = client.invoke("clfxxcjtj", params);
		
		
	}
}
