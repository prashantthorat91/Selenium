package scp.selenium.sample2;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
        String baseUrl = "https://accounts.google.com/ServiceLogin";
        driver.get(baseUrl);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        username.sendKeys("prashantthorat91");
       // driver.findElement(By.id("identifierId")).sendKeys("prashantthorat91");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
        WebElement nextPage;
        nextPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        nextPage.sendKeys("hjjkhjkhk");
        driver.navigate().back();
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().back();
        Wait<WebDriver> wait1= new FluentWait<WebDriver>(driver)
        		.withTimeout(30, TimeUnit.SECONDS)
        		.pollingEvery(3, TimeUnit.SECONDS)
        		.ignoring(NoSuchElementException.class);
       
	}
	

} 
