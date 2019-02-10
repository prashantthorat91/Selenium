package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ps {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Prashant\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement drpdwn = driver.findElement(By.name("country"));
		Select dropDwn = new Select(drpdwn);
		dropDwn.selectByIndex(2);
		List<WebElement> l = dropDwn.getOptions();
		for(int i=0;i<l.size();i++) {
			System.out.println(l.get(i).getText());
		}
		driver.quit();
		
	}

	

}
