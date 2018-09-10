package com.scp.app.login.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.scp.app.util.TestNGListeners;
@Listeners(value=TestNGListeners.class)

public class Atest {
	@Test
	public void m1(){
		System.out.println("m1");
	}
	
	@Test
	public void m2(){
		System.out.println("m1");
	}
	
	@Test
	public void m3(){
		System.out.println("m1");
	}
	
	@Test
	public void m4(){
		System.out.println("m1");
	}
	
	@Test(dependsOnMethods="m7",invocationCount=7)
	public void m5(){
		System.out.println("m1");
	}
	
	@Test
	public void m6(){
		System.out.println("m1");
	}
	
	@Test(invocationCount=10)
	public void m7(){
		System.out.println("m1");
		int i =10/0;
	}
	@Test
	public void m8(){
		System.out.println("m1");
	}
	
	@Test(invocationCount=200)
	public void m9(){
		System.out.println("m1");
	}
	

}
