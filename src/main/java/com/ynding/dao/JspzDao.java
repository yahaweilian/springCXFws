package com.ynding.dao;

import com.ynding.entity.Jspz;

public interface JspzDao extends BaseDao<Jspz> {

	//public Long count(Map<String, Object> map);
	//public List<Jspz> findAllFcXtJspz(Map<String, Object> map);
	Jspz getByJmxzdm(String uuid);

}
