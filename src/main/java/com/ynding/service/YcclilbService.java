package com.ynding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.YcclilbDao;
import com.ynding.entity.Yccljlb;

/*****
 * 异常处理表服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-7
 **/
@Service("ycclilbService")
public class YcclilbService {

	@Autowired
	YcclilbDao ycclilbDao;

	public List<Yccljlb> getYcclilbList() {
		Map<String, Object> params = new HashMap<>();
		params.put("sdzt", "1");// 1为锁定状态

		return ycclilbDao.getList(params);
	}
}
