package scp.selenium.sample2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPath {
	static WebDriver driver;
	@Test
	public void xpath(){
		System.setProperty("webdriver.chrome.driver","H:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
        String baseUrl = "https://www.makemytrip.com/";
        driver.get(baseUrl);
       // driver.findElement(By.xpath(""))
       
	}
}
