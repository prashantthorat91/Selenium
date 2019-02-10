package scp.selenium.package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {	
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void setBrowser(String browser) {
		if(browser.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver","I:\\Software\\selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		    String baseUrl = "https://www.facebook.com/";
	        driver.get(baseUrl);
		}else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
	        String baseUrl = "https://www.facebook.com/";
	        driver.get(baseUrl); 
		}else {
			System.out.println("invalid browser name");
		}
	}
	  @Test(priority=0)
	  public void firstName() {
		  driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("prashant");
		  System.out.println("method 1");
		  driver.close();
	 	
	  }
	 /* @Test(priority=1 )
	  public void lastName() {
		  int a =2/0;
		  driver.findElement(By.name("lastname")).sendKeys("thorat");
		  System.out.println("method 2");	
	  }*/

}
