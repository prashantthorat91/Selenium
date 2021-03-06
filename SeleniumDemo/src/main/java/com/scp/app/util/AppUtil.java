		package com.scp.app.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.scp.app.constants.AppConstants.BrowserNames;
		
		public class AppUtil {
			
	static	public WebDriver initializeBrowser(BrowserNames bName,String url){
				WebDriver driver = null;
				switch(bName){
					case Firefox:
							System.setProperty("webdriver.gecko.driver", "E:\\MySofts\\geckodriver-v0.19.0-win64\\geckodriver.exe");
							driver = new FirefoxDriver();
							break;
					case Chrome:
							System.setProperty("webdriver.chrome.driver", "E:\\Prashant\\chromedriver.exe");
							driver = new ChromeDriver();
							break;
					case IE:
							driver = new InternetExplorerDriver();
							break;
					case Safari:
							driver = new SafariDriver();
							break;
					default :
						System.out.println("Khaddyat ja....!");
				}
				driver.get(url);
				return driver;
				
				
			}
			
			
		}
