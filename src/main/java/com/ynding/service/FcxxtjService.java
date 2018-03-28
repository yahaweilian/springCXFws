package com.ynding.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ynding.Enum.Fcjyzt;
import com.ynding.dao.YjxxDao;
import com.ynding.entity.Jspz;
import com.ynding.entity.Jyskb;
import com.ynding.entity.Jyztb;
import com.ynding.entity.Nsr;
import com.ynding.entity.NsrJtcy;
import com.ynding.entity.TaxArea;
import com.ynding.entity.TaxHouse;
import com.ynding.entity.Yjxx;
import com.ynding.entity.Zjxx;
import com.ynding.exception.DbOprationException;
import com.ynding.utils.DateUtil;
import com.ynding.utils.ScUtil;
import com.ynding.ws.param2.taxML.CLFXQCXRequest;
import com.ynding.ws.param2.taxML.CLFXXCJRequest;
import com.ynding.ws.param2.taxML.Crfxx;
import com.ynding.ws.param2.taxML.CrfxxJtcy;
import com.ynding.ws.param2.taxML.Crfyh;
import com.ynding.ws.param2.taxML.Fctpfj;
import com.ynding.ws.param2.taxML.Srfxx;
import com.ynding.ws.param2.taxML.SrfxxJtcy;
import com.ynding.ws.param2.taxML.Srfyh;
import com.ynding.ws.param2.taxML.ZLFXXCJRequest;


/********
 *
 * 房产信息提交
 *
 * tianrui0518
 *
 * 2017-7-4 信息保存主要地方，数据不全主要查看这里是否有数据遗漏
 *
 ***********/
@Service("fcxxtjService")
@SuppressWarnings("all")
public class FcxxtjService {
	private Logger logger = Logger.getLogger(FcxxtjService.class);
	@Resource
	TaxHouseService taxHouseService;
	@Resource
	JyztbService jyztbService;
	@Resource
	TpfjService tpfjService;
	@Resource
	JyskbService jyskbService;
	@Resource
	NsrService nsrService;
	@Resource
	ZjxxService zjxService;
	@Resource
	NsrJtcyService nsrJtcyService;
	@Resource
	JspzService jspzService;
	@Resource
	YjxxService yjxxService;
	@Autowired
	YjxxDao yjxxDao;
	
	@Transactional(readOnly = false)
	public String clfInfoSave(CLFXXCJRequest clfxxcjrequest, String channelid) {// 存量房信息采集方法
		String fwuuid = UUID.randomUUID().toString().replaceAll("-", "");// 产生一个房屋的uuid
		logger.info("提交保存增量房产生的房屋uuid为"+fwuuid);
		int i = 0, l = 0, m = 0, n = 0, k = 0, f = 0, j =0,h=0;
		
		try {
			/*
			 * 图片信息保存
			 */
			List<Fctpfj> list = clfxxcjrequest.getFctpfjsy().getFctpfjlb().getFctpfj();
			i = getTpfj(list, fwuuid);
			 for (Fctpfj fctpfj : list) {//更新fwuuid到list，然后更新该list
		    	  fctpfj.setFcxxid(fwuuid);;
		      }
		      tpfjService.updateFctpfj(list);
			/*
			 * 购买方和出让方信息保存(完)
			 */
			Map<String, Object> data = getNsr(clfxxcjrequest, fwuuid);
			List<Nsr> nsrList = (List<Nsr>) data.get("nsr_list");
			if (nsrList != null) {
				n = this.nsrService.addNsrInfo(nsrList);
			}
			
			/*
			 * 优惠减免保存
			 */
			List<Jyskb> jyskbList = saveYhjm(clfxxcjrequest, fwuuid, data);
			if (jyskbList != null&&jyskbList.size()>0) {
				m = this.jyskbService.addJyskbInfo(jyskbList);
			}else{
				m=1;//设置一个大于0的默认值，可以不为1，保证后面的判断成立
			}
		
			/*
			 * 保存双方家庭成员
			 */
			String crfxxId = null;
			String srfxxId = null;
			for (Nsr nsr : nsrList) {
				if (nsr.getMmfbj().equals("0")) {
					crfxxId = nsr.getNsrId();
				} else {
					srfxxId = nsr.getNsrId();
				}
			}

			List<NsrJtcy> nsrJtcy = getNsrJtcy(clfxxcjrequest, crfxxId, srfxxId);
			if(nsrJtcy!=null&&nsrJtcy.size()>0){
				f = nsrJtcyService.addNsrJtcyInfo(nsrJtcy);
			}else{
				f=1;//设置一个大于0的默认值，可以不为1，保证后面的判断成立
			}
			
			
			

			/*
			 * 保存房产taxhouse基本信息(包含合同编号)(完)
			 */
			TaxHouse taxHouse = getTaxHouse(clfxxcjrequest, fwuuid);
				l = this.taxHouseService.addTaxHouseObjectInfo(taxHouse);
		

			/*
			 * 保存中介信息
			 */
			Zjxx zjxx = getZjxx(clfxxcjrequest, fwuuid);
			k = zjxService.addZjxx(zjxx);

			/*
			 * 交易状态信息保存
			 */
			Jyztb jyztb = getJyztbInfo(clfxxcjrequest, fwuuid, channelid);
			j = this.jyztbService.addJyztbInfo(jyztb);
			
			List<Yjxx> yjxxlist = getJyxxInfo(clfxxcjrequest, fwuuid);
			if(yjxxlist!=null&&yjxxlist.size()>0){
				h=this.yjxxDao.batchAdd(yjxxlist);
			}else{
				h=1;
			}
			
			
			
			
		} catch (Exception e) {
			logger.info("存量房信息保存失败，原因为："+e.getMessage());
			return "-1";// 出现异常，事物回滚
			
		}
		
		//i==0  && 
		if (l > 0 && m > 0 && n > 0 && k > 0 && f > 0 && h>0) {
			return fwuuid;// 保存成功
		}
		return "-1";// 保存失败
	}

