package scp.selenium.sample2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {

	public static void main(String[] args) {
	/*	System.setProperty("webdriver.chrome.driver", "H:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.trivago.in/";
		driver.get(baseUrl);
		driver.findElement(By.id("horus-querytext")).sendKeys("Pune");
		driver.findElement(By.xpath("//div[@class='horus__col horus__col--checkin']")).click();
		String date = driver.findElement(By.xpath("//th[@id='cal-heading-month']//child::span")).getText();
		String date1 = "May 2019";
		while (!date.equals(date1)) {
			System.out.println(date + "::" + date1);
			driver.findElement(By.xpath("//button[@class='cal-btn-next']")).click();
			date = driver.findElement(By.xpath("//th[@id='cal-heading-month']//child::span")).getText();
		}

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='df_overlay']//table/tbody/tr"));
		System.out.println("size= " + list.size());
		System.out.println(date);*/

		String s1="abc";
		String s2= new String ("abc");
		System.out.println("s1 :"+s1.hashCode());
		System.out.println("s2 :"+s2.hashCode());
		Integer a = 4;
		Integer b =4;
		System.out.println(a.equals(b));
		
	}

}
