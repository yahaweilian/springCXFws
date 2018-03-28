package com.ynding.dao;

import java.util.List;
import java.util.Map;

import com.ynding.entity.Nsr;


public interface NsrDao extends BaseDao<Nsr> {
	List<Nsr> getNseLists(Map map);
	Nsr getNsrClr(Map map);
}
