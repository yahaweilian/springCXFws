package com.ynding.dao;

import java.util.Map;

import com.ynding.entity.TaxHouse;


public interface TaxHouseDao extends BaseDao<TaxHouse> {

	TaxHouse getByHtbh(Map<String, Object> params);
	int addObject(TaxHouse taxHouse);
	int getCountByHtbh(Map<String, Object> params);
}
