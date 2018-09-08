package scp.web.pageobject;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orangeHrmDashboard {
	@FindBy(id="welcome")
	WebElement welcomeAdmin;
	
	public String getWelcomeMsg() {
		try {
			return welcomeAdmin.getText();
		}catch(NoSuchElementException e) {
			return null;
		}
		
		
	}

}
