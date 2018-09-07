package scp.selenium.seleniumMeven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSelenium {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.get("http://toolsqa.com/automation-practice-form/");
		Driver.manage().window().maximize();
		JavascriptExecutor jse =(JavascriptExecutor)Driver;
		jse.executeScript("scroll(0,600);");
		WebElement firstNameInput = Driver.findElement(By.name("firstname"));
		WebElement lastNameInput = Driver.findElement(By.name("lastname"));
		List<WebElement> genderType = Driver.findElements(By.name("sex"));
		List<WebElement> profession = Driver.findElements(By.name("profession"));
		WebElement continents = Driver.findElement(By.name("continents"));
		WebElement seleniumCommands = Driver.findElement(By.id("selenium_commands"));
		
		
		firstNameInput.sendKeys("prashant");
		lastNameInput.sendKeys("thorat");
		Thread.sleep(1500);
		String userChoice ="Male";
		for(WebElement gender:genderType) {
			if(gender.getAttribute("value").equals(userChoice)) {
				gender.click();
				break;
			}
		}
		Thread.sleep(1500);
		String [] userProf = {"Manual Tester","Automation Tester"};
		
		
		for (String item : userProf) {
			for (WebElement prof : profession) {
				if(prof.getAttribute("value").equals(item)){
					prof.click();
					break;
				}
		}
		}
		Thread.sleep(1500);
		
		String userContient ="South America";
		Select dropDown = new Select(continents);
		dropDown.selectByVisibleText(userContient);
		Thread.sleep(1500);
		
		String userContaints[] = {"Browser Commands","Wait Commands"};
		Select multiDropDown = new Select(seleniumCommands);
		for(String cmds: userContaints) {
			multiDropDown.selectByVisibleText(cmds);
		}
		//Driver.close();
	}

}
