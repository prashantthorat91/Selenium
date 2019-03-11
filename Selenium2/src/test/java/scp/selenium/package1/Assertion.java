package scp.selenium.package1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;
@Listeners(TestNGListener.class)
public class Assertion {
	SoftAssert softAssert = new SoftAssert();
	@Test(priority = 1,dependsOnMethods= {"assertTrue"})
	public void softAsserrt() {
		String st = "prashant";
		softAssert.assertEquals(st, "prashat");
		System.out.println("softassert--------------Fail");
		softAssert.assertAll();
	}
	@Test(priority = 2)
	public void assertEqual() {
		String st = "prashant";
		Assert.assertEquals(st, "prashant");
		System.out.println("pass AssertEqual");
	}
	@Test(priority = 3)
	public void assertNotEqual() {
		Assert.assertNotEquals("prashant", "prashant");
		System.out.println("pass---------------------");
	}
	@Test(dependsOnMethods= {"verify"}, priority = 4)
	public void assertTrue() {
		Assert.assertTrue(4<2);
		System.out.println("pass------AssertTrue");
	}
	@Test(priority = 5)
	public void verify() {
		Verify.verify(4<2);
		System.out.println("pass--------------------Verify");
	}
	/*@Test(priority = 5)
	public void assertNull() {
		Assert.assertNull(null);
		System.out.println("pass");
	}
	@Test(priority = 7)
	public void assertNotNull() {
		Assert.assertNotNull(" ");
		System.out.println("pass");
	}*/
	@Test(priority = 8)
	public void softAssert() {
		
		//softAssert.assertNotEquals("prashant", "thorat");
		//softAssert.assertEquals("prashant", "thorat");
		//softAssert.assertAll();
		System.out.println("pass-----------8");
      
	}
	
	@Test(invocationCount =10, successPercentage=5)
	public void softAssert1() {
		
		//softAssert.assertNotEquals("prashant", "thorat");
		//softAssert.assertEquals("prashant", "thorat");
		//softAssert.assertAll();
		System.out.println("pass-----------8");
      
	}

}
