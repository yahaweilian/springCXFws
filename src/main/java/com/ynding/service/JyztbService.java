package com.ynding.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.JyztbDao;
import com.ynding.entity.Jyztb;
import com.ynding.exception.DbOprationException;

/*****
 * 交易状态表服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 **/
@Service("jyztbService")
public class JyztbService {

	@Autowired
	JyztbDao jyztbDao;

	public int addJyztbInfo(Jyztb jyztb) throws DbOprationException {// 添加房产信息
		return jyztbDao.add(jyztb);
	}

	public Jyztb getJyztb(Map map) {
		return jyztbDao.getObject(map);
	}

	public Jyztb getJyztbList(String uuid, String Channelid) {
		Map<String, Object> params = new HashMap<>();
		params.put("fcxxId", uuid);//
		params.put("channelId", Channelid);// 根据channel来判断渠道，不是同一渠道的不能办理
		return (Jyztb) jyztbDao.getList(params).get(0);
	}

	public int addBdcxxInfo(Map<String, Object> params) throws Exception {
		return jyztbDao.update_dynamic(params);
	}

	public int getwsjy(String fwuuid) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("fwuuid", fwuuid);
		return jyztbDao.getwsjy(params);
	}

	public int updateFpkpbj(String fwuuid) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("fwuuid", fwuuid);
		return jyztbDao.updateFpkpbj(params);
	}
}
