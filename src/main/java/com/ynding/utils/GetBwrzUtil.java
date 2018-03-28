package com.ynding.utils;

import org.apache.log4j.Logger;

import com.ynding.entity.Bwrz;
import com.ynding.ws.param2.ServiceXmlPackage;


public class GetBwrzUtil {
	private static Logger logger = Logger.getLogger(GetBwrzUtil.class);
/****
 * 这个方法每次必用，防止每次都写，故写成一个获取报文日志的实体的方法
 * 
 * tianrui0518
 * 
 * 2017-07-01
 * ******/ 
/*  public static <T> Bwrz  getBwrz(ServiceXmlPackage request,Class<T> t){//解析请求头获得日志文件所需要的参数
	  if(t==null){
		  Bwrz 	bwrz = new Bwrz();
			bwrz.setChannelid(request.getHead().getChannel_id());
			bwrz.setTrandate(request.getHead().getTran_date());
			bwrz.setTranseq(request.getHead().getTran_seq());
			bwrz.setTransid(request.getHead().getTran_id());
			bwrz.setXml(request.getBody().toString());
			logger.info(request.getHead().getChannel_id()+"未解析报文，保存报文到数据库！");
			return bwrz;
		
	  }
	    Bwrz 	bwrz = new Bwrz();
		bwrz.setChannelid(request.getHead().getChannel_id());
		bwrz.setTrandate(request.getHead().getTran_date());
		bwrz.setTranseq(request.getHead().getTran_seq());
		bwrz.setTransid(request.getHead().getTran_id());
		bwrz.setXml(((T)request.getBody()).toString());
		logger.info(request.getHead().getChannel_id()+"解析报文，保存报文到数据库！");
		return bwrz;
}*/
  
  public static <T> Bwrz  getBwrz(ServiceXmlPackage request,String str){//解析请求头获得日志文件所需要的参数
	    Bwrz 	bwrz = new Bwrz();
		bwrz.setChannelid(request.getHead().getChannel_id());
		bwrz.setTrandate(request.getHead().getTran_date());
		bwrz.setTranseq(request.getHead().getTran_seq());
		bwrz.setTransid(request.getHead().getTran_id());
		bwrz.setXml(str);
		logger.info(request.getHead().getChannel_id()+"解析报文，保存报文到数据库！");
		return bwrz;
}
}
