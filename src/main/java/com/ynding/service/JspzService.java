package com.ynding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.JspzDao;
import com.ynding.entity.Jspz;
import com.ynding.exception.DbOprationException;

@Service("jspzService")
public class JspzService {

	@Autowired
	JspzDao jspzDao;

	public List<Jspz> getQyList() throws DbOprationException {
		Map<String, Object> params = new HashMap<>();
		params.put("sfqy", "Y");
		return jspzDao.getList(params);
		// return null;
		// return <Jspz> super.getList();
	}

	public Jspz getBYJmxzdm(String yhdm) throws DbOprationException {
		try {
			return jspzDao.getByJmxzdm(yhdm);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
	}

}
