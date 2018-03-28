package com.ynding.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.NsrDao;
import com.ynding.dao.TaxHouseDao;
import com.ynding.entity.Jyztb;
import com.ynding.entity.Nsr;
import com.ynding.entity.TaxHouse;
import com.ynding.utils.DateUtil;
import com.ynding.utils.ScUtil;
import com.ynding.ws.param2.taxML.FWXXCXLBResponse;
import com.ynding.ws.param2.taxML.Srfxx;
import com.ynding.ws.param2.taxML.ZLFXXQKCXRequest;
import com.ynding.ws.param2.taxML.ZLFXXQKCXResponse;


/********
 * 
 * 房产信息查询
 * 
 * tianrui0518
 * 
 * 2017-7-4 这里主要是从各个表里取数据组装成报文，然后转发给前端
 * 
 * 这里组装给zlcxxqkxc 、 clfxxqkxc
 * 
 * ***********/
@Service("fcxxcxService")
public class FcxxcxService {
	@Resource
	TaxHouseService taxHouseService;//获取tax_house的信息服务
	@Resource
	JyztbService jyztbService;//获取状态表信息服务
	@Resource
	TpfjService tpfjService;//获取图片附件信息服务
	@Resource
	JyskbService jyskbService;//获取税款表信息服务
	@Resource
	NsrService nsrService;//获取nsr信息的，然后组装成返回报文（crf和srf）服务
	@Autowired
	TaxHouseDao taxHouseDao;
	@Autowired
	NsrDao nsrDao;
	
	/*public String clfIstall(CLFXXCJRequest clfxxcjrequest, String channelid) {// 存量房返回信息组装
		return null;
	}*/

