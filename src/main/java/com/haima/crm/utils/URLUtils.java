package com.haima.crm.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


/**
 * @author jinxian.dou
 *
 */
public class URLUtils {
	private static ResourceLoader resourceLoader = new DefaultResourceLoader();
	
	/**
	 * 利用ResourceLoader取得excel路径。
	 * @param fileName
	 * @return
	 */
	public static String getExcelFilePath(String fileName){
		Resource path = resourceLoader.getResource("classpath:" + fileName);//格式見getResource注释
		//Resource path = resourceLoader.getResource("/WEB-INF/classes/report/" + fileName);//也可
		try {
			return path.getURI().getPath();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 取得class path根路径
	 * @return
	 */
	public static String getCLassPath(){
		String classpath = null;
		try {
			URL url = new Object(){}.getClass().getResource("/properties/log4j.properties");
			classpath = (new File(url.getFile())).getParentFile().getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classpath;
	}
	
	
	/** 
	 * @param cnStr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
    public static String encodeString(String cnStr) throws UnsupportedEncodingException {
        return URLEncoder.encode(cnStr, "UTF-8");
    }
    
    /** 
	 * @param cnStr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
    public static String decodeString(String cnStr) throws UnsupportedEncodingException {
    	return URLDecoder.decode(cnStr, "UTF-8");
    }
}
