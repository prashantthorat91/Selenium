package scp.selenium.package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {
	WebDriver driver;
	  
	  @BeforeClass
	  public void initilizeBrowser() {
		  
		  driver = new ChromeDriver();	
		  driver.get("https://www.facebook.com/");
		  
	  }
	  @AfterMethod
	  public void closeBrowser() {
		  System.out.println("closing browser");
		  		  
	  }
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("before test");
		  System.setProperty("webdriver.chrome.driver", "I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
		  
	  }
	  @AfterTest
	  public void afterTest() {
		  System.out.println("After test");
		  //driver.quit();
	  }
	  @BeforeMethod
	  public void openBrowser() {	
		    		  		  
	  }
	  @Test(priority=0)
	  public void firstName() throws Exception {
		  driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("pras");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("hant");
		  System.out.println("method 1");
	 	
	  }
	  @Test(priority=1 )
	  public void lastName() throws Exception {
		 // int a =2/0;
		  driver.findElement(By.name("lastname")).sendKeys("thor");
		  Thread.sleep(5000);
		  driver.findElement(By.name("lastname")).sendKeys("at");
		  System.out.println("method 2");	
	  }
	  @Test(priority=2)
	  public void mobile() throws InterruptedException {
		 driver.findElement(By.name("reg_passwd__")).sendKeys("85652");
		 Thread.sleep(5000);
		 driver.findElement(By.name("reg_passwd__")).sendKeys("31452");
		 System.out.println("method 3");	
		 	
	  }

}
