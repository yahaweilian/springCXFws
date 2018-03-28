package com.ynding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.BwrzDao;
import com.ynding.entity.Bwrz;
import com.ynding.exception.DbOprationException;

@Service("bwrzService")
public class BwrzService {
	
	@Autowired
	BwrzDao bwrzDao;

	public int  insertBwrz(Bwrz bwrz) throws DbOprationException {//插入报文日志

	return	bwrzDao.add(bwrz);
	}

}
