package scp.selenium.seleniumMeven;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		read r = new read();
		r.readExcel();
	}


}
class read{
	public void readExcel() throws InvalidFormatException, IOException {
		File file = new File("C:\\Users\\Prashant\\Desktop\\ABC.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		System.out.println(workbook.getNumberOfSheets());
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
		System.out.println("Count of row is "+rowCount);
		for(int i=0;i<rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			
		try {
			for(int j=1;j<row.getLastCellNum();j++) {
				XSSFCell str = row.getCell(j);
				System.out.println(str);
			}
			
		}catch(Exception e) {
			
		}
		}
		Iterator<Row> rows = sheet.rowIterator();
		DataFormatter dataFormatter = new DataFormatter();
		/*while(rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()) {
				Cell cell = cells.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.println(cellValue);
			}
		}*/
	}

	private char[] rowCount(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
class write{
	
}
