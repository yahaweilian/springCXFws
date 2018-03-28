package com.ynding.service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.ynding.dao.BaseDao;
import com.ynding.exception.DbOprationException;


/**
 * 
 * @author zzy
 * 2016.07
 * @since 1.8
 * @param <E>
 */
//@Service
//@Component
public abstract class BaseService<E>
		//implements  BaseDao<T>
{
	protected static final Logger logger =Logger.getLogger(BaseService.class);
	
	@Autowired
	protected SqlSessionFactoryBean sqlSessionFactoryBean;
	@Autowired
	protected DataSource mds;
	
	protected MapperFactoryBean<E> mapperfb;
	protected Class<E> mapperInterface ;
	//protected SQLConstant constant;
	
	//public BaseDao<T> baseDao;
	
	 /**
     * 获取一个新的查询参数对象
     *
     * @return 新的查询参数对象
     */
    protected final Map<String, Object> getNewParamMap() {
        return new HashMap<String, Object>();
    }
	
	@SuppressWarnings("unchecked")
	@Autowired
	public BaseService(SqlSessionFactoryBean  sqlSessionFactoryBean){
		mapperInterface = (Class<E>) ((ParameterizedType) this.getClass()  
	            .getGenericSuperclass()).getActualTypeArguments()[0]; 
		this.sqlSessionFactoryBean = sqlSessionFactoryBean;
	}
	
	@SuppressWarnings("unchecked")
	protected void  initMFB() throws Exception {
		mapperfb =  new MapperFactoryBean<E>();
    	mapperfb.setMapperInterface(mapperInterface);
    	if(this.sqlSessionFactoryBean!=null){
    		mapperfb.setSqlSessionFactory(this.sqlSessionFactoryBean.getObject());
    	}
    	
    	//本句没有对应的SQL文件  会报错
    	//baseDao = (BaseDao<T>)this.mapperfb.getObject();
	}
	/*
	public static <T> String getDataGridJson(List<T> j,Page p){
		DataGridJson<T> dgj = new DataGridJson<T>(j);
		dgj.setTotal(p.getTotalCount());
		return com.alibaba.fastjson.JSON.toJSONString(dgj);
	}
	
	public static String getJson(List<?> j){
		return com.alibaba.fastjson.JSON.toJSONString(j);
	}
	
	public static String getJson(Object o){
		return com.alibaba.fastjson.JSON.toJSONString(o);
	}
	
	public static <T> String getDataGridJson(List<T> j,List<T> f){
		DataGridJson<T> dgj = new DataGridJson<T>(j);
		dgj.setFooter(f);
		return com.alibaba.fastjson.JSONArray.toJSONString(dgj);
		//return com.alibaba.fastjson.JSON.toJSONString(dgj);
	}
	
	public static <T> String getDataGridJson(List<T> j){
		DataGridJson<T> dgj = new DataGridJson<T>(j);
		return com.alibaba.fastjson.JSONArray.toJSONString(dgj);
		//return com.alibaba.fastjson.JSON.toJSONString(dgj);
	}
	
	public static String getTreeJson(IEUITree t){
		String ret = com.alibaba.fastjson.JSON.toJSONString(t);
		return ret.length()>0 ? "["+ret+"]" : "";
	}
	
	public static String getTreeListJson(List<IEUITree> t){
		return  com.alibaba.fastjson.JSON.toJSONString(t);
	}
	
	public static <T> List<IEUITree> toEUITree(List<T> l){
		List<IEUITree> ret = null;
		if(l!=null && l.size()>0){			
			Object o = l.get(0);
			if(o instanceof IEUITree){
				ret = new ArrayList<IEUITree>();
				for(Object a : l){
					ret.add((IEUITree)a);
				}
			}
		}
		return ret;
	}
	
	/**
	 * EUITreeList转换成普通List
	 * @param j
	 * @return
	 *//*
	public static <T> List<T>  EUITreeToList(List<IEUITree> j){
		List<T> l = null;
		if(j!=null){
			l=new ArrayList<T>();
			for(IEUITree a: j){
				l.add((T)a);
				if(a.getChildren()!=null){
					List<T> l_c = EUITreeToList(a.getChildren());
					if(l_c!=null){
						l.addAll(l_c);
					}
				}
			}
		}
		return l;
	}
	
	*//**
	 * 生成 装载EasyUI Tree的Json串
	 * @author zzy
	 * @param j 实现了IEUITree接口的实体类的List
	 * @return 装载EasyUI Tree的Json串
	 *//*
	public static <T> String getTreeJson(List<T> j){
		return getJson(
				getEUITreeList(toEUITree(j))
				);				
	}
	
	*//**
	 * 生成 装载EasyUI Tree的Json串
	 * @author zzy
	 * @param j 实现了IEUITree接口的实体类的List
	 * @return 装载EasyUI Tree的Json串
	 *//*
	public static <T> String getTreeJson(List<T> j,String parentId){
		return getJson(
				getEUITreeList(toEUITree(j),parentId)
				);				
	}
	*/

	/**
	 * 将List加载到tree中
	 * @param source 需要加载的List
	 * @return
	 *//*
	public static List<IEUITree> getEUITreeList(List<IEUITree> source){
		List<IEUITree> ret = new ArrayList<IEUITree>();
		if(source==null || source.size()==0){
			ret =  null;
		}
		for(IEUITree a : source){
			if(a.getParent()==null || a.getParent().equals("") ||  a.getParent().equals("0")){
				a = getEUITree(a,source);
				ret.add(a);
			}
		}
		return ret;
	}
	
	*/
	/**
	 * 将List加载到tree中
	 * @param source 需要加载的List
	 * @return
	 *//*
	public static List<IEUITree> getEUITreeList(List<IEUITree> source,String rootId){
		List<IEUITree> ret = new ArrayList<IEUITree>();
		if(source==null || source.size()==0){
			ret =  null;
		}
		for(IEUITree a : source){
			if(a.getParent()==null || a.getParent().equals("") ||  a.getParent().equals("0") || a.getId().equals(rootId)){
				a = getEUITree(a,source);
				ret.add(a);
			}
		}
		return ret;
	}
	
	/**
	 * 
	 * @param p 根节点
	 * @param source 加载在根节点下的其他内容
	 * @return
	 *//*
	public static IEUITree getEUITree(IEUITree p, List<IEUITree> source){
		if(p==null){
			return null;
		}else{
			for(IEUITree a : source){
				if(a.getParent()!=null && a.getParent().equals(p.getId())){
					p.getChildren().add(a);
					List<IEUITree> s_c = new ArrayList<IEUITree>( source);
					s_c.remove(a);
					getEUITree(a,s_c);
				}
			}
			return p;
		}
	}*/
	
	protected Map<String, Object> newParamsMap(int initialCapacity){
    	return new HashMap<String, Object>(initialCapacity);
    }
    protected Map<String, Object> newParamsMap(){
    	return new HashMap<String, Object>();
    }

	/*@Override
	public List<T> getList() {
		try {
			return 	((BaseDao)this.mapperfb.getObject()).getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/***********BaseDao里基本方法的实现，相应的sql文件里必须有对应的sql，否则调用时会报错
     * @throws DbOprationException
     * @throws Exception *************/


    public <T> List<T> getList() throws DbOprationException {
    	try {
			return 	((BaseDao)this.mapperfb.getObject()).getList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> List<T> getList(Map<String,Object> params) throws DbOprationException {
    	try {
			return 	((BaseDao)this.mapperfb.getObject()).getList(params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> List<T> getListByName(String name) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).getListByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public Long getCount(Map<String,Object> params) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).getCount(params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    
    public <T> T getObject(Map<String,Object> params) throws DbOprationException {
    	try {
			return (T) ((BaseDao)this.mapperfb.getObject()).getObject(params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> T getObjectById(Integer id) throws DbOprationException {
    	try {
			return (T) ((BaseDao)this.mapperfb.getObject()).getObjectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> T getObjectById(Long id) throws DbOprationException {
    	try {
			return (T) ((BaseDao)this.mapperfb.getObject()).getObjectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> T getObjectById(String id) throws DbOprationException {
    	try {
    		return (T) ((BaseDao)this.mapperfb.getObject()).getObjectById(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new DbOprationException();
    	}
    }
    public <T> T getObjectByBm(Object bm) throws DbOprationException {
    	try {
			return (T) ((BaseDao)this.mapperfb.getObject()).getObjectByBm(bm);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> T getObjectByName(String name) throws DbOprationException {
    	try {
			return (T) ((BaseDao)this.mapperfb.getObject()).getObjectByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    
    public <T> int add(T t) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).add(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    
  
    
    
    public <T> int batchAdd(List<T> lt) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).batchAdd(lt);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    
    public <T> int delete(T t) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).delete(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> int delete(Integer id) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> int delete(Long id) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> int delete(String id) throws DbOprationException, Exception {
    	try {
    		return ((BaseDao)this.mapperfb.getObject()).delete(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new DbOprationException();
    	}
    }
    public <T> int batchDelete(List<T> lt) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).batchDelete(lt);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> int update(T t) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).update(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }
    public <T> int batchUpdate(List<T> lt) throws DbOprationException {
    	try {
			return ((BaseDao)this.mapperfb.getObject()).batchAdd(lt);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbOprationException();
		}
    }


	/*public <T> Page<T> queryForList(String listStatId, String countStatId,
									Page<T> page) {
		logger.debug("params :" + page.toMap());
		if (page.getTotalCount() == 0) {
			//DefaultResultHandler drh = new DefaultResultHandler();
			try {

				this.sqlSessionFactoryBean.getObject().openSession(false);
				SqlSession s = this.sqlSessionFactoryBean.getObject().openSession();
				int c = s.selectOne(countStatId,page.toMap());
				//this.sqlSessionFactoryBean.getObject().openSession().select(countStatId,page.toMap(),drh);
				page.count(c);

				if (page.getTotalCount() > 0) {
					List<T> ls =  s.selectList(countStatId,page.toMap());
					page.setData(ls);
					//page.setData(getSqlMapClientTemplate().queryForList(listStatId,
					//	page.toMap(), page.getSkip(), page.getNumPerPage()));
				}
			} catch (Exception e) {
				logger.debug(e);
				e.printStackTrace();
			}
			//page.count(queryForCount(countStatId, page.toMap()));
		}
		return page;
	}*/
    
}
