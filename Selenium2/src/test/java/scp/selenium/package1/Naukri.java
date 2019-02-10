package scp.selenium.package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import scp.selenium.app.util.AppConstants;
import scp.selenium.app.util.AppConstants.BrowserNames;
import scp.selenium.app.util.utilClass;

public class Naukri {
	WebDriver driver= utilClass.initializeBrowser(BrowserNames.Chrome, AppConstants.NAUKRI);
	
	@BeforeClass
	  public void initial() {
		driver.manage().window().maximize();
		
	  }
  @Test(priority=0)
  public void fresher() {
	  driver.findElement(By.xpath("//*[@class='action-btn fresh']")).click();
	 
  }
  @Test(priority=1)
  public void firstName() {
	  driver.findElement(By.xpath("//*[@id='fname']")).sendKeys("prashant");
	 
  }
  @Test(priority=2)
  public void email() {
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("prashantthorat91@gmail.com");
	 
  }
  @Test
  public void facebook() {
	 
  }
  
  

}
