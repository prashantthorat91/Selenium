import java.io.BufferedReader;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;



public class MainClass {
	 public static void main(String[] args) throws Exception {
//		 	System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
//			WebDriver driver = new ChromeDriver();
		 
		    System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
	        String baseUrl = "https://soilhealth.dac.gov.in/Account/URL";
	        driver.get(baseUrl);
	        //Thread.sleep(30000);
	        Select state = new Select(driver.findElement(By.name("StateUrl")));
	        state.selectByVisibleText("Maharashtra");
	        Thread.sleep(3000);
	       // driver.manage().window().maximize();
	        driver.findElement(By.className("myButton")).click();
	        Thread.sleep(5000);  
	        
	        /*driver.findElement(By.id("UserName")).sendKeys("MH11_HOPESOIL");
	        
	        driver.findElement(By.id("Password")).sendKeys("Hope456#");*/
	        Thread.sleep(120000);
	        
	        driver.findElement(By.id("loginbutton")).click();
	        driver.findElement(By.xpath("//a[@href='/SampleReg/SampleRegistrationMenuPage/SampleRegistrationMenuPage/SimpleNew']")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//img[@src='/Content/image/new.png']")).click();
	        Thread.sleep(2000);
	        System.out.println("Reading data from excel");
	        ReadDataFromExcel obj1 = new ReadDataFromExcel();
	        
	        
	        String excelName="";
			String sheetName="";
			String date="";
			try(BufferedReader br = new BufferedReader(new FileReader(".//properties.txt"))){
				String line = br.readLine();
				while(!(line==null)){
					if(line.contains("ExcelName")) {
						excelName = line.split(":")[1];
						System.out.println("Excel Name"+excelName+"\n");
					}
					else if(line.contains("SheetName")) {
						sheetName = line.split(":")[1];
						System.out.println("Sheet Name"+sheetName+"\n");
					}
					else if(line.contains("Date")) {
						date = line.split(":")[1];
						System.out.println("Date"+date+"\n");
					}
					line = br.readLine();
				}
				}
				//obj1.readExcel("C:\\Users\\VinodJagtap\\Desktop\\SoilHealthFinal\\All.xlsx","Sheet2", driver);
			
	      
	        obj1.readExcel(".",excelName,sheetName,driver,date);
	        //driver.close();
	       
	    }
	 

}
