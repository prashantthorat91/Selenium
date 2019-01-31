package scp.sel.sample.selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeScrnShot {
		static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		takeSnapShot(driver);
		
		

	}
	public static void takeSnapShot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		Files.copy(scrFile, new File("C:\\Users\\VinodJagtap\\Desktop\\test.jpg"));
		
		
		
		

	}

}
