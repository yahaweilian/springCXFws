package com.ynding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.NsrDao;
import com.ynding.entity.Nsr;
import com.ynding.exception.DbOprationException;

/*****
 * 纳税人服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 **/
@Service("nsrService")
public class NsrService {

	@Autowired
	NsrDao nsrDao;

	public int addNsrInfo(List<Nsr> nsr) throws DbOprationException {// 添加房产信息
		return nsrDao.batchAdd(nsr);
	}

	public List<Nsr> getNsrList(Map map) {
		return nsrDao.getList(map);
	}

	public List<Nsr> getNsrs(Map map) {
		return nsrDao.getNseLists(map);
	}

	public List<Nsr> getNsrList(String uuid) {
		Map<String, Object> params = new HashMap<>();
		params.put("fwxxId", uuid);
		return nsrDao.getList(params);
	}

	public Nsr getNsrClr(String nsrxm, String nsrzjhm) {
		Map<String, Object> params = new HashMap<>();
		params.put("nsrxm", nsrxm);
		params.put("nsrzjhm", nsrzjhm);
		try {
			return nsrDao.getNsrClr(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
