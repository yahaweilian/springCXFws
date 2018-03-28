package com.ynding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.JyskbDao;
import com.ynding.entity.Jyskb;
import com.ynding.exception.DbOprationException;

/*****
 * 交易税款表服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 **/
@Service("jyskbService")
public class JyskbService {

	@Autowired
	JyskbDao jyskbDao;

	public int addJyskbInfo(List<Jyskb> jyskb) throws DbOprationException {// 添加房产信息
		return jyskbDao.batchAdd(jyskb);
	}

	public List<Jyskb> getJyskbList(String uuid) {
		Map<String, Object> params = new HashMap<>();
		params.put("fcxxId", uuid);
		return jyskbDao.getList(params);
	}

	public List<Jyskb> getJyskbListlb(String uuid) {
		Map<String, Object> params = new HashMap<>();
		params.put("fcxxId", uuid);
		try {
			return jyskbDao.getJyskbLists(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Jyskb> getZzsList(String uuid, String zhsdm) {
		Map<String, Object> params = new HashMap<>();
		params.put("fcxxId", uuid);
		params.put("zsxmdm", zhsdm);
		try {
			return jyskbDao.getZzsList(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
