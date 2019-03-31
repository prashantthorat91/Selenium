package scp.selenium.package1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
 
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside before method--------4");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside after method-----6");
  }


  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside before class-------3");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside after class------8");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside before test------2");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside after test-----------9");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside before suit------1");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside After suit-------10");
  }
  @Test
  public void test() {
	  System.out.println("inside test method-------5");
  }
  @Test ()
  public void test2() {
	  System.out.println("inside test2 method--------7");
	  Annotations.test3();
  }
  public static void test3() {
	  System.out.println("inside test2 method--------##########");
  }
  
}
