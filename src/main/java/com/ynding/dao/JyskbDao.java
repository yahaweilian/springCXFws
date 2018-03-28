package com.ynding.dao;

import java.util.List;
import java.util.Map;

import com.ynding.entity.Jyskb;


public interface JyskbDao extends BaseDao<Jyskb> {
	List<Jyskb> getJyskbLists(Map map);
	List<Jyskb> getZzsList(Map map);
}
