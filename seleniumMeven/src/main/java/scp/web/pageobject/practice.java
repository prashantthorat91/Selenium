package scp.web.pageobject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practice {
	public static void main(String[] args) throws InvalidFormatException, IOException {
		practice.readWrite();
	}
	
	public static void readWrite() throws InvalidFormatException, IOException {

		File file = new File("C:\\Users\\Prashant\\Desktop\\PST.xlsx");		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		System.out.println("test");
		List<String> list = new ArrayList<>();
		
	/*	XSSFSheet spreadsheet = workbook.getSheet("Sheet2");
		
		Row row = spreadsheet.createRow(7);
		Cell cellTilte =row.createCell(1);
		cellTilte.setCellValue("Address");
		
		
		 FileOutputStream out = new FileOutputStream(file);
	     workbook.write(out);
	     out.close();
	     System.out.println("Writesheet.xlsx written successfully");*/
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
		Iterator<Row> rows = sheet.iterator();
		while(rows.hasNext()) {
			Row row = rows.next();
			int count =0;
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()) {
				Cell cell= cells.next();
				if(count==0) {
					list.add(cell.getStringCellValue());
					//System.out.println(cell.getStringCellValue());
				}
				if(count==1) {
					Cell cellForId=	row.createCell(1);
			    	Cell cellForFirstName = row.createCell(2);
			    	cellForId.setCellType(0);
			    	cellForFirstName.setCellType(1);
			    	cellForId.setCellValue("102");
			    	cellForFirstName.setCellValue("prashant");
				}
				count++;
				
				
			}
		}
		 try {
	            FileOutputStream outputStream = new FileOutputStream(file);
	            workbook.write(outputStream);
	            workbook.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Done");
	    
	}

}