	private List<Yjxx> getJyxxInfo(CLFXXCJRequest clfxxcjrequest, String fwuuid) {
		List<com.ynding.ws.param2.taxML.Yjxx> list1=clfxxcjrequest.getCrfyjxx();
		List<com.ynding.ws.param2.taxML.Yjxx> list2=clfxxcjrequest.getSrfyjxx();
		List<Yjxx> yjxxlist = new ArrayList<Yjxx>();
		if(list1!=null&&list1.size()>0){
			for (int i = 0; i < list1.size(); i++) {
				Yjxx yjxx = new Yjxx();
				yjxx.setFcxxId(fwuuid);
				yjxx.setMmfbz("0");
				yjxx.setXm(list1.get(i).getXm());
				yjxx.setDh(list1.get(i).getDh());
				yjxx.setDz(list1.get(i).getDz());
				yjxxlist.add(yjxx);
			}
		}
		if(list2!=null&&list2.size()>0){
			for (int i = 0; i < list2.size(); i++) {
				Yjxx yjxx = new Yjxx();
				yjxx.setFcxxId(fwuuid);
				yjxx.setMmfbz("1");
				yjxx.setXm(list2.get(i).getXm());
				yjxx.setDh(list2.get(i).getDh());
				yjxx.setDz(list2.get(i).getDz());
				yjxxlist.add(yjxx);
			}
		}
		
		
		
		return yjxxlist;
	}

	/***
	 * 根据报文解析，然后按照要求来存放到各个表里，主要有状态表、tax_house表、图片附件表、税款表、纳税人表
	 * @throws Exception 
	 *
	 ***/
	@Transactional(readOnly = false)
	public String zlfInfoSave(ZLFXXCJRequest zlfxxcjrequest, String channelid) throws Exception {// 增量房信息采集方法
		String fwuuid = UUID.randomUUID().toString().replaceAll("-", "");// 产生一个房屋的uuid
		logger.info("提交保存增量房产生的房屋uuid为"+fwuuid);
		TaxHouse taxHouse = getTaxHouse(zlfxxcjrequest, fwuuid);
		Jyztb jyztb = getJyztbInfo(zlfxxcjrequest, fwuuid, channelid);
		List<Fctpfj> list = zlfxxcjrequest.getFctpfjsy().getFctpfjlb().getFctpfj();
		String kfsmc = zlfxxcjrequest.getKfsxxlb().get(0).getKfsmc();
		//处理商品房企业信息
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("fwuuid", fwuuid);
		params.put("uuid", UUID.randomUUID().toString().replaceAll("-", ""));
		params.put("kfsmc", kfsmc);
		params.put("nsrsbh", "");
		int l = -1, m = 0, n = 0, k = 0, i=0, j=0,t = 0,h=0;
		try {
			l = getTpfj(list, fwuuid);
			 for (Fctpfj fctpfj : list) {//更新fwuuid到list，然后更新该list
		    	  fctpfj.setFcxxid(fwuuid);;
		      }
		      tpfjService.updateFctpfj(list);
			Map<String, Object> data = getNsr(zlfxxcjrequest, fwuuid, kfsmc);
			List<Nsr> list2 = (List<Nsr>) data.get("nsr_list");
			List<Jyskb> list1 = saveYhjm(zlfxxcjrequest, fwuuid, data);
			//List<Nsr> list2 = getNsr(zlfxxcjrequest, fwuuid,kfsmc);
			List<NsrJtcy> nsrJtcy = getNsrJtcy(zlfxxcjrequest, list2);
			
			/*
			 * if (list != null) { l = this.tpfjService.addTpfjInfo(list); }
			 */
			if (list1 != null&&list1.size()>0) {
				m = this.jyskbService.addJyskbInfo(list1);
			}else{
				m=1;//设置一个大于0的默认值，可以不为1，保证后面的判断成立
			}

			if (list2 != null) {
				n = this.nsrService.addNsrInfo(list2);
			}

			if (nsrJtcy != null&&nsrJtcy.size()>0) {
				k = this.nsrJtcyService.addNsrJtcyInfo(nsrJtcy);
			}else{
				k=1;//设置一个大于0的默认值，可以不为1，保证后面的判断成立
			}
			
			if(params!=null){
				t = this.jyztbService.addBdcxxInfo(params);
			}

			i = this.taxHouseService.addTaxHouseInfo(taxHouse);// 保存房产taxhouse基本信息
			j = this.jyztbService.addJyztbInfo(jyztb);
			
			List<Yjxx> yjxxlist = getJyxxInfo(zlfxxcjrequest, fwuuid);
			if(yjxxlist!=null&&yjxxlist.size()>0){
				h=this.yjxxDao.batchAdd(yjxxlist);
			}else{
				h=1;
			}
			
		} catch (Exception e) {
			logger.info("存量房信息保存失败，原因为："+e.getMessage());
			return "-1";
		}
		
		if (  i > 0 && j > 0 && m > 0 && n > 0 && k > 0 && t > 0 && h>0) {//l==0 &&
			return fwuuid + "," + zlfxxcjrequest.getCshdjzh();// 保存成功
		}
		return "-1";// 保存失败
	}
  
	
	/***
	 * 根据报文解析，然后按照要求来存放到各个表里，主要有状态表、tax_house表、图片附件表、税款表、纳税人表
	 * @throws Exception 
	 *
	 ***/
	@Transactional(readOnly = false)
	public String zlfInfoSave1(ZLFXXCJRequest zlfxxcjrequest, String channelid) throws Exception {// 增量房信息采集方法
		String fwuuid = UUID.randomUUID().toString().replaceAll("-", "");// 产生一个房屋的uuid
		logger.info("提交保存增量房产生的房屋uuid为"+fwuuid);
		TaxHouse taxHouse = getTaxHouse(zlfxxcjrequest, fwuuid);
		Jyztb jyztb = getJyztbInfo(zlfxxcjrequest, fwuuid, channelid);
		List<Fctpfj> list = zlfxxcjrequest.getFctpfjsy().getFctpfjlb().getFctpfj();
		String kfsmc = zlfxxcjrequest.getKfsxxlb().get(0).getKfsmc();
		String nsrsbh = zlfxxcjrequest.getKfsnsrsbh();
		//处理商品房企业信息
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("fwuuid", fwuuid);
		params.put("uuid", UUID.randomUUID().toString().replaceAll("-", ""));
		params.put("kfsmc", kfsmc);
		params.put("nsrsbh", nsrsbh);
		int l = -1, m = 0, n = 0, k = 0, i=0, j=0,t = 0,h=0,w=0;
		try {
			l = getTpfj(list, fwuuid);
			 for (Fctpfj fctpfj : list) {//更新fwuuid到list，然后更新该list
		    	  fctpfj.setFcxxid(fwuuid);;
		      }
		      tpfjService.updateFctpfj(list);
			Map<String, Object> data = getNsr(zlfxxcjrequest, fwuuid, kfsmc);
			List<Nsr> list2 = (List<Nsr>) data.get("nsr_list");
			List<Jyskb> list1 = saveYhjm(zlfxxcjrequest, fwuuid, data);
			//List<Nsr> list2 = getNsr(zlfxxcjrequest, fwuuid,kfsmc);
			List<NsrJtcy> nsrJtcy = getNsrJtcy(zlfxxcjrequest, list2);
			
			/*
			 * if (list != null) { l = this.tpfjService.addTpfjInfo(list); }
			 */
			if (list1 != null&&list1.size()>0) {
				m = this.jyskbService.addJyskbInfo(list1);
			}else{
				m=1;//设置一个大于0的默认值，可以不为1，保证后面的判断成立
			}

			if (list2 != null) {
				n = this.nsrService.addNsrInfo(list2);
			}

			if (nsrJtcy != null&&nsrJtcy.size()>0) {
				k = this.nsrJtcyService.addNsrJtcyInfo(nsrJtcy);
			}else{
				k=1;//设置一个大于0的默认值，可以不为1，保证后面的判断成立
			}
			
			if(params!=null){
				t = this.jyztbService.addBdcxxInfo(params);
			}

			i = this.taxHouseService.addTaxHouseInfo(taxHouse);// 保存房产taxhouse基本信息
			j = this.jyztbService.addJyztbInfo(jyztb);
			
			Zjxx zjxx = getDbgs(zlfxxcjrequest, fwuuid);
			w = zjxService.addZjxx(zjxx);
			
			List<Yjxx> yjxxlist = getJyxxInfo(zlfxxcjrequest, fwuuid);
			if(yjxxlist!=null&&yjxxlist.size()>0){
				h=this.yjxxDao.batchAdd(yjxxlist);
			}else{
				h=1;
			}
			
		} catch (Exception e) {
			logger.info("存量房信息保存失败，原因为："+e.getMessage());
			return "-1";
		}
		
		if (  i > 0 && j > 0 && m > 0 && n > 0 && k > 0 && t > 0 && h>0 && w>0) {//l==0 &&
			return fwuuid + "," + zlfxxcjrequest.getCshdjzh();// 保存成功
		}
		return "-1";// 保存失败
	}
	
