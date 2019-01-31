package scp.sel.sample.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.xml.internal.txw2.Document;

public class JavaScriptExecuter {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("document.getElementById('src').value='pune'");
		
				

	}

}
