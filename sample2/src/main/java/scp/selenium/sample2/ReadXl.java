package scp.selenium.sample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class ReadXl {

		public static void main(String[] args) throws IOException {
			System.setProperty("webdriver.chrome.driver","E:\\Prashant\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
			File file= new File("C:\\Users\\VinodJagtap\\Desktop\\ABC.xlsx");
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook workbook = null;
		    workbook = new XSSFWorkbook(inputStream);
		    Sheet sheet = workbook.getSheet("Sheet1");
		    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		    Row row;
		    List<Employee> list = new ArrayList<Employee>();
		    row =sheet.getRow(0);
		    int userNameCol=0,passwordCol=0,expectedCol=0, statusCol=0;
		    for(int i=0;i<4;i++) {
		    	String s= row.getCell(i).getStringCellValue();
		    	if(s.equalsIgnoreCase("UserName")) {
		    		userNameCol = i;
		    	}
		    	else if(s.equalsIgnoreCase("Password")) {
		    		passwordCol=i;
		    		}
		    	else if(s.equalsIgnoreCase("Status")) {
		    		statusCol=i;
		    		}
		    	else if(s.equalsIgnoreCase("Expected")) {
		    		expectedCol =i;
		    		}
		    }
		    for (int i = 1; i < rowCount+1; i++) {
		    	WebDriver driver = new ChromeDriver();
		    	driver.get("https://opensource-demo.orangehrmlive.com/");
		    	
		        row = sheet.getRow(i);
		        //list.add(new Employee(row.getCell(nameCol).getStringCellValue(), (int)row.getCell(idCol).getNumericCellValue(), (long)row.getCell(mobileCol).getNumericCellValue(), row.getCell(statusCol).getStringCellValue()));
		      try {
		    	  String userName =row.getCell(userNameCol).getStringCellValue();
		    	  System.out.println("userName is: "+userName);
		    	  String password = row.getCell(passwordCol).getStringCellValue();
		    	  System.out.println("password is : "+password);
		    	  String expectedResult =row.getCell(expectedCol).getStringCellValue();
		    	  System.out.println("Expected result is : "+expectedResult);
		        driver.findElement(By.id("txtUsername")).sendKeys(userName);
		        driver.findElement(By.id("txtPassword")).sendKeys(password);
		        driver.findElement(By.name("Submit")).click();
		        String welcome = driver.findElement(By.xpath("//a[text()='Welcome Admin']")).getText();
		        System.out.println(welcome);
		        if((row.getCell(expectedCol).getStringCellValue().equals(welcome)))
		        row.getCell(statusCol).setCellValue("PASS");
		        else {
		        	row.getCell(statusCol).setCellValue("FAIL");
		        }
		        
		      }
		      catch(Exception e) {
		    	  String errormsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
			        System.out.println(errormsg);
			        if((row.getCell(expectedCol).getStringCellValue().equals(errormsg)))
				        row.getCell(statusCol).setCellValue("PASS");
			        else {
			        	row.getCell(statusCol).setCellValue("FAIL");
			        }
			        
		      }		        
		        driver.close();
		        FileOutputStream fos = new FileOutputStream(file);
		        workbook.write(fos);
	     		fos.close();
		    }
		   /* System.out.println(list.size());
		    Iterator itr = list.iterator();
		    while(itr.hasNext()) {
		    	Employee e=(Employee) itr.next();
		    	System.out.println("name= "+e.getName()+" ID= "+e.getId()+" Mobile= "+e.getMobile()+" Status= "+e.getResult());
		    }*/

		}


	}
	class Employee{
		private String name;
		private int Id;
		private long mobile;
		private String result;
		
		Employee(String name1, int Id1, long mobile1, String status){
			name=name1;
			Id=Id1;
			mobile=mobile1;
			result= status;
		}

		@Override
		public String toString() {
			return "Employee [\n name=" + name + ", Id=" + Id + ", mobile=" + mobile + ", result=" + result + "]";
		}

		public String getName() {
			return name;
		}

		public int getId() {
			return Id;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public long getMobile() {
			return mobile;
		}

		
	


}
