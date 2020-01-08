package com.orgname.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.orgname.base.TestBase;

public class TestUtil extends TestBase {

	public static String screenShotPath;
	public static String screenshotName;
//	public static String screenshotName;

	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		screenshotName = "error" + d.toString().replace(":", "_").replace(" ", "_") + ".png";

		screenShotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\";

		FileUtils.copyFile(scrFile, new File(
				System.getProperty("user.dir") + "\\" + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

//   	WITHOUT USING HASHTABLE
//		Object[][] data = new Object[rows - 1][cols];
//		for (int rowNum = 2; rowNum <= rows; rowNum++) {
//			for (int colNum = 0; colNum < cols; colNum++) {
//				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
//			}
//		}

//		USING HASHTABLE - here we will be creating a separate table for all columns. first row will always be key
		Hashtable<String, String> table = null;
		Object[][] data = new Object[rows - 1][1];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			table = new Hashtable<String, String>(); //for every row we will create a hashtable 
			
			for (int colNum = 0; colNum < cols; colNum++) {
				
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}

		return data;

	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		String sheetName = "testSuite";
		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {
			String testcase = excel.getCellData(sheetName, "TCID", rNum);

			if (testcase.equalsIgnoreCase(testName)) {
				String runmode = excel.getCellData(sheetName, "RunMode", rNum);

				if (runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
	}
}
