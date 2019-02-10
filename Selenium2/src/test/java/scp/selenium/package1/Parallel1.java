package scp.selenium.package1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Parallel1 {
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("before group in parallel 1");
	}
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("before suit in parallel 1");
	}
	@Test
	public void m1() {
		System.out.println("inside m1");
	}
	@Test
	public void m2() {
		System.out.println("inside m2");
	}
	@Test
	public void m3() {
		System.out.println("inside m3");
	}
	@Test
	public void m4() {
		System.out.println("inside m4");
	}
	@BeforeClass
	public void m5() {
		System.out.println("inside before class");
	}
	@BeforeTest
	public void m6() {
		System.out.println("inside before Test");
	}
	@AfterTest
	public void m7() {
		System.out.println("inside After Test");
	}
	
	
	
	

}
