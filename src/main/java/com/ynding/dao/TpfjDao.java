package com.ynding.dao;

import java.util.List;
import java.util.Map;

import com.ynding.entity.Tpfj;
import com.ynding.ws.param2.taxML.Fctpfj;




public interface TpfjDao extends BaseDao<Tpfj> {
	
	Integer getCountByFctpid(Map<String, Object> map);
	void updateFctpfj(List<Fctpfj> list);
}
