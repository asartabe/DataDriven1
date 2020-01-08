package com.orgname.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.orgname.base.TestBase;
import com.orgname.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

//	@Test(dataProvider = "getData") -> we use this if we are defining the data provider in this same class

//	we use the below code if we have defined the data provider in the Test util class and named it as "dp"
//	the purpose of doing this is to create a dataProvider just once and then use everywhere

//  The below code uses the constructor as passed while creating the method. Commenting as now we will 
//	be using the HASHTABLE to store the values from the excel

//	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
//	public void addCustomerTest(String firstName, String lastName, String postCode, String alertText, String runMode) throws Throwable {

//		After adding the run mode in the excel. i.e to run specific data only . the col name should be passed as an constructor

//		if (!runMode.equalsIgnoreCase("Y")) {
//			throw new SkipException("Skipping the test case as the run mode is NO");
//		}

//		verifyEquals("abc", "xyz");

//		 without creating the type method in the TestBase class
//		driver.findElement(By.cssSelector(or.getProperty("AddCustBtn"))).click();
//		driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(firstName);
//		driver.findElement(By.cssSelector(or.getProperty("lastName"))).sendKeys(lastName);
//		driver.findElement(By.cssSelector(or.getProperty("postCode"))).sendKeys(postCode);
//		driver.findElement(By.cssSelector(or.getProperty("addBtn"))).click();

//		After creating the  type method in the TestBase class
//		click("AddCustBtn_CSS");
//		type("firstName_CSS", firstName);
//		type("lastName_XPATH", lastName);
//		type("postCode_CSS", postCode);
//		click("addBtn_CSS");

//		this code fails but keeping it now jsut to fail the test and get screenshot
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		Assert.assertTrue(alert.getText().contains(alertText), "Failed to add customer");
//		alert.accept();

//		Below code is correct but commented out just to fail the test and get screenshot
//		Alert alert = driver.switchTo().alert();
//		Assert.assertTrue(alert.getText().contains(alertText));
//		alert.accept();

//	}

//	Commenting this as now have created a common data provider in TestUtil
//	@DataProvider
//	public Object[][] getData() {
//
//		String sheetName = "AddCustomerTest";
//
//		int rows = excel.getRowCount(sheetName);
//		int cols = excel.getColumnCount(sheetName);
//
//		Object[][] data = new Object[rows - 1][cols];
//
//		for (int rowNum = 2; rowNum <= rows; rowNum++) {
//			for (int colNum = 0; colNum < cols; colNum++) {
//				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
//
//			}
//		}
//
//		return data;
//	}

//	CODE USING THE HASHTABLE
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String, String> data) throws Throwable {

		if (!data.get("runMode").equals("Y")) {
			throw new SkipException("Skipping the test case as the run mode is NO");
		}

		click("AddCustBtn_CSS");
		type("firstName_CSS", data.get("firstName"));
		type("lastName_XPATH", data.get("lastName"));
		type("postCode_CSS", data.get("postCode"));
		click("addBtn_CSS");

		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains(data.get("alertText")));
		alert.accept();

//		this code fails but keeping it now jsut to fail the test and get screenshot
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		Assert.assertTrue(alert.getText().contains(data.get("alertText")));
//		alert.accept();
	}

}
