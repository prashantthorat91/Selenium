package scp.selenium.sample2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","I:\\Software\\selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    String baseUrl = "http://toolsqa.com/iframe-practice-page/";
        driver.get(baseUrl);
	}

}
