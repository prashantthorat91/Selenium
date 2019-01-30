package scp.selenium.sample2;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4J {
	Logger log = Logger.getLogger("devpinoyLogger");
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    String baseUrl = "https://www.freecrm.com";
        driver.get(baseUrl);
	}
	@Test(priority=0)
	public void freeCRMTitle() {
        log.debug("verify title");
		String title = driver.getTitle();
		Reporter.log("verifying title");
		System.out.println(title);
		//Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		Reporter.log("title verified");
	}
	@Test(priority=1)
	public void freeCRMLogo() {
		log.debug("verify logo");
		//int a = 10/0;
		//System.out.println(a);
		boolean b= driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img")).isDisplayed();
		Reporter.log("logo verified");
		//Assert.assertTrue(b);
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
