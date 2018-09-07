package scp.selenium.seleniumMeven;

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

public class ReadTestDataFromExcel {
	public static void main(String[] args) throws InvalidFormatException, IOException {
		System.out.println(geTestDatas());
		
	}
	public static Object [][] convertTwoDimentionalArray() throws InvalidFormatException, IOException {
		List<userTestData> listOfScenarios= geTestDatas();
		Object[][] objs =new Object[listOfScenarios.size()][3];
		for(int i=0;i<listOfScenarios.size();i++) {
			userTestData testData = listOfScenarios.get(i);
			objs[i][0] = testData.getUserName();
			objs[i][1] = testData.getPassword();
			objs[i][2] = testData.getExpectedMsg();
					
		}
		
		return objs;
		
		
	}
	
	public static List<userTestData> geTestDatas() throws InvalidFormatException, IOException{
		File file = new File("C:\\Users\\Prashant\\Desktop\\Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.rowIterator();
		boolean isHeader = true;
		userTestData obj = null;
		List<userTestData> listOfScenarios =new ArrayList<userTestData>();
		while(rows.hasNext()) {
			Row row = rows.next();
			obj = new userTestData();
			if(isHeader){
				isHeader=false;
				continue;
			}
			Iterator<Cell> cells= row.cellIterator();
			int count=0;
			while(cells.hasNext()) {
				Cell cell = cells.next();
				if(count==0) {
					obj.setUserName(cell.getStringCellValue());
				}
				if(count==1) {
					obj.setPassword(cell.getStringCellValue());
				}
				if(count==2) {
					obj.setExpectedMsg(cell.getStringCellValue());
				}
				count++;
			}
			listOfScenarios.add(obj);
		}
		return listOfScenarios;
		
		
	}
	
	
	
	
}
class userTestData{
	String userName;
	String password;
	String expectedMsg;
	@Override
	public String toString() {
		return "\n userTestData [userName=" + userName + ", password=" + password + ", expectedMsg=" + expectedMsg + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExpectedMsg() {
		return expectedMsg;
	}
	public void setExpectedMsg(String expectedMsg) {
		this.expectedMsg = expectedMsg;
	}
	public userTestData() {
		super();
		this.userName = userName;
		this.password = password;
		this.expectedMsg = expectedMsg;
	}
	
}