	private List<Yjxx> getJyxxInfo(ZLFXXCJRequest zlfxxcjrequest, String fwuuid) {
		List<com.ynding.ws.param2.taxML.Yjxx> list = zlfxxcjrequest.getSrfyjxx();
		List<Yjxx> yjxxlist = new ArrayList<Yjxx>();
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				Yjxx yjxx = new Yjxx();
				yjxx.setFcxxId(fwuuid);
				yjxx.setMmfbz("1");
				yjxx.setXm(list.get(i).getXm());
				yjxx.setDh(list.get(i).getDh());
				yjxx.setDz(list.get(i).getDz());
				yjxxlist.add(yjxx);
			}
		}
		
		return yjxxlist;
	}

	/*
	 * 从数据库里面获取数据
	 */
	public TaxHouse getTaxHouse(CLFXQCXRequest clfxqcxRequest) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("houseId", clfxqcxRequest.getFwuuid());
		map.put("htbh", clfxqcxRequest.getHtbh());
		return taxHouseService.getTaxHouse(map);
	}

	public Jyztb getJyztb(TaxHouse taxHouse, String channelId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("fcxxId", taxHouse.getHouseId());
		map.put("channelId", channelId);
		return jyztbService.getJyztb(map);

	}

	public List<Nsr> getNsrList(TaxHouse taxHouse) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("fcxxId", taxHouse.getHouseId());
		return nsrService.getNsrs(map);
	}

	public List<NsrJtcy> getNsrJtcy(String nsrId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nsrId", nsrId);
		return nsrJtcyService.getNsrJecyList(map);
	}

	// ==================================================================
	public TaxHouse getTaxHouse(CLFXXCJRequest clfxxcjrequest, String uuid) {// 对大报文里的数据进行拆分保存，分别存到不同的表里
		TaxHouse th = new TaxHouse();
		th.setHouseId(uuid);// 房屋的uuid
		th.setBianma(clfxxcjrequest.getFcbm());// 房产编码 1
		th.setXinfang("0"); // 新房或者旧房
		th.setHtbh(clfxxcjrequest.getHtbh());// 合同编号 1
		th.setBarq(clfxxcjrequest.getBarq()); // 备案日期 1
		if(clfxxcjrequest.getFssslx().contains("跃层")){
			th.setFushu1(new BigDecimal(clfxxcjrequest.getFswmj()));
		}else if(clfxxcjrequest.getFssslx().contains("阁楼")){
			th.setFushu2(new BigDecimal(clfxxcjrequest.getFswmj()));
		}else if(clfxxcjrequest.getFssslx().contains("地下室")){
			th.setFushu3(new BigDecimal(clfxxcjrequest.getFswmj()));
		}else if(clfxxcjrequest.getFssslx().contains("车库")){
			th.setFushu4(new BigDecimal(clfxxcjrequest.getFswmj()));
		}else if(clfxxcjrequest.getFssslx().contains("庭院")){
			th.setFushu5(new BigDecimal(clfxxcjrequest.getFswmj()));
		}
		th.setXqmc(clfxxcjrequest.getXqmc()==null?"":clfxxcjrequest.getXqmc());//小区名称
		th.setFenqu(clfxxcjrequest.getXqdm()==null?"":clfxxcjrequest.getXqdm()); // 分区 FENQU
		th.setYongtu(clfxxcjrequest.getFwyt());
		TaxArea area = ScUtil.getByKey("quhao_TaxAreaData", clfxxcjrequest.getJdxz(), TaxArea.class);
		th.setJiedao(area==null?"":area.getQuwei());// ============================================
		th.setChengshi(area.getQuwei().substring(0, area.getQuwei().indexOf("-")));// 小区代码前二位// 城市
		th.setQuhua(area.getQuwei().substring(0, area.getQuwei().lastIndexOf("-")) );// 小区代码前五位// 区划
		th.setDizhi(clfxxcjrequest.getFwwzdz());// 地址 1
		th.setQuanzhengTime(clfxxcjrequest.getQztzrq());// 权证填制日期 1

		th.setLoucengZong(clfxxcjrequest.getZlc());// 总楼层 1
		th.setLouceng(clfxxcjrequest.getSzlc());// 所在楼层 1

		int zlc = clfxxcjrequest.getZlc();
		if(zlc==1){
			th.setLeixingFen("ZZ000001"); // 房产类型
		}else if(zlc >= 2 && zlc <= 3){
			th.setLeixingFen("ZZ000002"); // 房产类型
		}else if(zlc >= 4 && zlc <= 7){
			th.setLeixingFen("ZZ000003"); // 房产类型
		}else if(zlc >= 8 && zlc <= 18){
			th.setLeixingFen("ZZ000004"); // 房产类型
		}else if(zlc >= 19 && zlc <= 33){
			th.setLeixingFen("ZZ000005"); // 房产类型
		}else if(zlc > 33){
			th.setLeixingFen("ZZ000006"); // 房产类型
		}
		
		th.setLeixingZong("ZZ"); // 类型总
		th.setMianji(clfxxcjrequest.getJzmj());// 建筑面积 1
		th.setJiegou(clfxxcjrequest.getJzjg().split(",")[0]);// 建筑结构 ,前面一部分为建筑结构，后面部分为房屋内内码
		th.setNiandai(clfxxcjrequest.getJcnd());// 建筑年代 1
		th.setShenbao(clfxxcjrequest.getSbjg());// 申报价格 1
		th.setDj(clfxxcjrequest.getDj());// 单价 1
		th.setQianci(clfxxcjrequest.getQcjyjg());// 前次交易价格 1
		th.setQianciTime(clfxxcjrequest.getQcjyrq());// 前次交易时间 1
		th.setQianciWay(clfxxcjrequest.getQcjylx());// 前次交易类型 1
		th.setQuanshu(clfxxcjrequest.getQszyfs());// 权属转移类别 1
		th.setFwdh(clfxxcjrequest.getFwdh());// 房屋栋号 1
		th.setDanyuan(clfxxcjrequest.getDy()==null?"":clfxxcjrequest.getDy());// 建筑单元位置 1 null
		th.setFanghao(clfxxcjrequest.getFjh()); // 房间号 1
		th.setFsje(clfxxcjrequest.getFsje());// 附属金额 1
		th.setZhuguan(clfxxcjrequest.getSwjgbm()); // 税务机关编码(主管)
		th.setZhuangxiu("ZXQK005");// 装修情况
		th.setCaoxiang("FWCX005");// 建筑朝向
		th.setFangfa("MARKET");// 评估方法
		th.setLinjie("FQWZ001");// 分区位置
		th.setCaozuo(" ");// 操作员
		th.setLuruTime(new Date());// 录入时间
		th.setChurang(" "); // 出让方
		th.setShourang(" ");// 收购让
		return th;
	}

	public Jyztb getJyztbInfo(CLFXXCJRequest clfxxcjrequest, String uuid, String channelid) {
		Jyztb jyztb = new Jyztb();
		jyztb.setChannelId(channelid);// 渠道id CHANNEL_ID
		jyztb.setFcxxId(uuid);// 房产uuid FCXX_ID
		jyztb.setJyId(uuid);
		jyztb.setXzqhDm(clfxxcjrequest.getXzqh());// 行政区划
		jyztb.setJyzt("200");
		jyztb.setHtqdrq(clfxxcjrequest.getHtqdrq());// 合同签订日期 HTQDRQ
		jyztb.setQszydx(clfxxcjrequest.getQszydx());// 权属转移对象 QSZYDX
		jyztb.setQszyyt(clfxxcjrequest.getQszyyt());// 权属转移用途 QSZYYT
		jyztb.setQszylb(clfxxcjrequest.getQszyfs());// 权属转移类别
		jyztb.setTnmj(Float.valueOf(clfxxcjrequest.getTlmj()));// 套类面积 TNMJ
		jyztb.setFssslx(clfxxcjrequest.getFssslx());// 附属设施类型 FSSSLX
		jyztb.setFsmj(clfxxcjrequest.getFswmj());// 附属物面积 FSMJ
		jyztb.setZjId(uuid); // 中介ID ZJ_ID
		jyztb.setZjgsbm(clfxxcjrequest.getZjgsbm()==null?"":clfxxcjrequest.getZjgsbm());
		jyztb.setZjysbh(clfxxcjrequest.getZjysbh()==null?"":clfxxcjrequest.getZjysbh());
		jyztb.setAcceptcode(clfxxcjrequest.getAcceptcode()==null?"":clfxxcjrequest.getAcceptcode());
		String [] str = clfxxcjrequest.getJzjg().split(",");
		if(str.length>=2){
			jyztb.setFwnm(str[1]);//建筑建构和房屋内码拼接在一起，前面是jzjg，后面是房屋内码
		}else{
			jyztb.setFwnm("null");//建筑建构和房屋内码拼接在一起，前面是jzjg，后面是房屋内码
		}
		
		return jyztb;

	}

	/***
	 * 根据报文解析，获取图片 图片保存在nfs服务器上 保存的是url在数据库，故这里在加和nfs交互的代码
	 *
	 * 缺少图片验证机制，看上传图片是否完全
	 * 
	 * @throws DbOprationException
	 ****/
	/*
	 * public int getTpfj(CLFXXCJRequest clfxxcjrequest, String uuid) throws
	 * DbOprationException { List<Fctpfj> list =
	 * clfxxcjrequest.getFctpfjsy().getFctpfjlb().getFctpfj();
	 * 
	 * return tpfjService.isInDb(list); //i=0表示list在数据库都存在
	 * 
	 * }
	 */
	/**
	 * 优惠减免保存
	 *
	 *
	 ******/
	public List<Jyskb> saveYhjm(CLFXXCJRequest clfxxcjrequest, String uuid, Map<String, Object> nsridMap)
			throws DbOprationException {
		List<Crfyh> crf = clfxxcjrequest.getCrfyhlb();
		List<Srfyh> srf = clfxxcjrequest.getSrfyhlb();
		List<Jyskb> list = new ArrayList<Jyskb>();
		
		BigDecimal htje = BigDecimal.valueOf(clfxxcjrequest.getHtje());

		if (crf != null) {
			for (int i = 0; i < crf.size(); i++) {
				Jspz jspz = jspzService.getBYJmxzdm(crf.get(i).getYhdm());
				double sl = jspz.getSl();
				
				Jyskb jyskb = new Jyskb();
				jyskb.setSkbid(UUID.randomUUID().toString().replaceAll("-", ""));
				jyskb.setFcxxId(uuid);
				jyskb.setClfzlfbz("0");// 0为存量房标记,1为增量房
				jyskb.setJmxzdm(jspz.getJmxzDm());
				jyskb.setMmfbz("0");// 卖0 买1
				jyskb.setQybz("1");// 0为不启用 1为启用
				
				jyskb.setSl((float) sl);
				jyskb.setNsrid((String)nsridMap.get("crf_nsrid"));
				jyskb.setZsxmDm(jspz.getZsxmDm());
				jyskb.setZxpmDm(jspz.getZspmDm());
				jyskb.setZszmDm(jspz.getZszmDm());
				//计算税额
				BigDecimal se = htje.multiply(BigDecimal.valueOf(sl));
				jyskb.setSe(se.doubleValue());
				jyskb.setJyfe(1.0f);
				jyskb.setJsje(clfxxcjrequest.getHtje());
				
				list.add(jyskb);
			}

		}
		if (srf != null) {
			for (int i = 0; i < srf.size(); i++) {
				Jspz jspz = jspzService.getBYJmxzdm(srf.get(i).getYhdm());
				double sl = jspz.getSl();
				
				Jyskb jyskb = new Jyskb();
				jyskb.setSkbid(UUID.randomUUID().toString().replaceAll("-", ""));
				jyskb.setFcxxId(uuid);
				jyskb.setClfzlfbz("0");// 0为存量房标记
				jyskb.setJmxzdm(jspz.getJmxzDm());// 
				jyskb.setMmfbz("1");
				jyskb.setQybz("1");// 0为不启用 1为启用
				
				jyskb.setSl((float) sl);
				jyskb.setNsrid((String)nsridMap.get("srf_nsrid"));
				jyskb.setZsxmDm(jspz.getZsxmDm());
				jyskb.setZxpmDm(jspz.getZspmDm());
				jyskb.setZszmDm(jspz.getZszmDm());
				//计算税额
				BigDecimal se = htje.multiply(BigDecimal.valueOf(sl));
				jyskb.setSe(se.doubleValue());
				jyskb.setJyfe(1.0f);
				jyskb.setJsje(clfxxcjrequest.getHtje());
				
				list.add(jyskb);
			}
		}

		return list;
	}

	public Map<String, Object> getNsr(CLFXXCJRequest clfxxcjrequest, String uuid) {
		Map<String, Object> result = new HashMap<>();

		List<Srfxx> srf = clfxxcjrequest.getSrfxxlb();
		List<Crfxx> crf = clfxxcjrequest.getCrfxxlb();
		List<Nsr> list = new ArrayList<Nsr>();
		if (srf != null && !srf.isEmpty()) {
			for (int i = 0; i < srf.size(); i++) {
				String nsrid = UUID.randomUUID().toString().replaceAll("-", "");
				if("0".equals(srf.get(i).getGyrbj())){
					result.put("srf_nsrid", nsrid);
				}

				Nsr nsr = new Nsr();
				nsr.setNsrId(nsrid);
				// ===========================================================================
				nsr.setFcxxId(uuid); // 房产编号
				nsr.setNsrlx("100000010");// 纳税人类型(交易人类型)
				nsr.setNsrxm(srf.get(i).getXm()); // 购买方姓名
				nsr.setNsrzjlxDm(srf.get(i).getZjlx());// 证件类型
				nsr.setNsrzjhm(srf.get(i).getZjhm());// 证件号码
				nsr.setDh(srf.get(i).getDh());// 联系电话
				nsr.setDz(srf.get(i).getDz());// 地址
				nsr.setGjDm(srf.get(i).getGj());// 国籍
				nsr.setGyrbj(srf.get(i).getGyrbj());// 共有人标记
				nsr.setJyfe(srf.get(i).getJyfe());// 交易份额
				nsr.setSzfe(srf.get(i).getSzfe()); // 所占份额
				nsr.setDjxh(srf.get(i).getDjxh());// 登记序号
				nsr.setMmfbj("1");// 设置买方标记 卖0 买1
				nsr.setLrsj(new Date());
				nsr.setClr(srf.get(i).getClr());
				list.add(nsr);
			}

		}

		if (crf != null && !crf.isEmpty()) {
			for (int i = 0; i < crf.size(); i++) {
				String nsrid = UUID.randomUUID().toString().replaceAll("-", "");
				if("0".equals(crf.get(i).getGyrbj())){
					result.put("crf_nsrid", nsrid);
				}

				Nsr nsr = new Nsr();
				nsr.setFcxxId(uuid);
				nsr.setNsrId(nsrid);
				// ===========================================================================
				nsr.setFcbh(crf.get(i).getFcbh()); // 房产编号
				nsr.setNsrlx("100000010");// 纳税人类型 个人
				nsr.setNsrxm(crf.get(i).getXm()); // 购买方姓名
				nsr.setNsrzjlxDm(crf.get(i).getZjlx());// 证件类型
				nsr.setNsrzjhm(crf.get(i).getZjhm());// 证件号码
				nsr.setDh(crf.get(i).getDh());// 联系电话
				nsr.setDz(crf.get(i).getDz());// 地址
				nsr.setGjDm(crf.get(i).getGj());// 国籍
				nsr.setGyrbj(crf.get(i).getGyrbj());// 共有人标记
				nsr.setJyfe(crf.get(i).getJyfe());// 交易份额
				nsr.setSzfe(crf.get(i).getSzfe()); // 所占份额
				nsr.setDjxh(crf.get(i).getDjxh());// 登记序号
				nsr.setClr(crf.get(i).getClr());
				nsr.setMmfbj("0");// 设置买方标记 卖0 买1
				nsr.setLrsj(new Date());
				list.add(nsr);
			}
		}
		
		result.put("nsr_list", list);
		return result;
	}

	public Zjxx getZjxx(CLFXXCJRequest clfxxcjrequest, String uuid) {
		Zjxx zjxx = new Zjxx();
		zjxx.setZjId(uuid);// 中介ID
		zjxx.setZjmc(clfxxcjrequest.getZjmc());// 中介名称
		zjxx.setNsrsbh("");// 纳税人识别号（税务部门中介id）
		zjxx.setSfqy("1");// 是否启用（0为启用 1为不启用）
		return zjxx;
	}
	
	public Zjxx getDbgs(ZLFXXCJRequest zlfxxcjrequest, String uuid) {
		Zjxx zjxx = new Zjxx();
		zjxx.setZjId(uuid);// 中介ID
		zjxx.setZjmc(zlfxxcjrequest.getDbgsmc());// 中介名称
		zjxx.setNsrsbh(zlfxxcjrequest.getDbgsnsrsbh());// 纳税人识别号（税务部门中介id）
		zjxx.setSfqy("1");// 是否启用（0为启用 1为不启用）
		return zjxx;
	}

	public List<NsrJtcy> getNsrJtcy(CLFXXCJRequest clfxxcjrequest, String crfxxId, String srfxxId) {
		List<CrfxxJtcy> crfxxJtcylb = clfxxcjrequest.getCrfxxJtcylb();
		List<SrfxxJtcy> srfxxJtcylb = clfxxcjrequest.getSrfxxJtcylb();

	
			List<NsrJtcy> nsrjtcylb = new ArrayList<NsrJtcy>();
			if (crfxxJtcylb!=null&&crfxxJtcylb.size() > 0) {
				for (CrfxxJtcy crfxxJtcy : crfxxJtcylb) {
					NsrJtcy nsrJtcy = new NsrJtcy();
					nsrJtcy.setNsrId(crfxxId);
					nsrJtcy.setBz(crfxxJtcy.getBz());
					nsrJtcy.setGx(crfxxJtcy.getGx());
					nsrJtcy.setJzd(crfxxJtcy.getJzd());
					nsrJtcy.setXm(crfxxJtcy.getXm());
					nsrJtcy.setZjhm(crfxxJtcy.getZjhm());
					nsrjtcylb.add(nsrJtcy);
				}
			}

			if (srfxxJtcylb!=null&&srfxxJtcylb.size() > 0) {
				for (SrfxxJtcy srfxxJtcy : srfxxJtcylb) {
					NsrJtcy nsrJtcy = new NsrJtcy();
					nsrJtcy.setNsrId(srfxxId);
					nsrJtcy.setBz(srfxxJtcy.getBz());
					nsrJtcy.setGx(srfxxJtcy.getGx());
					nsrJtcy.setJzd(srfxxJtcy.getJzd());
					nsrJtcy.setXm(srfxxJtcy.getXm());
					nsrJtcy.setZjhm(srfxxJtcy.getZjhm());
					nsrjtcylb.add(nsrJtcy);
				}
			}

			return nsrjtcylb;
		
	}

	/**
	 * ==============================================分割线========================
	 * ===========================================
	 ****/
	public TaxHouse getTaxHouse(ZLFXXCJRequest zlfxxcjrequest, String uuid) throws ParseException {
		TaxHouse th = new TaxHouse();
		th.setHouseId(uuid);// 房屋的uuid
		th.setBianma(zlfxxcjrequest.getCshdjzh());// 房产编码
		th.setHtbh(zlfxxcjrequest.getHtbh());// 合同编号
		th.setBarq(zlfxxcjrequest.getBarq()==null?new Date():new SimpleDateFormat("yyyy-MM-dd").parse(zlfxxcjrequest.getBarq()));// 备案日期
		th.setQuhua(zlfxxcjrequest.getSsd());// 转化为存量房系统的行政区划代码
		th.setZhuguan(zlfxxcjrequest.getSwjgbm());//换成swjgbm
		th.setXqmc(zlfxxcjrequest.getXqmc()==null?"":zlfxxcjrequest.getXqmc());// 小区名称
		th.setDizhi(zlfxxcjrequest.getFwwzdz());// 房屋完整地址
		th.setLoucengZong(zlfxxcjrequest.getZlc());
		th.setLouceng(zlfxxcjrequest.getSzlc());
		th.setMianji(BigDecimal.valueOf(zlfxxcjrequest.getJzmj()));
		th.setJiegou(zlfxxcjrequest.getJzjg().split(",")[0]);// 建筑结构
		th.setNiandai(zlfxxcjrequest.getJcnd());// 建筑年代
		th.setFwdh(zlfxxcjrequest.getFwdh());// 房屋栋号
		th.setDanyuan(zlfxxcjrequest.getDy());// 单元
		th.setFanghao(zlfxxcjrequest.getFanghao());// 房号
		th.setLuruTime(new Date());
		th.setYongtu(zlfxxcjrequest.getFwyt()==null?"":zlfxxcjrequest.getFwyt());
		th.setXinfang("1");// 是否新房，0存量房，1增量房
		th.setShenbao(zlfxxcjrequest.getHtje());//
		th.setFangfa("MARKET");// 目前默认市场法，以后功能扩充，则要修改这个默认值
		th.setQuanzhengTime(new Date());
		th.setChengshi(" ");// 城市 根据区划截取
		th.setChurang(" ");// 出让方
		th.setShourang(" ");// 受让方
		th.setCaozuo(" ");// 操作
		if("202".equals(zlfxxcjrequest.getQszyyt())){//存在住房非住房问题，按照房屋用途来判断
			th.setLeixingZong("SY");// 商业
			
		}else{
			th.setLeixingZong("ZZ");// 房产类型 默认住宅
		}
		
		th.setLeixingFen("ZZ000001");// 房产细类 默认独门独户院落	
		
		th.setLeixingFen("ZZ000001");// 房产细类 默认独门独户院落
		if(zlfxxcjrequest.getSsd()==null && "".equals(zlfxxcjrequest.getSsd())){
			th.setFenqu("WH-ZQT-1");
			th.setChengshi("WH");
		}else{
			th.setFenqu(zlfxxcjrequest.getSsd().substring(0,2)+"-ZQT-1");
			th.setChengshi(zlfxxcjrequest.getSsd().substring(0,2));
		}
		
		TaxArea area = ScUtil.getByKey("quhao_TaxAreaData", zlfxxcjrequest.getJdxz(), TaxArea.class);
		th.setJiedao(area==null?"":area.getQuwei());//==========================
		return th;
	}
 
	public Jyztb getJyztbInfo(ZLFXXCJRequest zlfxxcjrequest, String uuid, String channelid) {
		Jyztb jyztb = new Jyztb();
		jyztb.setTnmj((float) zlfxxcjrequest.getTnmj());// 套内面积
		jyztb.setQszydx(zlfxxcjrequest.getQszydx());// 权属转移对象
		jyztb.setQszyyt(zlfxxcjrequest.getQszyyt());// 权属转移用途
		jyztb.setQszylb(zlfxxcjrequest.getQszyfs());// 权属转移类别
		jyztb.setHtqdrq(DateUtil.parse(zlfxxcjrequest.getHtqdrq(), DateUtil.DATE_FORMAT));// 合同签订日期
		jyztb.setHtjg(zlfxxcjrequest.getHtje().floatValue());// 合同价格

		jyztb.setChannelId(channelid);// 渠道id
		jyztb.setFcxxId(uuid);// 房产uuid
		jyztb.setHzzsse(zlfxxcjrequest.getZzsse()==null?"0":zlfxxcjrequest.getZzsse()); //含增值税税额
		jyztb.setBhzzsse(zlfxxcjrequest.getBhzzsje()==null?"0":zlfxxcjrequest.getBhzzsje()); //不含增值税税额
		jyztb.setJyId(uuid);// 设置交易id和房产id一样
		jyztb.setJyzt(Fcjyzt.ZDSHZ.getFcjyztNo());// 保存后把状态设置为自动审核中
		jyztb.setLrsj(new Date());// 设置为当前时间
		jyztb.setXzqhDm(zlfxxcjrequest.getXzqhDm());// 把金三的行政区划保存到这里
		jyztb.setAcceptcode(zlfxxcjrequest.getAcceptcode()==null?"":zlfxxcjrequest.getAcceptcode());
		jyztb.setFwnm(zlfxxcjrequest.getJzjg().split(",")[1]);//房屋内码和建筑建构拼凑在一起
		jyztb.setZjgsbm(zlfxxcjrequest.getDbgsnsrsbh()==null?"":zlfxxcjrequest.getDbgsnsrsbh().substring(0, zlfxxcjrequest.getDbgsnsrsbh().indexOf("_")));
		jyztb.setZjysbh(zlfxxcjrequest.getDbgsnsrsbh()==null?"":zlfxxcjrequest.getDbgsnsrsbh());
		return jyztb;
	}

	public int getTpfj(List<Fctpfj> list, String uuid) throws DbOprationException {
		return tpfjService.isInDb(list); // i=0表示list在数据库都存在
	}

	public List<Jyskb> saveYhjm(ZLFXXCJRequest zlfxxcjrequest, String uuid, Map<String, Object> nsridMap)
			throws DbOprationException {
		List<Srfyh> srf = zlfxxcjrequest.getSrfyhlb();
		List<Jyskb> list = new ArrayList<Jyskb>();
		if (srf != null && srf.size() > 0) {
			for (int i = 0; i < srf.size(); i++) {
				Jspz jspz = jspzService.getBYJmxzdm(srf.get(i).getYhdm());
				double sl = jspz.getSl();
				
				Jyskb jyskb = new Jyskb();
				jyskb.setFcxxId(uuid);
				jyskb.setSkbid(UUID.randomUUID().toString().replaceAll("-", ""));
				jyskb.setClfzlfbz("1");// 0为存量房标记
				jyskb.setMmfbz("1");
				jyskb.setQybz("2");
				jyskb.setJmxzdm(jspz.getJmxzDm());
				
				jyskb.setSl((float) sl);
				jyskb.setNsrid((String)nsridMap.get("srf_nsrid"));
				jyskb.setZsxmDm(jspz.getZsxmDm());
				jyskb.setZxpmDm(jspz.getZspmDm());
				jyskb.setZszmDm(jspz.getZszmDm());
				//计算税额
				BigDecimal se = zlfxxcjrequest.getHtje().multiply(BigDecimal.valueOf(sl));
				jyskb.setSe(se.doubleValue());
				jyskb.setJyfe(1.0f);
				jyskb.setJsje(zlfxxcjrequest.getHtje().doubleValue());
				
				list.add(jyskb);
			}
		}

		return list;
	}

	public Map<String, Object> getNsr(ZLFXXCJRequest zlfxxcjrequest, String uuid, String kfsmc) {
		Map<String, Object> result = new HashMap<>();
		
		List<Srfxx> srf = zlfxxcjrequest.getSrfxxlb();
		List<Nsr> list = new ArrayList<Nsr>();
		if (srf != null) {
			for (int i = 0; i < srf.size(); i++) {
				String nsrid = UUID.randomUUID().toString().replaceAll("-", "");
				if("0".equals(srf.get(i).getGyrbj())){
					result.put("srf_nsrid", nsrid);
				}
				
				Nsr nsr = new Nsr();
				nsr.setFcxxId(uuid);
				nsr.setNsrId(nsrid);
				nsr.setNsrxm(srf.get(i).getXm());
				nsr.setNsrlx("100000010");
				nsr.setNsrzjlxDm("201");
				nsr.setNsrzjhm(srf.get(i).getZjhm());
				nsr.setMmfbj("1");//买方
				nsr.setDh(srf.get(i).getDh());
				nsr.setDz(srf.get(i).getDz());
				nsr.setSzfe(srf.get(i).getSzfe());
				nsr.setGyrbj(srf.get(i).getGyrbj());
				nsr.setClr(srf.get(i).getClr());
				nsr.setLrsj(new Date());
				list.add(nsr);
			}
		}
		/*if (kfsmc != null) {
			Nsr nsr = new Nsr();
			nsr.setFcxxId(uuid);
			nsr.setNsrId(UUID.randomUUID().toString().replaceAll("-", ""));
			nsr.setNsrxm(kfsmc);
			nsr.setNsrlx("100000020");
			nsr.setNsrzjlxDm("100");
			nsr.setNsrzjhm("");
			nsr.setMmfbj("0");//买方
			nsr.setClr("0");
			nsr.setLrsj(new Date());
			list.add(nsr);
		}*/
		
		result.put("nsr_list", list);
		return result;
	}

	public List<NsrJtcy> getNsrJtcy(ZLFXXCJRequest zlfxxcjRequest, List<Nsr> list) {
		List<com.ynding.ws.param2.taxML.NsrJtcy> nsrJtcyList = zlfxxcjRequest.getSrfjtcylb();
		List<NsrJtcy> nsrjtcy = new ArrayList<>();
		if (nsrJtcyList != null && nsrJtcyList.size() > 0) {
			for (int i = 0; i < nsrJtcyList.size(); i++) {
				NsrJtcy jtcy = new NsrJtcy();
				jtcy.setNsrId(list.get(0).getNsrId());// 纳税人id
				jtcy.setXm(nsrJtcyList.get(i).getXm());// 纳税人姓名
				jtcy.setZjhm(nsrJtcyList.get(i).getZjhm());// 纳税人证件号码
				jtcy.setGx(nsrJtcyList.get(i).getGx());// 纳税人关系
				jtcy.setJzd(nsrJtcyList.get(i).getJzd());// 纳税人居住地
				jtcy.setBz(nsrJtcyList.get(i).getBz());// 备注
				jtcy.setYxbj("0");
				nsrjtcy.add(jtcy);
			}
		}
		return nsrjtcy;
	}

}
