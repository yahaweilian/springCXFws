package com.ynding.dao;

import java.util.Map;

import com.ynding.entity.Jyztb;


public interface JyztbDao extends BaseDao<Jyztb>{
int getwsjy(Map<String, Object> params);
int updateFpkpbj(Map<String, Object> params);
}
