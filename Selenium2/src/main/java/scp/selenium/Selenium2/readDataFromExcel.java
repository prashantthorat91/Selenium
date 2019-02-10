package scp.selenium.Selenium2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readDataFromExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		readData();

	}
	static void readData() throws InvalidFormatException, IOException {
		//ArrayList<String> str = new ArrayList<String>();
		List<String> str= new ArrayList<String>();
		File file = new File("C:\\Users\\Prashant\\Desktop\\Login.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			int count=0;
			while(cells.hasNext()) {
				Cell cell = cells.next();
				if(count==0)
					System.out.println(cell.getStringCellValue());
				if(count==1)
					System.out.println(cell.getStringCellValue());
					str.add(cell.getStringCellValue());
			}
		}
		System.out.println(str);
	}

}
