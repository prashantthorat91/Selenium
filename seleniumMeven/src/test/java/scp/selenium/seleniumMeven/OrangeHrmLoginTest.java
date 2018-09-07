package scp.selenium.seleniumMeven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import scp.app.util.AppConstants;
import scp.app.util.AppConstants.BrowserNames;
import scp.web.pageobject.OrangeHrmLogin;
import scp.web.pageobject.orangeHrmDashboard;

public class OrangeHrmLoginTest {
	
	@DataProvider(name="data")
	public Object[][] getTestData(){
		try {
			return ReadTestDataFromExcel.convertTwoDimentionalArray();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
	}
	
	
	@Test(dataProvider="data")
	public void verifyUserLoginCrentials(String username,String password, String emsg){
		
		WebDriver driver= AppUtil.initializeBrowser(BrowserNames.Chrome, AppConstants.ORANGE_HRM_APP_URL);
		OrangeHrmLogin login = PageFactory.initElements(driver, OrangeHrmLogin.class);
		login.enterUserName(username);
		login.enterPassword(password);
		if(emsg.equalsIgnoreCase("Welcome Admin")) {
			orangeHrmDashboard dashBoardPage = login.clickLoginWithSuccess();
			Assert.assertEquals(emsg, dashBoardPage.getWelcomeMsg());
			
		}else {
			login.clickLoginWithError();
			Assert.assertEquals(emsg, login.getErrorMessage());
		}
		driver.close();	
		
	}

}
