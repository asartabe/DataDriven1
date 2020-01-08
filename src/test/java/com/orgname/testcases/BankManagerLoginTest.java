package com.orgname.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orgname.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void bankManagerLoginTest() throws IOException {

//		verifyEquals("abc", "xyz");
		
		
		// without creating the Click method in the TestBase class
//		driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();

//		After creating the  Click method in the TestBase class
		click("bmlBtn_CSS");

		Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("AddCustBtn_CSS"))), "Login not successful");

		
	}
}
