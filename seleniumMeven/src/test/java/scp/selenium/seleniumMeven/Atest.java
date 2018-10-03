package scp.selenium.seleniumMeven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import scp.app.util.AppConstants;
import scp.app.util.AppConstants.BrowserNames;
import scp.web.pageobject.OrangeHrmLogin;

public class Atest {
	
  @Test(priority = 1)
  public void A() 
  {
	  System.out.println("inside test A");
  }
  @Test(priority=0)
  public void B() 
  {
	  System.out.println("inside test B");
  } 
  @Test(priority=1)
  public void C() 
  {
	  System.out.println("inside test C");
  } 
  @Test(priority=2)
  public void D() 
  {
	  System.out.println("inside test D");
  } 
  @Test
  public void E() 
  {
	  System.out.println("inside test E");
  } 
  @Test
  public void F() 
  {
	  System.out.println("inside test F");
  }
}
