package com.bingsum.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil {
	private static Properties props;
	static{
		  try {
		   props = PropertiesLoaderUtils.loadAllProperties("userId.properties");
		  } catch (IOException e) {
		  }
	}
	
	public static String loadAttribute(String key){
		return props.getProperty(key);
	}
}
