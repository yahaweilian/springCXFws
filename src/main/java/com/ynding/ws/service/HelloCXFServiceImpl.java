package com.ynding.ws.service;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

@Component("helloCXFServiceImpl")
@WebService(serviceName = "HelloCXFService", endpointInterface = "com.ynding.ws.service.HelloCXFService")
public class HelloCXFServiceImpl implements HelloCXFService {

	@Override
	public String hellCXF(String something) {
		return "hello" + something;
	}

}
