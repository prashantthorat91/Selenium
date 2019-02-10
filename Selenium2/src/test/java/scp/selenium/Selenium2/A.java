package scp.selenium.Selenium2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A {

	 
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("inside before method");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("inside after method");
	  }


	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("inside before class");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("inside after class");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("inside before test");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("inside after test");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("inside before suit");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("inside After suit");
	  }
	  @Test
	  public void test() {
		  System.out.println("inside test method");
	  }
	  @Test
	  public void test2() {
		  System.out.println("inside test2 method");
	  }
	  



}
