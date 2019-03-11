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
		System.setProperty("webdriver.chrome.driver", "I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		List column = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println(column.size());
		List row = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		int rowCount = row.size();
		System.out.println(row.size());
		String beforeXpath ="//*[@id=\"leftcontainer\"]/table/tbody/tr[";
		String afterXpath = "]/td[3]";
		for(int i=1;i<=rowCount;i++) {
			//String value = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			String value = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[3]")).getText();
			if(value.equals("7.44")) {
				driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[1]")).click();
			}
		}
	}

	

}
