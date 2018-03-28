package com.ynding.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@SuppressWarnings("all")
public class HttpClientUtil {
	    private static  CloseableHttpClient httpClient = HttpClients.createDefault();  
	    private static HttpGet httpGet;
	    private static CloseableHttpResponse response;
	    private static HttpEntity entity;
	    private static InputStream is;
	  
	/*
	 * 返回请求的JSON字符串    
	 */
	 public static String responseResquest(String url){
		 
      try {
        	   httpGet=new HttpGet(url);					
               response = httpClient.execute(httpGet);
               entity = response.getEntity(); 
               is=entity.getContent();
		  	   String result =IOUtils.toString(is,"UTF-8");
		  	   
			   return result;
			   
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		return null;	
	 }
	
	 public static String responseResquest1(String url) throws ClientProtocolException, IOException{
	        	   httpGet=new HttpGet(url);					
	               response = httpClient.execute(httpGet);
	               entity = response.getEntity(); 
	               is=entity.getContent();
			  	   String result =IOUtils.toString(is,"UTF-8");
				   return result;
		 }					
     

}
