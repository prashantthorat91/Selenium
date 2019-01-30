package scp.selenium.sample2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseOperations {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.makemytrip.com/");
	    WebElement element = driver.findElement(By.id("ch_funnel_more"));
	    Actions action = new Actions(driver);
	   // action.sendKeys("jzdnjkz").build();
	    action.moveToElement(element).build().perform();
	    driver.findElement(By.linkText("Blog")).click();
	   /* action.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	    action.build().perform();*/
	    action.build().perform();
	    Robot robot = new Robot();
	    
	    /*robot.keyPress(KeyEvent.VK_WINDOWS);
	    robot.keyPress(KeyEvent.VK_M);
	    robot.keyRelease(KeyEvent.VK_WINDOWS);
	    robot.keyRelease(KeyEvent.VK_M);*/
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_A);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_A);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_T);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_T);
	    action.doubleClick().click();
	    action.contextClick().click();
	    action.build().perform();
	    System.out.println(driver.getWindowHandles().size());
	   
	    
	}

}
