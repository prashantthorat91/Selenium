package scp.selenium.package1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Parallel2 {
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("before group in parallel 2 and thread ID :-----"+Thread.currentThread().getId());
		
	}
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("before suit in parallel 2 and thread ID :------"+Thread.currentThread().getId());
	}
	@BeforeClass(enabled = true)
	public void beforeClass() {
		System.out.println("before class and thread ID :-----"+Thread.currentThread().getId());
	}
	@BeforeMethod
	public void m8() {
		System.out.println("before method");
	}
	@Test
	public void m5() {
		int s = 20/0;
		System.out.println("inside m5"+s);
	}
	@Test(dependsOnMethods= {"m5"})
	public void m6() {
		System.out.println("inside m6 and thread ID :-------"+Thread.currentThread().getId());
	}
	@Test(invocationCount=2)
	public void m7() {
		System.out.println("inside m7 and thread ID :--------"+Thread.currentThread().getId());
	}

}
