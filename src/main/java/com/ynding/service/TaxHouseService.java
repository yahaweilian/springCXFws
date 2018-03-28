package com.ynding.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.TaxHouseDao;
import com.ynding.entity.TaxHouse;


/*****
 * 保存房产信息表
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 * **/
@Service("taxHouseService")
public class TaxHouseService  {

	
	/*public TaxHouseService(SqlSessionFactoryBean sqlSessionFactoryBean) {
		super(sqlSessionFactoryBean);
		try {
			initMFB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@Autowired
	TaxHouseDao taxHouseDao;
	
	public int addTaxHouseInfo(TaxHouse taxHouse) {//添加房产信息
		return taxHouseDao.add(taxHouse);
	}
	
	public int addTaxHouseObjectInfo(TaxHouse taxHouse) throws Exception {//添加房产信息
			return taxHouseDao.addObject(taxHouse);
	
	}
	
	
   public TaxHouse getTaxHouse(Map map){  //获取房产信息
    	return taxHouseDao.getObject(map);
}
   public Integer getCountByHtbh(Map<String, Object> params){
		try {
			return taxHouseDao.getCountByHtbh(params);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
