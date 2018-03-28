package com.ynding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.YjxxDao;
import com.ynding.entity.Yjxx;

/*****
 * 邮寄信息
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 **/
@Service("yjxxService")
public class YjxxService {

	@Autowired
	YjxxDao yjxxDao;

	public int addYjxxInfo(List<Yjxx> yjxx) {// 添加邮寄信息
		return yjxxDao.batchAdd(yjxx);
	}

}
