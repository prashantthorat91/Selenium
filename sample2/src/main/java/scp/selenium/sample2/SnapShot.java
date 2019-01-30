package scp.selenium.sample2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class SnapShot {
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException, IOException, AWTException {
			System.setProperty("webdriver.chrome.driver","I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
	        String baseUrl = "https://stackoverflow.com";
	        driver.get(baseUrl);
	        Thread.sleep(10000);
	        driver.manage().window().maximize();
	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_WINDOWS);
	        robot.keyPress(KeyEvent.VK_M);
	        robot.keyRelease(KeyEvent.VK_WINDOWS);
	        robot.keyRelease(KeyEvent.VK_M);
	        File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(file, new File("G:\\Selenium\\test.jpg"));
	        Files.copy(file, new File("G:\\Selenium\\test.jpg"));
	        //takeScreenShot("screenShot");
	        
		}
		public static void takeScreenShot(String fileName) throws IOException {
			File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(file, new File("G:\\Selenium\\"+fileName+".jpg"));
			Files.copy(file, new File("G:\\Selenium\\test.jpg"));
			
		}
		public void m1() throws IOException {
		TakesScreenshot sc = (TakesScreenshot)driver;
		File fl = sc.getScreenshotAs(OutputType.FILE);
		Files.copy(fl, new File("G:\\Selenium\\test.jpg"));
		}
}
