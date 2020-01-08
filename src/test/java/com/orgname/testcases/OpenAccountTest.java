package com.orgname.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orgname.base.TestBase;
import com.orgname.utilities.TestUtil;

public class OpenAccountTest extends TestBase {

//	WITHOUT USING THE HASHTABLE
//	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
//	public void openAccountTest(String customer, String currency, String alertText) throws Throwable {
		
//		verifyEquals("abc", "xyz");

		/*
		 * if we dont create the select method for dropdown then we will have to first
		 * click on the dropdown and then select the value from the available List. But
		 * this causes issues in real time execution for various dropdowns. Hence we
		 * create the Select method once in the BaseClass and then use it as and when
		 * required
		 */
//		click("OpenAccBtn_XPATH");
//		click("CustDD_XPATH");
//		type("CustDD_XPATH", customer);
//		click("CurrDD_XPATH");
//		type("CurrDD_XPATH", currency);
//		click("ProBtn_XPATH");
		
//		click("OpenAccBtn_XPATH");
//		select("CustDD_XPATH", customer);
//		select("CurrDD_XPATH", currency);
//		click("ProBtn_XPATH");
//		
//		 Alert alert = driver.switchTo().alert();
//		 Assert.assertTrue(alert.getText().contains(alertText)); 
//		 alert.accept();
	
	
//	CODE USING THE HASHTABLE
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccountTest(Hashtable<String, String> data) throws Throwable {
		
		click("OpenAccBtn_XPATH");
		select("CustDD_XPATH", data.get("customer"));
		select("CurrDD_XPATH", data.get("currency"));
		click("ProBtn_XPATH");
		
		 Alert alert = driver.switchTo().alert();
		 Assert.assertTrue(alert.getText().contains(data.get("alertText"))); 
		 alert.accept();
		
	}
}
