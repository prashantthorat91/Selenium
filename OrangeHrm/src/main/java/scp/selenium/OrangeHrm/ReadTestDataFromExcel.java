package scp.selenium.OrangeHrm;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestDataFromExcel {
	public static void main(String[] args) throws InvalidFormatException, IOException {
		//ReadTestDataFromExcel.getTestData();
		ReadTestDataFromExcel.testData();
		
		//
	}
	public static Object[][] getTestData() throws InvalidFormatException, IOException{
		File file = new File("C:\\Users\\Prashant\\Desktop\\Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row;
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		Object[][] objs =new Object[rowCount][3];
		for (int i = 1; i < rowCount+1; i++) {
			row= sheet.getRow(i);
			
	        objs[i-1][0] = row.getCell(0).getStringCellValue();
	        System.out.println(objs[i-1][0]);
	        objs[i-1][1] = row.getCell(1).getStringCellValue();
	        System.out.println(objs[i-1][1]);
	        objs[i-1][2] = row.getCell(2).getStringCellValue();
	        System.out.println(objs[i-1][2]);
	        
	        
	        
		}
		System.out.println(objs);
		return objs;
		
	}
	public static Object[][] testData() throws InvalidFormatException, IOException{
		File file = new File("C:\\Users\\Prashant\\Desktop\\Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row;
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		Object[][] objs =new Object[rowCount][3];
		Iterator<Row> rows = sheet.rowIterator();
		int rowNo=0;
		while(rows.hasNext()) {
			Row row1 = rows.next();
			String userName,password,message;
			userName=row1.getCell(0).getStringCellValue();
			password=row1.getCell(1).getStringCellValue();
			message=row1.getCell(2).getStringCellValue();
			if(userName.equals("username")&&password.equals("password")&&message.equals("message")){
				continue;
			}else {
				objs[rowNo][0]=userName;
				objs[rowNo][1]=password;
				objs[rowNo][2]=message;
				rowNo++;
			}
			System.out.println(objs);
			
		}
		return null;
		
	}

}
