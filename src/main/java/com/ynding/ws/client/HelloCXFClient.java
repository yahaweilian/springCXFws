package com.ynding.ws.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;

import com.ynding.ws.service.HelloCXFService;

public class HelloCXFClient {

	public static void main(String[] args) throws Exception {
		JaxWsClientFactoryBean jaxWsClientFactoryBean = new JaxWsClientFactoryBean();
		jaxWsClientFactoryBean.setAddress("http://localhost:8888/springCXFws/webservice/HelloCXFService?wsdl");
		jaxWsClientFactoryBean.setServiceClass(HelloCXFService.class);
		
		Client client = jaxWsClientFactoryBean.create();
		Object[] string = client.invoke("hellCXF", "1111");
		System.err.println(string[0]);
	}
}
