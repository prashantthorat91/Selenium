package scp.selenium.sample2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable2 {
	static WebDriver driver;
	static int columnSize=0;
	static int rowSize=0;
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException  {
		System.setProperty("webdriver.chrome.driver", "E:\\Prashant\\chromedriver.exe");
		driver = new ChromeDriver();
		DynamicTable2.rowColumnCount();
		//*[@id="leftcontainer"]/table/thead/tr/th
		//*[@id="leftcontainer"]/table/tbody/tr[6]/td[1]/a
	}
	public static void rowColumnCount() {
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		List<WebElement> column = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		columnSize = column.size();
		System.out.println("no. of columns are: "+columnSize);
		List rows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		rowSize = rows.size();
		System.out.println("no. of rows are: "+rowSize);
		

		String beforeXpath = "//*[@id=\"leftcontainer\"]/table/tbody/tr[";
		String afterXpath = "]/td[4]";
		for(int i=1;i<=rowSize;i++) {
			//System.out.println("....................................");
			String value = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			System.out.println(value);
			if(value.contains("48.40")) {
				driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[1]")).click();
				break;
			}
		}
	
	}
}
