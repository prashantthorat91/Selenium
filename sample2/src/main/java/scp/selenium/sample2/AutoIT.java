package scp.selenium.sample2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoIT {
	
	@Test
	void uploadFile() throws IOException {
		System.setProperty("webdriver.chrome.driver","H:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:/C:/Users/Prashant/Desktop/FileUpload.html");
		driver.findElement(By.id("1")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Runtime.getRuntime().exec("C:\\Users\\Prashant\\Desktop\\AutoIT\\FileUpload.exe");
	}

}
