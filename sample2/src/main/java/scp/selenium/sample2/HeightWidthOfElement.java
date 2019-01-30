package scp.selenium.sample2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeightWidthOfElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","I:\\Software\\selenium\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.orangehrm.com/solutions/professional/demo/";
        driver.get(baseUrl);
        WebElement image = driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]/a"));
        Dimension d = image.getSize();
        int height = d.height;
        int width = d.width;
        System.out.println("Height : "+height+"\nWidth : "+width);
        List<WebElement> frame = driver.findElements(By.tagName("iframe"));
        System.out.println("No. of frames are : "+frame.size());

	}

}
