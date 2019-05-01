package scp.selenium.sample2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinks {
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException  {
		System.setProperty("webdriver.chrome.driver","I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.freecrm.com";
        driver.get(baseUrl);
        //driver.navigate().to(baseUrl);
        driver.findElement(By.name("username")).sendKeys("PrashantThorat");
        driver.findElement(By.name("password")).sendKeys("9657179957");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
        driver.switchTo().frame("mainpanel");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        links.add(driver.findElement(By.tagName("img")));
        System.out.println(links.size());
       List<WebElement> activeLinks = new ArrayList<>();
       for(int i=0;i<links.size();i++) {
    	   System.out.println(links.get(i).getAttribute("href"));
    	   if(links.get(i).getAttribute("href")!=null&&(!links.get(i).getAttribute("href").contains("javascript"))) {
    		   activeLinks.add(links.get(i));
    		   
    	   }
       }
       System.out.println("Active link size is: "+activeLinks.size());
       for (int j=0;j<activeLinks.size();j++) {
    	   
			HttpURLConnection connection= (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String responce= connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"------>"+responce);
			
       }
       driver.close();
	}

}
