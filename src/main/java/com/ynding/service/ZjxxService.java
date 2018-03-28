package com.ynding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.ZyxxDao;
import com.ynding.entity.Zjxx;
import com.ynding.exception.DbOprationException;

@Service("zjxxService")
public class ZjxxService {

	@Autowired
	ZyxxDao zyxxDao;

	public int addZjxx(Zjxx zjxx) throws DbOprationException {
		return zyxxDao.add(zjxx);

	}

}
