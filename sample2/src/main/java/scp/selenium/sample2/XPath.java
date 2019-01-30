package scp.selenium.sample2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPath {
	static WebDriver driver;
	@Test
	public void xpath(){
		System.setProperty("webdriver.chrome.driver","I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
        String baseUrl = "http://toolsqa.com/automation-practice-form/";
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@type='text' and @name='firstname']")).sendKeys("prashant");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("thorat");
        driver.findElement(By.xpath("//*[@id='sex-0']")).click();
	}
}
