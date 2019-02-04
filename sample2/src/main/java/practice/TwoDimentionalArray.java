package practice;

import java.io.File;
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
	public Object[][] readData() throws InvalidFormatException, IOException{
		file = new File("C:\\Users\\VinodJagtap\\Desktop\\pst.xlsx");
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int rowCount = sheet.getLastRowNum();
		Object[][] obj = new Object[rowCount][3];
		for(int i=1;i<=rowCount;i++) {
			Row row = sheet.getRow(i);
			obj[i-1][0] = row.getCell(0).getStringCellValue();
			obj[i-1][1] = row.getCell(1).getNumericCellValue();
			obj[i-1][2] = row.getCell(2).getStringCellValue();
					
		}
		return obj;
		
	}
	@Test(dataProvider = "data")
	public void getdata(Object uname, Object pwd, Object emsg) {
		System.out.println("userName : "+uname);
		System.out.println("Passwrd : "+pwd);
		System.out.println("Expected msg : "+emsg);
	}

}
