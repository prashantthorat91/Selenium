package scp.sel.sample.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		String handle = driver.getWindowHandle();
		System.out.println(handle);
	}

}
