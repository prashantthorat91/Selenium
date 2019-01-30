package scp.selenium.sample2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicTable {
	WebDriver driver;
	int rowSize= 0;
	 @BeforeClass
	  public void initilizeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Prashant\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		  
		}

	 @Test
	 public void Columns() {
		 List<WebElement> column = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		 System.out.println("number of columns are : "+	column.size());
	 }
	 @Test
	 public void rows() {
		 List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[5]"));
		 System.out.println("number of rows are : "+	rows.size());
		 rowSize= rows.size();
		// driver.close();
	 }
	//*[@id="leftcontainer"]/table/tbody/tr[1]/td[2]
	//*[@id="leftcontainer"]/table/tbody/tr[6]/td[4]
	//*[@id="leftcontainer"]/table/tbody/tr[69]/td[1]
	 @Test
	 public void table() {
		 String beforeXpath = "//*[@id=\"leftcontainer\"]/table/tbody/tr[";
		 String afterXpath = "]/td[4]";
	 for(int i=1;i<=rowSize; i++) {
		String value= driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
		//System.out.println(value);
		if(value.contains("3,262.60")) {
			driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[1]")).click();
			break;
		}
		//driver.close();
		 
	 }
	 }
}
