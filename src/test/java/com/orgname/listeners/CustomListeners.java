package com.orgname.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.orgname.base.TestBase;
import com.orgname.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {

		test=report.startTest(result.getName().toUpperCase());
		
		//Runmode is Y
		
		if(!TestUtil.isTestRunnable(result.getName(), excel))
		{
			throw new SkipException("Skipping the test " +result.getName().toUpperCase()+ " as the runmode is NO");
		}

	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS
	 */
	public void onTestSuccess(ITestResult result) {
		
//		System.setProperty("org.uncommons.reportng.escape-output","false");
//
//		Reporter.log("Capturing screenshot");
//		Reporter.log("<a target=\"_blank\" href=\"C:\\Akshay\\Screenshots\\eclipse.png\">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href=\"C:\\Akshay\\Screenshots\\eclipse.png\"><img src=\"C:\\Akshay\\Screenshots\\eclipse.png\" height=200 width=200 ></img></a>");

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.screenshotName));

		report.endTest(test);
		report.flush();
		
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */
	public void onTestFailure(ITestResult result) {
	
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//for ExtentReports
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + " FAILED with exception " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		
		//for ReportNG
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200 ></img></a>");

		report.endTest(test);
		report.flush();
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, result.getName().toUpperCase());
		report.endTest(test);
		report.flush();
	}

	/**
	 * Invoked each time a method fails but has been annotated with
	 * successPercentage and this failure still keeps it within the success
	 * percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 */
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag and calling all their Configuration methods.
	 */
	public void onStart(ITestContext context) {
		
		
	}

	
	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 */
	public void onFinish(ITestContext context) {
		// not implemented
	}

}
