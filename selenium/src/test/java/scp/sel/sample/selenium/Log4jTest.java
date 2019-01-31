package scp.sel.sample.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils;

import com.google.common.base.Function;

public class Log4jTest {
	WebDriver driver;
	
	@BeforeClass
	public void initializeBrowser() {
		
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
		driver= new ChromeDriver();
		
		
	
	}
	@Test
	public void m1()
	{
		driver.get("https://www.makemytrip.com/");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"js-switch__option\"]/div[2]/label"))));
		element.click();
		
		Wait wait1 = new FluentWait(driver).withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function() {    
		    public WebElement apply(WebDriver driver) {    
		        return driver.findElement(By.id("foo"));    
		    }

			public Object apply(Object arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		});
				
		
		System.out.println("inside m1");
	}
	@Test
	public void m2()
	{
		System.out.println("inside m2");
	}
}
