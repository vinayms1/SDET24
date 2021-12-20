package com.vtiger.genericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtiles {
	/**
	 * Get the data from properties file
	 * @param key
	 * @return value which is present in the properties file
	 * @throws Throwable
	 */
	public String getvalues(String key) throws Throwable {
	FileInputStream fis=new FileInputStream("C:\\Users\\Vinay\\eclipse-workspace\\SDET24\\src\\test\\resources\\data\\commondata.properties");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	}
	
	
	

} 
