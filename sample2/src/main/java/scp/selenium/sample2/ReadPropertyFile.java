package scp.selenium.sample2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropertyFile {
	public static void main(String[] args) throws IOException {
		//File src = new File("./propertyFiles/Configuration.property");
		FileInputStream file = new FileInputStream("./propertyFiles/Configuration.property");
		Properties property = new Properties();
		property.load(file);
		String chromepath= property.getProperty("ChromeDriver");
		System.out.println(chromepath);
		/*Properties property = new Properties();
		property.load(file);
		String chromePath= property.getProperty("ChromeDriver");
		System.out.println("chromePath is== "+chromePath);
		System.setProperty("webdriver.chrome.driver",chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get(property.getProperty("FreeCrmUrl"));*/
		
		//ReadPropertyFile.readXML();
		
		
	}
/*	public static void readXML() throws FileNotFoundException, DocumentException {
		FileInputStream file = new FileInputStream("./propertyFiles/Configuration.xml");
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		String chromePath= document.selectSingleNode("//menu/ChromeDriver").getText();
		System.out.println("path is : "+chromePath);
	}*/

}
