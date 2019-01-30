package scp.selenium.sample2;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
        String baseUrl = "https://stackoverflow.com";
        driver.get(baseUrl);        
        driver.manage().window().setPosition(new Point(0,-100));
        Thread.sleep(10000);
        driver.manage().window().maximize();
        
        
	}

}
