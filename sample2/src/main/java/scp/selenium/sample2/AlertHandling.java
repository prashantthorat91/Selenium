package scp.selenium.sample2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/test/delete_customer.php");
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	}

}
