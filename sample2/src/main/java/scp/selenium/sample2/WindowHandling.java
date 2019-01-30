package scp.selenium.sample2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		/*try {
			openSameUrlInMultipleTab();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(true)
			return;*/
		
		
			
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://guru99.com");
	    Thread.sleep(2000);
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//a[text()='SAP Beginner']")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
	    System.out.println("navigate back success  ");
	/*    
	    String MainWindow=driver.getWindowHandle();
	    System.out.println("MAin window"+MainWindow);*/
	    
/*	    
	    
//	    String text = driver.findElement(By.id("hp-widget__sfrom")).getAttribute("value");
//	    System.out.println(text);
	   // Thread.sleep(50000);
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_T);
	    robot.keyRelease(KeyEvent.VK_T);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
	    robot.keyRelease(KeyEvent.VK_T);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    driver.navigate().to("https://www.google.com");
	    
	    Set<String> s1 = driver.getWindowHandles();
	    for (String childWindow : s1) {
	    	System.out.println("Child windows: "+childWindow);
//	    	
//	    	if(!childWindow.equals(MainWindow)) {
//	    		driver.switchTo().window(childWindow);
//		    	driver.get("https://www.makemytrip.com/");  
//	    	}
		}
	    
	    Iterator<String> window = s1.iterator();
	    while(window.hasNext()) {
	    	String childWindow = window.next();
	    	
	    	driver.switchTo().window(childWindow);
	    	driver.get("https://www.makemytrip.com/");  	
	   // }
	    //driver.get("https://www.makemytrip.com/");
	    
*/
	}

	public static void openSameUrlInMultipleTab() throws InterruptedException {
		  
		System.setProperty("webdriver.chrome.driver","I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		  String pageUrl = "http://www.bing.com";
		  driver.get(pageUrl);
		  
		  String currWindowHandleStr = driver.getWindowHandle();
		  System.out.println("Current windowhandler before create tab : " + currWindowHandleStr);
		  
		  /* Get html body webelement. */
		  WebElement bodyElement = driver.findElement(By.tagName("body"));
		 
		  /* Send Ctrl+t to create newtab. */
		  for(int i=0;i<6;i++)
		  {
			  bodyElement.sendKeys(Keys.CONTROL + "t");
			  Thread.sleep(1000);
			  System.out.println("Open a newtab.");
		  }
		  
		 
		  /* Change tab 2 's page url tp http://www.google.com */
		  bodyElement.sendKeys(Keys.CONTROL+"2");
		  driver.get("http://www.google.com");
		  Thread.sleep(3000);
		  
		  currWindowHandleStr = driver.getWindowHandle();
		  System.out.println("Current windowhandler after go to tab 2 : " + currWindowHandleStr);
		  
		  /* Close tab 3.*/
		  /* First need to find the body web element in currenttab. */
		  bodyElement = driver.findElement(By.tagName("body"));
		  /* Go to tab 3. */
		  bodyElement.sendKeys(Keys.CONTROL+"3");
		  driver.get("http://www.twitter.com");
		  Thread.sleep(3000);
		  /* Close currenttab. */
		  bodyElement.sendKeys(Keys.CONTROL+"w");
		  Thread.sleep(3000);
	  }
}
