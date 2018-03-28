package com.ynding.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

/**
 * ServletContext
 * @author fxz
 *
 */
public class ScUtil {
	private static ServletContext servletContext;

	public static Object getByKey(String classify, String key){
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>)servletContext.getAttribute(classify);
		
		if(map == null){
			return null;
		}
		
		return map.get(key);
	}
	
	/**
	 * 
	 * @param classify 
	 * @param key
	 * @param t 意向类class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getByKey(String classify, String key, Class<T> t) {
		Map<String, Object> map = (Map<String, Object>)servletContext.getAttribute(classify);
		
		if(map == null){
			return null;
		}
		
		return (T) map.get(key);
	}
	
	/**
	 * 获取数据返回list
	 * 
	 * ***/
	@SuppressWarnings("unchecked")
	public static <T> List<T> getByList(String classify, Class<T> t) {
		 List<T> list = (List<T>)servletContext.getAttribute(classify);
		
		if(list == null){
			return null;
		}
		return list;
	}
	
	
	public static ServletContext getSc() {
        return servletContext;
    }
    public static void setSc(ServletContext sc) {
    	servletContext = sc;
    }
}
