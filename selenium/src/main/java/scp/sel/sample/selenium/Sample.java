package scp.sel.sample.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Sample {
	@Test
	public void m1() throws EncryptedDocumentException, InvalidFormatException, IOException {
		InputStream inputStream = new FileInputStream("C:\\Users\\VinodJagtap\\Desktop\\pst.xlsx");
        // Create a workbook object.
        Workbook wb = WorkbookFactory.create(inputStream);
        Sheet sheet = wb.getSheetAt(0);
        // Iterate over all the row and cells
        for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
            Row row = rit.next();
            for (Iterator<Cell> cit = row.cellIterator(); cit.hasNext();) {
                Cell cell = cit.next();
                
                // Print the each cell value
                System.out.println("Output : " + getCellValueAsString(cell));
            }
        }
    }
	 public static String getCellValueAsString(Cell cell) {
	        String strCellValue = null;
	        if (cell != null) {
	            switch (cell.getCellType()) {
	            case Cell.CELL_TYPE_STRING:
	                strCellValue = cell.toString();
	                break;
	            case Cell.CELL_TYPE_NUMERIC:
	                
	                strCellValue = cell.toString();
	                
	                break;
	            case Cell.CELL_TYPE_FORMULA:
	            	strCellValue = cell.toString();
	            	break;
	            
	            case Cell.CELL_TYPE_BOOLEAN:
	                strCellValue = new String(new Boolean(
	                        cell.getBooleanCellValue()).toString());
	                break;
	            case Cell.CELL_TYPE_BLANK:
	                strCellValue = "";
	                break;
	            }
	        }
	        return strCellValue;
	
	}

}
