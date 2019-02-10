package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class mous {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Prashant\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/a/span/span")));
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[7]/a/span/span")));
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[7]/ul/li[1]/a/span/span")));
		action.click();
		action.build().perform();
		

	}

}
