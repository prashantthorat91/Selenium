package scp.selenium.sample2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownOperations {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
        String baseUrl = "https://www.makemytrip.com/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Select dropDounCountry = new Select(driver.findElement(By.name("Industry")));
        dropDounCountry.selectByValue("Education");
        driver.findElement(By.id("Form_requestDemo_Email")).sendKeys("prashantthorat91@gmail.com");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Select drpDwnCountry = new Select(driver.findElement(By.name("Country")));
        drpDwnCountry.selectByIndex(2);
        driver.findElement(By.id("Form_requestDemo_action_requestDemo")).click();
        List<WebElement> el = driver.findElements(By.xpath("//*"));
        int count=0;
        for ( WebElement e : el ) {
         System.out.println( e.getTagName()+"    "+e.getText());

         count++;

        }
      System.out.println(count );
        List<WebElement> dropDown = dropDounCountry.getOptions();
        System.out.println(dropDown.size());
        for(int i=0;i<dropDown.size();i++) {
        	System.out.println(dropDown.get(i).getText());
        }
      /*  driver.get("https://www.makemytrip.com/");
        driver.findElement(By.className("o-i-trip-bag")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ch_trips_login")).click();*/
        
        
        
	}

}
