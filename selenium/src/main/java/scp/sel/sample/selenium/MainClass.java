package scp.sel.sample.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainClass {
	public static void main(String args[]) throws IOException, EncryptedDocumentException, InvalidFormatException {
		MainClass obj= new MainClass();
		
		obj.ReadNameFromExcel("C:\\Users\\VinodJagtap\\Desktop\\Test.xlsx");
	}
	
	public void ReadNameFromExcel(String filePath) throws IOException, EncryptedDocumentException, InvalidFormatException{
		   // File file =    new File(filePath+"\\"+fileName);
		    //FileInputStream inputStream = new FileInputStream(file);
			InputStream inputStream = new FileInputStream(filePath);
			Workbook book = WorkbookFactory.create(inputStream);
			//book = new XSSFWorkbook(inputStream);
		    //Workbook book = null;
		    /*String fileExtensionName = fileName.substring(fileName.indexOf("."));
		    if(fileExtensionName.equals(".xlsx")){
		    	
		    }
		    else if(fileExtensionName.equals(".xls")){
		    	book = new HSSFWorkbook(inputStream);
		    }*/
	        Sheet sheet = book.getSheetAt(4);
		    //Sheet sheet = book.getSheet(sheetName);
		    System.out.println("Getting row count from excel");
		    int rowCount = sheet.getLastRowNum();
		    Row row;
		   System.out.println("Row count="+rowCount);
	    for (int i = 0; i < rowCount+1; i++) {
	        row = sheet.getRow(i);
	        int num=row.getLastCellNum();
	        System.out.println("In for loop:");
	       // String Result=row.getCell(ExcelInfo.mainResult).getStringCellValue();
	        Cell cell = row.getCell(ExcelInfo.mainResult);
	        String Result = getCellValueAsString(cell);
	        
	        System.out.println("Result:"+Result);
	        
	        if(Result.trim().equalsIgnoreCase("NA"))
	        {
	       	
	        	System.out.println("Filling data");
	        	String Name=getCellValueAsString(row.getCell(ExcelInfo.mainFName));
	        	System.out.println("Name done");
	        	if(Name.contains("  ")) {
	        		Name = Name.replace("  ", " ");
	        	}
	        	if(Name.split(" ").length > 2) {
	        	System.out.println("FatherName From Name:"+Name.split(" ")[1]+" "+Name.split(" ")[2]);
	        	}
	            String fName=getCellValueAsString(row.getCell(ExcelInfo.mainFatherName));
	            //System.out.println("Father Name done");
	            String Village=getCellValueAsString(row.getCell(ExcelInfo.mainVillage));
	            //System.out.println("Village Name done");
	            String sNo=getCellValueAsString(row.getCell(ExcelInfo.mainSurveyNo));
	            System.out.println("Survey no done:-"+sNo);
	            String cast = getCellValueAsString(row.getCell(ExcelInfo.mainCategory));
	            //System.out.println("Cast done");
	            String latitude=getCellValueAsString(row.getCell(ExcelInfo.mainLatitude));
	            System.out.println("Latitude done");
	            String longi=getCellValueAsString(row.getCell(ExcelInfo.mainLongitude));
	            System.out.println("Longitude done"+longi);
	            String AdharNo=getCellValueAsString(row.getCell(ExcelInfo.mainAadhar));
	            System.out.println("Adhar No done"+AdharNo);
	            String NoOfFarmers=getCellValueAsString(row.getCell(ExcelInfo.mainNoOfFarmers));
	            //System.out.println("No of farmers done");
	            String Gen=getCellValueAsString(row.getCell(ExcelInfo.mainGender));
	            //System.out.println("Gender done");
	            String irrigated= getCellValueAsString(row.getCell(ExcelInfo.mainIrrgated));
	            System.out.println("Irrigated done");
	            String irrigationSource= getCellValueAsString(row.getCell(ExcelInfo.mainIrrigationSource));
	            //System.out.println("Irrigation SOurce done");
	          
	            System.out.println("All data read done");
	        }
	        
	    }
	    
	
	
	    book.close();
}
	public String getCellValueAsString(Cell cell) {
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
