package com.ynding.jaxb2;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * xml到bean的转换
 * @author zzy
 * 	2016.06
 * @version 1.0
 */
@SuppressWarnings("restriction")
public class XmlBean {
	
	    /** 
	     * JavaBean转换成xml 
	     * 默认编码UTF-8 
	     * @param obj 
	     * @return  
	     */  
	    public static String bean2Xml(Object obj) {  
	        return bean2Xml(obj, "UTF-8");  
	    }  
	    
	    @SuppressWarnings("rawtypes")
		public static String bean2Xml(Object obj,Class... classes) {  
	        return bean2Xml(obj, "UTF-8",classes);  
	    } 
	  
	    /** 
	     * JavaBean转换成xml 
	     * @param obj 生成xml的bean对象
	     * @param encoding  
	     * @return 生成的xml
	     */  
	    public static String bean2Xml(Object obj,String encoding){
	    	return bean2Xml(obj,encoding,null);
	    }
	    
	    @SuppressWarnings({ "rawtypes" })
		public static String bean2Xml(Object obj,String encoding, Class... classes ) {  
	        String result = null;  
	        try {
				Class[] theclasses = null ;
	        	if(classes!=null){
	        		theclasses = concatAll(new Class[]{obj.getClass()},classes);
	        	}else{
	        		theclasses =  new Class[1];
		        	theclasses[0] = obj.getClass();
	        	}
	        	
	        	
	        	//==============================================
	            // get an Apache XMLSerializer configured to generate CDATA
	            XMLSerializer serializer = getXMLSerializer();
	            StringWriter writer = new StringWriter();  
	            serializer.setOutputCharStream(writer);
	            // marshal using the Apache XMLSerializer
	            SAXResult saxr = new SAXResult( serializer.asContentHandler() );

	            JAXBContext context = JAXBContext.newInstance(theclasses); 
	            Marshaller marshaller = context.createMarshaller();  
	            marshaller.marshal(obj, saxr); 
	            serializer.setOutputByteStream(System.out);
	            result = writer.toString();  
	        	
	        	//=================================================
//	            JAXBContext context = JAXBContext.newInstance(theclasses);  
//	            Marshaller marshaller = context.createMarshaller();  
//	            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
//	            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
//	  
//	            StringWriter writer = new StringWriter();  
//	            marshaller.marshal(obj, writer);  
	            result = writer.toString(); 
	        } catch (Exception e) {  
	            e.printStackTrace();
	        }
	  
	        return result; 
	    }  
	  
	  

		
	    public static <T> T xml2Bean(String xml, Class<T> c) { 
	    	return xml2Bean(xml, c, null);
	    }
	    /** 
	     * xml转换成JavaBean 
	     * @param xml 
	     * @param c 
	     * @return 
	     */  
	    @SuppressWarnings({ "unchecked", "rawtypes"})
		public static <T> T xml2Bean(String xml, Class<T> c,Class...classes ) {  
	        T t = null;
	        try {
				Class[] theclasses = null ;
	        	if(classes!=null){
	        		theclasses = concatAll(new Class[]{c},classes);
	        	}else{
	        		theclasses =  new Class[1];
		        	theclasses[0] = c;
	        	}
	            JAXBContext context = JAXBContext.newInstance(theclasses);  
	        	//JAXBContext context = JAXBContext.newInstance(c);
	            Unmarshaller unmarshaller = context.createUnmarshaller(); 
	            StringReader reader = new StringReader(xml); 
	            t = (T) unmarshaller.unmarshal(reader);  
	            //t = (T) unmarshaller.unmarshal(new File("test.xml"));
	        } catch (JAXBException e) {  
	            e.printStackTrace();  
	        }
	        return t; 
	    }
	    
	    
	@SuppressWarnings({ "rawtypes" })
	public static Class[] concatAll(Class[] first, Class[]... classes) {
		int totalLength = first.length;
		
		for ( Class[] array : classes) {
			totalLength += array.length;
		}
		Class[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (Class[] array : classes) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}
	
	private static XMLSerializer getXMLSerializer() {
        // configure an OutputFormat to handle CDATA
        OutputFormat of = new OutputFormat();

        // specify which of your elements you want to be handled as CDATA.
        // The use of the '^' between the namespaceURI and the localname
        // seems to be an implementation detail of the xerces code.
        // When processing xml that doesn't use namespaces, simply omit the
        // namespace prefix as shown in the third CDataElement below.
        of.setCDataElements(
        		new String[] { 
        				"^body" 
        				});       

        // set any other options you'd like
        of.setPreserveSpace(true);
        of.setIndenting(true);
        //StringWriter writer = new StringWriter();
        // create the serializer
        XMLSerializer serializer = new XMLSerializer(of);
        //serializer.setOutputFormat(format);
        //serializer.setOutputCharStream(writer);
        serializer.setOutputByteStream(System.out);
        
        return serializer;
    }
	
	
}
