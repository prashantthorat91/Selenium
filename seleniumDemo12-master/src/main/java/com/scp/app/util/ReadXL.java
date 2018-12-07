package com.scp.app.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL {
	private static void readExcel() throws InvalidFormatException, IOException {
		
		File file = new File("C:\\Users\\Prashant\\Desktop\\ExcelToUpload\\A.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()){
					Row row = rows.next();
					if(row.getCell(ExcelInfo.mainResult).getStringCellValue().equalsIgnoreCase("NA"))
			        {
			        	
			        	System.out.println("Filling data");
			        	String Name=row.getCell(ExcelInfo.mainFName).getStringCellValue();
			            String fName=row.getCell(ExcelInfo.mainFatherName).getStringCellValue();
			            String Village=row.getCell(ExcelInfo.mainVillage).getStringCellValue();
			            String sNo=Double.toString(row.getCell(ExcelInfo.mainSurveyNo).getNumericCellValue());
			            String cast = row.getCell(ExcelInfo.mainCategory).getStringCellValue();
			            String latitude=Double.toString(row.getCell(ExcelInfo.mainLatitude).getNumericCellValue());
			            String longi=Double.toString(row.getCell(ExcelInfo.mainLongitude).getNumericCellValue());
			            String AdharNo=Double.toString(row.getCell(ExcelInfo.mainAadhar).getNumericCellValue());
			            String Crop=row.getCell(ExcelInfo.mainCrop).getStringCellValue();
			            String NoOfFarmers=Integer.toString((int)row.getCell(ExcelInfo.mainNoOfFarmers).getNumericCellValue());
			            String Gen=row.getCell(ExcelInfo.mainGender).getStringCellValue();
			            String CropGroup=row.getCell(ExcelInfo.mainCropGroup).getStringCellValue();
			            System.out.println(NoOfFarmers);
			          
			        }
		            
		}

		
	}
	public static void main(String[] args) throws InvalidFormatException, IOException {
		readExcel();
	}

}
