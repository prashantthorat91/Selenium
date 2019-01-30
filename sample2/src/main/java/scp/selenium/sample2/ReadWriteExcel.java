
package scp.selenium.sample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ReadWriteExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		readExcel();

	}
	public static void readExcel() throws InvalidFormatException, IOException {
		File file = new File("C:\\Users\\VinodJagtap\\Desktop\\test2.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows =sheet.rowIterator();
		while(rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()) {
				Cell cell = cells.next();
				if(cell.getCellType()==0) {
				System.out.println(cell.getNumericCellValue());
				//System.out.println("cell type is : "+cell.getCellType());
				}else {
					String str = cell.getStringCellValue();
					if(str.equals("prashant")) {
						cell.setCellValue("xxxxxx");
					}
					System.out.println(str);
					//System.out.println("cell type is : "+cell.getCellType());
				}
			}
			FileOutputStream out = new FileOutputStream(file);
		     workbook.write(out);
		     out.close();
		     System.out.println("Writesheet.xlsx written successfully");
		}
		
		
		
		
	}

}
