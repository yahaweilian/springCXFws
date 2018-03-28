package com.ynding.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.NsrJtcyDao;
import com.ynding.entity.NsrJtcy;
import com.ynding.exception.DbOprationException;

/**
 * Created by wangdong on 2017/7/16.
 */
@Service("nsrJtcyService")
public class NsrJtcyService {

	@Autowired
	NsrJtcyDao nsrJtcyDao;

	public List<NsrJtcy> getNsrJecyList(Map map) {
		return nsrJtcyDao.getList(map);
	}

	public int addNsrJtcyInfo(List<NsrJtcy> nsrJtcy) throws DbOprationException {// 添加房产信息
		return nsrJtcyDao.batchAdd(nsrJtcy);
	}
}
