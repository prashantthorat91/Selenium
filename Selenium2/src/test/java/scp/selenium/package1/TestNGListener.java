package scp.selenium.package1;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener{
		
	static int passCount = 0;
	static int failCount = 0;
	static int skipCount = 0;
	public void onFinish(ITestContext arg0) {
		System.out.println("pass count : "+passCount);
		System.out.println("fail count : "+failCount);
		System.out.println("skip count : "+skipCount);
		PichartReport.generateTestReport(passCount, failCount, skipCount);
		try {
			BarchartReport.generateTestReport(passCount, failCount, skipCount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void onStart(ITestContext arg0) {
		
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult arg0) {
		failCount++;
		
	}
	public void onTestSkipped(ITestResult arg0) {
		skipCount++;
		
	}
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestSuccess(ITestResult arg0) {
		passCount++;
		
	}
	
	
		
	

}
