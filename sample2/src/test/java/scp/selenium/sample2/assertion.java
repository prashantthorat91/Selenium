package scp.selenium.sample2;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

@Listeners(ListenerTest.class)
public class assertion {

	SoftAssert softAssert = new SoftAssert();
	@Test(priority=0, invocationCount = 10, successPercentage= 100)
	public void softAsserrt() {
		String st = "prashant";
		AssertJUnit.assertEquals(st, "prash");
		System.out.println("softassert");
	}
	@Test(priority=1)
	public void assertEqual() {
		String st = "prashant";
		AssertJUnit.assertEquals(st, "prasha");
		System.out.println("assert equals pass");
	}
	@Test(priority=2)
	public void assertNotEqual() {
		Assert.assertNotEquals("prashant", "thorat");
		System.out.println("assert not equalspass");
	}
	@Test(priority=3)
	public void assertTrue() {
		AssertJUnit.assertTrue(4<2);
		System.out.println("assert true pass");
	}
	@Test(priority=4)
	public void verify() {
		Verify.verify(4>2);
		System.out.println("verify pass");
		
	}
	@Test(priority=5)
	public void assertNull() {
		AssertJUnit.assertNull(null);
		System.out.println("assurt null pass");
	}
	@Test(priority=6)
	public void assertNotNull() {
		Assert.assertNotNull(" ");
		System.out.println("assert not null pass");
	}
	@Test(priority=7)
	public void softAssert() {
		
		softAssert.assertNotEquals("prashant", "thorat");
		//softAssert.assertEquals("prashant", "thorat");
		//softAssert.assertAll();
		System.out.println("soft assert pass");
		
      
	}
	


}