	public ZLFXXQKCXResponse zlfIstall(ZLFXXQKCXRequest zlfxxcjrequest, String channelid)
            throws Exception {// 增量房返回信息组装
		 Map<String, Object> params = new HashMap<String, Object>();
	        params.put("htbh", zlfxxcjrequest.getCshdjzh());
	        params.put("houseId", zlfxxcjrequest.getJyuuid());//map.put("houseId", clfxqcxRequest.getFwuuid());
	        TaxHouse house = taxHouseDao.getByHtbh(params);
	        params.put("fcxx_id",house.getHouseId());//zlfxxcjrequest.getJyuuid()
	        List<Nsr> nsrlist = nsrDao.getList(params);
	        Jyztb jyztb = jyztbService.getJyztbList(house.getHouseId(), channelid);
	        ZLFXXQKCXResponse response = new ZLFXXQKCXResponse();
	        if (house != null && nsrlist != null && jyztb !=null) {
	            response.setFwuuid(house.getHouseId()); //房屋UUID
	            response.setCshdjzh(house.getHtbh()); //编码house.getBianma()
	            response.setHtbh(house.getHtbh()); //合同编号
	            response.setSwjgbm(house.getZhuguan()); //税务机关编码
	            response.setBarq(DateUtil.format(house.getBarq(), "yyyy-MM-dd")); //备案日期
	            response.setXqmc(house.getXqmc()); //小区名称 
	            response.setFwwzdz(house.getDizhi()); //房屋地址
	            response.setZlc(house.getLoucengZong()); //楼层总
	            response.setSzlc(house.getLouceng());//楼层分
	            response.setJzmj(house.getMianji().doubleValue()); //建筑面积
	           response.setTnmj(jyztb.getTnmj());//tn面积  
	           response.setHtqdrq(DateUtil.format(jyztb.getHtqdrq(), "yyyy-MM-dd")); //合同签订日期
	           response.setHtje(jyztb.getHtjg()); //合同金额
	            response.setDj(house.getDj()); //单价
	            response.setJzjg(house.getJiegou()); //建筑结构
	            if ("JZJG004".equals(house.getJiegou())) {// 钢结构 钢、钢混 钢混 混合 砖木 木 其它
	            	 response.setJzjgmc("钢筋混凝土结构"); //建筑结构名称
			    } else if ("JZJG003".equals(house.getJiegou())) {
			    	 response.setJzjgmc("混合结构"); //建筑结构名称
			    } else if ("JZJG002".equals(house.getJiegou())) {
			    	 response.setJzjgmc("砖木结构"); //建筑结构名称
			    } else if ("JZJG001".equals(house.getJiegou())) {
			    	 response.setJzjgmc("钢(钢结构)"); //建筑结构名称
			    } else if ("JZJG005".equals(house.getJiegou())) {
			    	 response.setJzjgmc("砖混"); //建筑结构名称
			    } else {
			    	 response.setJzjgmc("钢筋混凝土结构"); //建筑结构名称
			    }
	            response.setJcnd(house.getNiandai()); //建成年代
	            response.setQszydx(jyztb.getQszydx());//权属对象
	            response.setQszydxmc(ScUtil.getByKey("dmsbqsqszydxData", jyztb.getQszydx(),String.class)); //权属名称
	            response.setQszyyt(jyztb.getQszyyt()); //权属用途 
	            response.setQszyytmc(ScUtil.getByKey("dmsbqsqszyytData", jyztb.getQszyyt(), String.class));//权属用途名称
	            response.setQszyfs(jyztb.getQszylb());//权属方式 
	            response.setQszyfsmc(ScUtil.getByKey("dmsbqsqszylbData", jyztb.getQszylb(), String.class)); //权属方式名称 
	            response.setFwdh(house.getFwdh()); //房屋栋号
	            response.setDy(house.getDanyuan());//单元
	            response.setFjh(house.getFanghao());//房间号

	            List<Srfxx> srfxx = null;
//	            List<Kfsxx> kfsxx = null;
	            srfxx = new ArrayList<Srfxx>();
//	            kfsxx = new ArrayList<Kfsxx>();
	           for (Nsr nsrxx : nsrlist) {
	                Srfxx srf = new Srfxx();
//	                Kfsxx kfs = new Kfsxx();
//	               if (nsrxx.getMmfbj().equals("0")) {
//	            	   kfs.setKfsmc(nsrxx.getNsrxm());
//	            	   
//	                   
//	                    kfs.setNsrsbh(nsrxx.getNsrzjhm());
//	                    kfs.setBdcxmbh(null);
//	                    kfs.setBdcxmmc(null);
//	                    kfsxx.add(kfs);
//	                } else {
	                   srf.setXm(nsrxx.getNsrxm()); //姓名
	                   srf.setZjlx(nsrxx.getNsrzjlxDm());//证件类型
	                   srf.setZjhm(nsrxx.getNsrzjhm());//证件号码
	                   srf.setDh(nsrxx.getDh());//电话
	                   srf.setDz(nsrxx.getDz());//地址
	                   srf.setSzfe(nsrxx.getSzfe());
	                   srf.setGyrbj(nsrxx.getGyrbj());    
//	                    srf.setFcbh(nsrxx.getFcxxId());
//	                    srf.setJyrlx(nsrxx.getJyrlx());
//	                    srf.setGj(nsrxx.getGjDm());      
//	                    srf.setJyfe(nsrxx.getJyfe());
//	                    srf.setDjxh(nsrxx.getDjxh());
//	                    srf.setZjlxmc(nsrxx.getZjlxmc());
	                   srfxx.add(srf);
	                
	           }
	            response.setSrfxxlb(srfxx);
//	           response.setKfsxx(kfsxx);
	            return response;
	        }
	        return null;
	    }
	
	public FWXXCXLBResponse getFwxxlb(List<com.ynding.ws.param2.taxML.Nsr> list){
		
		
		
		
		
		
		
		return null;
	}
	
	/**
	 * 根据合同编号查询查询记录数量
	 * @param htbh
	 * @return
	 */
	public Integer getCountByHtbh(String htbh){
		Map<String, Object> params = new HashMap<>();
		params.put("htbh", htbh);
		return taxHouseService.getCountByHtbh(params);
	}
}
