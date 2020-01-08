package com.orgname.rough;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d.toString().replace(":", "_").replace(" ", "_"));
		
		String screenshotName="error"+d.toString().replace(":", "_").replace(" ", "_")+".png";

		
		String screenShotPath=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\";
		
		System.out.println(screenShotPath+screenshotName);
		
	}

}
