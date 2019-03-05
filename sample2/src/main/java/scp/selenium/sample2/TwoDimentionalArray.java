package scp.selenium.sample2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoDimentionalArray {
	XSSFWorkbook workbook;
	File file;
	@DataProvider(name="data")
	public Object[][] getTestData() throws InvalidFormatException, IOException{
		file = new File("C:\\Users\\VinodJagtap\\Desktop\\pst.xlsx");
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row;
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row count is  :"+rowCount);
		Object[][] objs =new Object[rowCount][3];
		for (int i = 1; i <= rowCount; i++) {
			row= sheet.getRow(i);
	        objs[i-1][0] = row.getCell(0).getStringCellValue();
	        System.out.println(objs[i-1][0]);
	        objs[i-1][1] = row.getCell(1).getNumericCellValue();
	        System.out.println(objs[i-1][1]);
	        objs[i-1][2] = row.getCell(2).getStringCellValue();
	        System.out.println(objs[i-1][2]);
		}
		return objs;
		
	}
	@Test(dataProvider="data")
	public void verifyUserLoginCrentials(Object username,Object password, Object emsg) throws IOException {
		/*System.out.println(username);
		System.out.println(password);
		System.out.println(emsg);*/
		 FileOutputStream out = new FileOutputStream(file);
	     workbook.write(out);
	     out.close();
	     System.out.println("Writesheet.xlsx written successfully");
	}
	

	

}
