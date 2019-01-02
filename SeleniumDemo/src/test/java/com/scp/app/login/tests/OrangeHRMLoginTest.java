package com.scp.app.login.tests;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scp.app.constants.AppConstants;
import com.scp.app.constants.AppConstants.BrowserNames;
import com.scp.app.util.AppUtil;
import com.scp.app.web.pageobjects.OrangeHRMLogin;

public class OrangeHRMLoginTest {

	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		WebDriver driver = AppUtil.initializeBrowser(BrowserNames.Chrome, AppConstants.ORANGE_HRM_APP_URL);
		
		
		OrangeHRMLogin page = PageFactory.initElements(driver, OrangeHRMLogin.class);
		
		/*File file = new File("C:\\Users\\Prashant\\Desktop\\Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		System.out.println(workbook.getNumberOfSheets());
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
		for(int i=1;i<rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			
			
		try {
			for(int j=0;j<row.getLastCellNum();j++) {
				if(j==0) {
					page.enterUserName(row.getCell(j).getStringCellValue());
				}else if (j==1) {
					page.enterPassword(row.getCell(j).getStringCellValue());
				}
				page.clickLogin();
				try {
					driver.findElement(By.id("spanMessage"));
					System.out.println("Invalid username or password");
				}catch(Exception e){
					System.out.println("ligin success");
				}
				
			}
			
		}catch(Exception e) {
			
		}
		}*/
		page.enterUserName("Admin");
		page.enterPassword("admin123");
		page.clickLogin();
		
	}
	
	
	
	
}
