package com.orgname.rough;

import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws Exception {

		
		System.out.println(System.getProperty("user.dir"));
		Properties config = new Properties();
		Properties or = new Properties();
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\or.properties");
		or.load(fis);
		
		System.out.println(config.getProperty("browser"));
		
		System.out.println(or.getProperty("bmlBtn"));
		
		
		
	}

}
