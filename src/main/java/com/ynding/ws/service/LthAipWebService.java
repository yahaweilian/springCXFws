package com.ynding.ws.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.ynding.ws.param2.ServiceXmlPackage;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface LthAipWebService {

	@WebResult(name="result")
	ServiceXmlPackage clfxxcjtj(@WebParam(name="request") ServiceXmlPackage request);
}
