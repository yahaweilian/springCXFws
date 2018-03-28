package com.ynding.dao;

import java.util.List;
import java.util.Map;

/**
 * 说明:
 * 1、返回数据类型由dao中的接口和map.xml文件共同决定。另外，不论是返回单一对象还是对象列表，***map.xml中的配置都是一样的，都是resultMap=”***Map”或resultType=“* .* .*”类型.
 * 2、每一次mybatis从数据库中select数据之后，都会检查数据条数和dao中定义的返回值是否匹配。
 * 3、若返回一条数据，dao中定义的返回值是一个对象或对象的List列表，则可以正常匹配，将查询的数据按照dao中定义的返回值存放。
 * 4、若返回多条数据，dao中定义的返回值是一个对象，则无法将多条数据映射为一个对象，此时mybatis报错
 * 5、insert、update、delete默认返回的就是int型数值，受影响的条数
 * 
 * @author zzy
 * 2016.06
 */
public interface BaseDao<T> {
	/**
	 * 查询List
	 */
	List<T> getList(); 							//获取所有对象
	List<T> getListByName(String name); 		//名称模糊查询 获取List
	List<T> getList(Map<String, Object> params);

	Long getCount(Map<String, Object> params);

	/**
	 * 查询单个对象
	 */
	T getObject(Map<String, Object> params); //传入Map条件 获取单个对象
	T getObjectById(Integer id); 			//通过主键获取对象
	T getObjectById(Long id);				//通过主键获取对象
	T getObjectById(String id);				//通过主键获取对象
	T getObjectByBm(Object bm);				//通过编码查询 获取对象
	T getObjectByName(String name);			//名称查询 获取对象

	/**
	 * 增加
	 *
	 * @return 受影响的条数
	 */
	int add(T t);							//插入单个对象
	int batchAdd(List<T> lt);				//批量增加多条记录

	/**
	 * 删除单条记录
	 *
	 * @return 受影响的条数
	 */
	int delete(T t);				//删除单条记录
	int delete(Integer id);			//根据主键删除单条记录(参数Integer型)
	int delete(Long id);			//根据主键删除单条记录(参数Long型)
	int delete(String id);			//根据主键删除单条记录(参数String型)
	int batchDelete(List<T> lt);	//批量删除多条记录

	/**
	 * 修改
	 * @param params
	 */
	int update_dynamic(Map<String, Object> params);	//修改单条记录
	int update(T t);				//修改单条记录
	int batchUpdate(List<T> lt); 	//批量修改多条记录
}
