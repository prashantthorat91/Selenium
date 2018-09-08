package scp.web.pageobject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practice {
	public static void main(String[] args) throws IOException, NullPointerException {
		File file = new File("C:\\Users\\Prashant\\Desktop\\Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.getSheet("Sheet2");
		
		Row row = spreadsheet.createRow(7);
		Cell cellTilte =row.createCell(1);
		cellTilte.setCellValue("Address");
		
		
		 FileOutputStream out = new FileOutputStream(file);
	     workbook.write(out);
	     out.close();
	     System.out.println("Writesheet.xlsx written successfully");
	}
	

}
