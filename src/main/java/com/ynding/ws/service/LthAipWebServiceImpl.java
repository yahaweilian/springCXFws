package com.ynding.ws.service;

import java.util.Date;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ynding.dao.YcclilbDao;
import com.ynding.entity.Yccljlb;
import com.ynding.exception.DbOprationException;
import com.ynding.jaxb2.XmlBean;
import com.ynding.service.BwrzService;
import com.ynding.service.FcxxcxService;
import com.ynding.service.FcxxtjService;
import com.ynding.service.YcclilbService;
import com.ynding.utils.DateUtil;
import com.ynding.utils.GetBwrzUtil;
import com.ynding.utils.HttpClientUtil;
import com.ynding.ws.param2.Head;
import com.ynding.ws.param2.ServiceXmlPackage;
import com.ynding.ws.param2.taxML.CLFXXCJRequest;
import com.ynding.ws.param2.taxML.CLFXXCJResponse;

@Component("lthAipWebServiceImpl")
@WebService(serviceName = "LthAipWebService", endpointInterface = "com.ynding.ws.service.LthAipWebService")
public class LthAipWebServiceImpl implements LthAipWebService {

	private static Logger logger = Logger.getLogger(LthAipWebServiceImpl.class);
	
	@Autowired
	private Environment env;
	@Resource
	FcxxcxService fcxxcxService;
	@Resource
	FcxxtjService fcxxtjService;
	@Resource
	YcclilbService ycclilbService;
	@Resource
	BwrzService bwrzService;
	@Autowired
	YcclilbDao ycclilbDao;
	
	/*
	 *
	 * 02.存量房信息采集提交(完)
	 */
	@Override
	public ServiceXmlPackage clfxxcjtj(ServiceXmlPackage request) {
		ServiceXmlPackage ret = writeBwrz(request);
		if (ret != null) {
			return ret;
		}
		ret = new ServiceXmlPackage();
		CLFXXCJResponse clfxxcjResponse = new CLFXXCJResponse();
		CLFXXCJRequest clfxxcjRequest = (CLFXXCJRequest) request.getBody();
		if (clfxxcjRequest != null) {
			String bianma = clfxxcjRequest.getHtbh();
			// 判断合同编号是否已经存在
			Integer count = fcxxcxService.getCountByHtbh(bianma);
			if (count != null && count > 0) {
				ret.getHead().setRtn_code("15");
				ret.getHead().setRtn_msg("该合同编号为" + bianma + "的记录已经保存！");
				logger.info(request.getHead().getChannel_id() + "在" + DateUtil.formatDate(new Date()) + ":该合同编号为"
						+ bianma + "的记录的二次保存！");
				return ret;
			}
			String str = this.fcxxtjService.clfInfoSave(clfxxcjRequest, request.getHead().getChannel_id());
			if ("-1".equals(str)) {
				ret.getHead().setRtn_code("15");
				ret.getHead().setRtn_msg("房产信息保存失败");
				logger.info(request.getHead().getChannel_id() + "在" + DateUtil.formatDate(new Date()) + ":房产信息保存失败！");
			} else {
				clfxxcjResponse.setJyUuid(str);
				clfxxcjResponse.setHtbh(clfxxcjRequest.getHtbh());
				ret.setBody(clfxxcjResponse);
				ret.getHead().setRtn_code("0");
				ret.getHead().setRtn_msg("房产信息保存成功");
				logger.info(request.getHead().getChannel_id() + "在" + DateUtil.formatDate(new Date()) + ":房产信息保存成功！");
				try {
					String responseResquest = HttpClientUtil.responseResquest1(env.getProperty("zdurl") + str);
					logger.info("调用自动流程的url为：" + env.getProperty("zdurl") + str);
				} catch (Exception e) {
					Yccljlb ylb = new Yccljlb();
					ylb.setFcxx_id(str);
					ylb.setDqyczt("200");
					logger.info(request.getHead().getChannel_id() + "在" + DateUtil.formatDate(new Date())
							+ ":保存数据时，自动审核接口未联通，自动转为异常处理！,异常信息为：" + e.getMessage());
					ycclilbDao.add(ylb);
				}

			}
		} else {
			ret.getHead().setRtn_code("13");
			ret.getHead().setRtn_msg("您的请求参数体为空！");
			logger.info(request.getHead().getChannel_id() + "在" + DateUtil.formatDate(new Date()) + ":请求体为空！");
		}

		return ret;
	}

	
	public <T> ServiceXmlPackage writeBwrz(ServiceXmlPackage request) {// 写报文日志的方法
		ServiceXmlPackage ret = null;
		try {
			ret = process_request(request);// 先判断报文头是否为空，为空直接返回数据，如果不为空执行下面的写入日志文件
			if (ret == null) {
				com.ynding.jaxb2.XmlBean xml = new XmlBean();
				String xmlstring = xml.bean2Xml(request);
				this.bwrzService.insertBwrz(GetBwrzUtil.getBwrz(request, xmlstring));// 写日志文件，如果发生异常，直接返回
				logger.info(request.getHead().getChannel_id() + "成功请求了报文，报文为：" + xmlstring);
			}
		} catch (DbOprationException e) {
			ret = new ServiceXmlPackage();
			ret.setHead(request.getHead().setReturn("1", "违反唯一约束，该tran_seq已经使用了或者请求头参数不全"));
			logger.info(request.getHead().getChannel_id() + "违反唯一约束，该tran_seq已经使用了或者请求头参数不全！,异常信息为：" + e.getMessage());
		}
		return ret;
	}
	
	public ServiceXmlPackage process_request(ServiceXmlPackage request) {
		ServiceXmlPackage ret = null;
		if (!validPackage(request)) {// 如果为false，则直接返回错误信息，请求报文头部有问题，否则返回一个对象
			ret = new ServiceXmlPackage();
			ret.getHead().setRtn_code("14");
			ret.getHead().setRtn_msg("您的请求报文头为空！");
			logger.info(request.getHead().getChannel_id() + "请求报文头为空！");
		}
		return ret;
	}


	private boolean validPackage(ServiceXmlPackage serviceXmlPackage) {// 对报文头进行验证
		Head head = serviceXmlPackage.getHead();// 获取头部对象
		if (head == null) {// 如果头部为空，返回false
			return false;
		} // 否则返回true
		return true;
	}
}
