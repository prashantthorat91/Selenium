package scp.web.pageobject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmLogin {
		@FindBy(id="txtUsername")
		static WebElement username;
		
		@FindBy(id="txtPassword")
		WebElement password;
		
		@FindBy(id="btnLogin")
		WebElement loginButton;
		
		@FindBy(id="spanMessage")
		WebElement errorMsg;
		
		
		public void enterUserName(String name) {
			username.clear();
			username.sendKeys(name);
			
			
		}
		public void enterPassword(String pwd) {
			password.clear();
			password.sendKeys(pwd);
		}
		public orangeHrmDashboard clickLoginWithSuccess(){
			loginButton.click();
			return PageFactory.initElements(scp.selenium.seleniumMeven.AppUtil.getWebdriver(),orangeHrmDashboard.class);
		}
		public String clickLoginWithError(){
			loginButton.click();
			return getErrorMessage();
		}

		public String getErrorMessage() {
				try{
					return errorMsg.getText();
				}catch(NoSuchElementException e){
					return null;
				}
					
				
		}
		
		public void clickLogin() {
			loginButton.click();
		}
		public void clear() {
			password.clear();
			username.clear();
		}
}
