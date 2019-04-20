package scp.selenium.package1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;
@Listeners(TestNGListener.class)
public class AssertVerify {

	SoftAssert softAssert = new SoftAssert();
	@Test(priority=0)
	void asser() {
		String st = "prashant";
		Assert.assertEquals(st, "prashant");
		
		System.out.println("=====pass AssertEqual==========");
		
	}
	@Test(priority=1)
	void verify() {
		Verify.verify(4<2);
		System.out.println("pass--------------------Verify");
		
	}
	@Test(priority=2)
	public void softAsserrt() {
		String st = "prashant";
		softAssert.assertEquals(st, "pt");
		System.out.println("softassert--------------Fail");
		System.out.println("-------///////////////////////---------------");
		//softAssert.assertAll();
		
	}
}
