package com.scp.app.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{
	static int passCount = 0;
	static int failCount = 0;
	static int skipCount = 0;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Executing "+result.getMethod().getMethodName() +" Test");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		failCount++;
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		skipCount++;
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Executing "+context.getSuite().getName() +" ");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finished  "+context.getSuite().getName() +" ");
		System.out.println("generating report...");
		GenerateTestReport.generateTestReport(passCount, failCount, skipCount);
		
	}

	

}
