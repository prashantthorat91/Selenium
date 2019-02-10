package scp.selenium.package1;

import org.testng.annotations.Test;

public class parallel {
	@Test
	public void m1() {
		System.out.println("inside m1 & thread ID :: "+Thread.currentThread().getId());
	}
	@Test
	public void m2() {
		System.out.println("inside m2 & thread ID :: "+Thread.currentThread().getId());
	}
	@Test
	public void m3() {
		System.out.println("inside m3 & thread ID :: "+Thread.currentThread().getId());
	}
	@Test
	public void m4() {
		System.out.println("inside m4 & thread ID :: "+Thread.currentThread().getId());
	}

}
