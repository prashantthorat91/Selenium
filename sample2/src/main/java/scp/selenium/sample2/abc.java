package scp.selenium.sample2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class abc {
	

	@Test
	public void readExcel() throws InvalidFormatException, IOException {
		File file = new File("C:\\Users\\Prashant\\Desktop\\ABC.xlsx");		
		XSSFWorkbook book = new XSSFWorkbook(file);
		List<List<String>> mainList= new ArrayList<List<String>>();
		XSSFSheet sheet = book.getSheet("Sheet1");
		Iterator<Row> rows = sheet.iterator();
		while(rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			int count =0;
			List<String> list = new ArrayList<>();
			
			while(cells.hasNext()) {
				Cell cell = cells.next();
				
				/*switch(count) {
				case 0:
					
				case 1:
					
				}*/
				
				if(count==0) {
					list.add(cell.getStringCellValue());
					//System.out.println(cell.getStringCellValue());
				}
				if(count==1) {
					list.add(cell.getStringCellValue());
					//System.out.println(cell.getStringCellValue());
				}
				if(count==2) {
					list.add(Double.toString(cell.getNumericCellValue()));
					//System.out.println(cell.getNumericCellValue());
				}
				
				count++;
				
			}
			mainList.add(list);
			//System.out.println(list);
		}
		for(List i : mainList) {
			System.out.println(i);
			System.out.println("\n");
		}
		
		
	}

}
