package scp.selenium.seleniumMeven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import scp.app.util.AppConstants;
import scp.app.util.AppConstants.BrowserNames;

public class AppUtil {
	static WebDriver driver = null;
	static public WebDriver initializeBrowser(BrowserNames bname, String url ) {
		//WebDriver driver = null;
		switch (bname) {
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			break;
		}
		driver.get(url);
		return driver;
		
	}
	public static WebDriver getWebdriver(){
		if(driver==null)
			//AppUtil.initializeBrowser(BrowserNames.Chrome, AppConstants.ORANGE_HRM_APP_URL);
				Assert.fail("Driver is not initilized..initilize first..then get it...!");
		return driver;
	}

}
