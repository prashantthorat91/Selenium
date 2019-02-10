package scp.selenium.sample2;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Prashant\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
        String baseUrl = "http://toolsqa.com/iframe-practice-page/";
        driver.get(baseUrl); 
        List<WebElement> frame = driver.findElements(By.tagName("iframe"));
        System.out.println(frame.size());
        Iterator<WebElement> itr = frame.listIterator();
        System.out.println("===================");
        while(itr.hasNext()) {
        	System.out.println(itr.next().getText());
        }
      /*  driver.manage().window().maximize();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("IF2");
        driver.findElement(By.id("ui-id-4")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("IF1");*/
       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("Window.scrollBy(0,600)");*/
        Thread.sleep(500);
        //driver.findElement(By.name("firstname")).sendKeys("prashant");
       
         
        
	}

}
