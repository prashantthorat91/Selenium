package scp.selenium.sample2;

import java.io.IOException;

import org.jfree.data.general.DefaultPieDataset;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener
{
	static int passCount=0;
	static int failCount=0;
	static int skipCount=0;
	public static void main(String[] args) 
	{
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Pass "+passCount);
		System.out.println("Fail "+failCount);
		System.out.println("Skip "+skipCount);
	DefaultPieDataset dataset = new DefaultPieDataset( );
    dataset.setValue("PASS", this.passCount);
    dataset.setValue("FAIL", this.failCount);
    dataset.setValue("SKIP",this.skipCount);
	PiechartCode.setDatasetValue(dataset);
	try {
		PiechartCode.createPieCart();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		this.failCount++;
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		this.skipCount++;
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		this.passCount++;
		
	}

}
