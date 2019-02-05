import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ReadDataFromExcel {
	static Date Date_of_soil_sampling;
	public static String DIST , BLOCK , DATE_OF_DATA_ENTRY, SUBDIST, VILLAGE, CROPGROUP, ADHAR_NO;

	public static String CROP , DURATION , REF_YIELD , UNIT1 , CROP_SEASON , SURVEY_NO;
	static RichTextString VARIETY , CYCLE;
	static double AREA_UNDER_CULTIVATION , NO_OF_FARMERS_IN_GRID  , FARM_SIZE , LATITUDE , LONGITUDE;
	
	public static String NAME , FATHER_NAME , CATEGORY , GENDAR , UNIT2 , SOIL_TYPE , IRRIGATED , IRRIGATION_SOURSE , INVALID_ADHAR;
	public static boolean flag=false;
    public void readExcel(String filePath,String fileName,String sheetName, WebDriver driver,String date) throws Exception{
	//public void readExcel(String filePath,String sheetName, WebDriver driver) throws Exception{
    //Create an object of File class to open xlsx file
    File file =    new File(filePath+"\\"+fileName);
    //Create an object of FileInputStream class to read excel file
    FileInputStream inputStream = new FileInputStream(file);
	Workbook book = WorkbookFactory.create(inputStream);
    //Workbook book = null;
    //Find the file extension by splitting file name in substring  and getting only extension name
    /*String fileExtensionName = fileName.substring(fileName.indexOf("."));
    //Check condition if the file is xlsx file
    if(fileExtensionName.equals(".xlsx")){
    //If it is xlsx file then create object of XSSFWorkbook class
    	book = new XSSFWorkbook(inputStream);
    }
    //Check condition if the file is xls file
    else if(fileExtensionName.equals(".xls")){
        //If it is xls file then create object of XSSFWorkbook class
    	book = new HSSFWorkbook(inputStream);
    }*/
    //Read sheet inside the workbook by its name
	
    Sheet sheet = book.getSheet(sheetName);
    //Find number of rows in excel file
    System.out.println("Getting row count from excel");
    int rowCount = sheet.getLastRowNum();
    Row row;
    //Create a loop over all the rows of excel file to read it
    for (int i = 0; i < rowCount+1; i++) {
        row = sheet.getRow(i);
        int num=row.getLastCellNum();
        //Create a loop to print cell values in a row
        //if(! row.getCell(26).getStringCellValue().equalsIgnoreCase("Done") || ! row.getCell(26).getStringCellValue().equalsIgnoreCase("INVALID"))
        Cell cell = row.getCell(ExcelInfo.mainResult);
        String Result = getCellValueAsString(cell);
        if(Result.trim().equalsIgnoreCase("NA"))
        {
        	try {
        	System.out.println("Filling data");
        	String Name=getCellValueAsString(row.getCell(ExcelInfo.mainFName));
        	String fName=getCellValueAsString(row.getCell(ExcelInfo.mainFatherName));
            String Village=getCellValueAsString(row.getCell(ExcelInfo.mainVillage));
            String sNo=getCellValueAsString(row.getCell(ExcelInfo.mainSurveyNo));
            String cast = getCellValueAsString(row.getCell(ExcelInfo.mainCategory));
            String latitude=getCellValueAsString(row.getCell(ExcelInfo.mainLatitude));
            String longi=getCellValueAsString(row.getCell(ExcelInfo.mainLongitude));
            String AdharNo=getCellValueAsString(row.getCell(ExcelInfo.mainAadhar));
            String NoOfFarmers=Double.toString(row.getCell(ExcelInfo.mainNoOfFarmers).getNumericCellValue());
            String Gen=getCellValueAsString(row.getCell(ExcelInfo.mainGender));
            String irrigated= getCellValueAsString(row.getCell(ExcelInfo.mainIrrgated));
            String irrigationSource= getCellValueAsString(row.getCell(ExcelInfo.mainIrrigationSource));
            System.out.println("All data read done");
            AddMainFarmers(flag,driver,Name,fName,Village,sNo,cast,latitude,longi,AdharNo,NoOfFarmers,Gen,irrigated,irrigationSource,date);
            
            writeResult(driver,row,file,book);
            
            int n=0;
            if(NoOfFarmers.contains(".")) {
        		n=Integer.parseInt(NoOfFarmers.split("\\.")[0]);
        		System.out.println("n="+n);
        		
        	}else {
        		n=Integer.parseInt(NoOfFarmers);
        		System.out.println("n="+n);
        	}
            AddFarmers(n-1,row,driver,file,book);
            
            if(flag) {
            	//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            	//driver.findElement(By.id("new")).click();
            }
            else {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
            
            driver.findElement(By.xpath("//a[@href='/SampleReg/SampleRegistrationMenuPage/SampleRegistrationMenuPage/SimpleNew']")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//img[@src='/Content/image/new.png']")).click();
	        Thread.sleep(2000);
            }
	        
        	}catch(Exception e) {
        		System.out.println("In Catch:-"+e.getMessage());
        		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
                driver.findElement(By.xpath("//a[@href='/SampleReg/SampleRegistrationMenuPage/SampleRegistrationMenuPage/SimpleNew']")).click();
    	        Thread.sleep(5000);
    	        driver.findElement(By.xpath("//img[@src='/Content/image/new.png']")).click();
    	        Thread.sleep(2000);
        	}
          
        }
        }
    
    
    }
    
    
    public void AddMainFarmers(Boolean falg,WebDriver driver,String name,String fatherName,String Village,String surveyNo,String Category,String latitude,String longitude,String adharNo,String noOfFarmers,String Gender,String Irrigated,String IrrigationSouce,String date) throws IOException, InterruptedException {
        Double area= 0.5;
    	
    	int Date_of_soil_sampling = 15;
    	System.out.println("In add main farmer");
    	if(!falg) {
    		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    		//LocalDate localDate = LocalDate.now();
    		
    		
    		//String d= dtf.format(localDate);
    		String d = date;
    		String year1 = d.split("/")[0];
    		String month1 = d.split("/")[1];
    		String day = d.split("/")[2];
    		System.out.println(year1+":"+month1+":"+day);
    		System.out.println("Flase flag");
    	  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
       // DateFormat df = new SimpleDateFormat("MM/dd/yyyy");        
        driver.findElement(By.id("Sample_date")).click();
        Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
        year.selectByVisibleText(year1);
        Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
        month.selectByIndex(Integer.parseInt(month1)-1);
        Thread.sleep(3000);
        WebElement dateWidgetFrom = driver.findElement(By.xpath(".//*[@class='ui-datepicker-calendar']/tbody"));
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            if (cell.getText().equals(day)) {
                cell.click();
                break;
            }
        }
       
        
        Select cycle = new Select(driver.findElement(By.name("CycleId")));
        cycle.selectByIndex(2);
        
        Select dist = new Select(driver.findElement(By.name("Dist_cd")));
        dist.selectByVisibleText("Satara");
        
        Select block = new Select(driver.findElement(By.id("Block_cd")));
        block.selectByVisibleText("Wai");
        
        Select subdist = new Select(driver.findElement(By.name("Sub_dis")));
        subdist.selectByVisibleText("Wai");
        
        
        
        Thread.sleep(10000);
        Select village = new Select(driver.findElement(By.id("village_cd")));
        village.selectByVisibleText(Village.trim());
        
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        driver.findElement(By.id("btn_addcrop1")).click();
    	
        AddCrop(driver);
    	}
      //  NumberFormat nf = DecimalFormat.getInstance();
      //  nf.setMaximumFractionDigits(0);
      //  String str = nf.format(NO_OF_FARMERS_IN_GRID);
    	
    	
    	System.out.println("No of farmers in grid:"+noOfFarmers);
    	if(noOfFarmers.contains(".")) {
    		driver.findElement(By.id("TotalFarmerCount")).clear();
    		System.out.println("String contains .");
    		String n=noOfFarmers.split("\\.")[0];
    		System.out.println("String contains ."+n);
    		driver.findElement(By.id("TotalFarmerCount")).sendKeys(n);
    	}else {
    		System.out.println("String not contains .");
    		driver.findElement(By.id("TotalFarmerCount")).clear();
    		driver.findElement(By.id("TotalFarmerCount")).sendKeys(noOfFarmers);
    	}
    	
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        driver.findElement(By.id("btn_addFarmer")).click();
        driver.findElement(By.id("F_Name")).clear();
        driver.findElement(By.id("F_Name")).sendKeys(name);
        try {
            if(name.contains("  ")) {
            	name = name.replace("  ", " ");
        	}
        	if(name.split(" ").length > 2) {
        		String FatherName= name.split(" ")[1]+" "+name.split(" ")[2];
        		driver.findElement(By.id("Father_Name")).clear();
                driver.findElement(By.id("Father_Name")).sendKeys(FatherName);
        	//System.out.println("FatherName From Name:"+Name.split(" ")[1]+" "+Name.split(" ")[2]);
        	}
        	}catch(Exception e){System.out.println("Exception in set Father Name");}
        String CATEGORY = Category;
        Select category = new Select(driver.findElement(By.id("Category_Code")));
        if(CATEGORY.toLowerCase().equals("gn"))
        {
        	category.selectByIndex(1);
        }
        else if(CATEGORY.toLowerCase().equals("obc"))
        {
        	category.selectByIndex(2);
        }
        else if(CATEGORY.toLowerCase().equals("sc"))
        {
        	category.selectByIndex(3);
        }
        else if(CATEGORY.toLowerCase().equals("st"))
        {
        	category.selectByIndex(4);
        }
        else
        {
        	System.out.print("\n Invalid CATEGORY = "+ CATEGORY);
        }
        
        String GENDAR = Gender;
        if(GENDAR.toLowerCase().equals("male") || GENDAR.toLowerCase().equals("m"))
        {
        	driver.findElement(By.xpath("//input[@id='Gender' and @value='M']")).click();
        }
        else if(GENDAR.toLowerCase().equals("female") || GENDAR.toLowerCase().equals("f"))
        {
        	driver.findElement(By.xpath("//input[@id='Gender' and @value='F']")).click();
        }
        String ADHAR_NO = adharNo;
        if(ADHAR_NO.length() == 12)
        {
        driver.findElement(By.id("uid")).sendKeys(ADHAR_NO);
        
        driver.findElement(By.id("IsAgree")).click();
    	}
        
        String SURVEY_NO = surveyNo;
        if(!SURVEY_NO.equals("NA")){
        	driver.findElement(By.id("SurveyNo")).clear();
        driver.findElement(By.id("SurveyNo")).sendKeys(SURVEY_NO);
        }
        Double FARM_SIZE  = area;
        driver.findElement(By.id("Area_Land")).clear();
        driver.findElement(By.id("Area_Land")).sendKeys(Double.toString(FARM_SIZE));
        
        String UNIT2 = "hectares";
        Select unit2 = new Select(driver.findElement(By.id("Area_Land_Unit")));
        if(UNIT2.toLowerCase().equals("acre"))
        {
        	unit2.selectByIndex(1);
        }
        else if(UNIT2.toLowerCase().equals("hectares"))
        {
        	unit2.selectByIndex(2);
        }
        
        String SOIL_TYPE = "Medium black soil";
        Select soiltype = new Select(driver.findElement(By.id("Soil_Type")));
        soiltype.selectByVisibleText(SOIL_TYPE.trim());
        
        
        Select irrigated = new Select(driver.findElement(By.id("Irrigation_Facility")));
        if(Irrigated.toLowerCase().equals("irrigated"))
        {
        	irrigated.selectByIndex(1);
        }
        else if(Irrigated.toLowerCase().equals("rainfed"))
        {
        	irrigated.selectByIndex(2);
        }
        Thread.sleep(7000);
        
        Select irrigationsource = new Select(driver.findElement(By.id("Irrigation_Method")));
        
        if(IrrigationSouce.toLowerCase().equals("borewell"))
        {
        	irrigationsource.selectByIndex(1);
        }
        else if(IrrigationSouce.toLowerCase().equals("canal"))
        {
        	irrigationsource.selectByIndex(2);
        }
        else if(IrrigationSouce.toLowerCase().equals("others"))
        {
        	irrigationsource.selectByIndex(3);
        }
        else if(IrrigationSouce.toLowerCase().equals("pond"))
        {
        	irrigationsource.selectByIndex(4);
        }
        else if(IrrigationSouce.toLowerCase().equals("tube well"))
        {
        	irrigationsource.selectByIndex(5);
        }
        else if(IrrigationSouce.toLowerCase().equals("well"))
        {
        	irrigationsource.selectByIndex(6);
        }
        else if(IrrigationSouce.toLowerCase().equals("na"))
        {
        	
        }
        else
        {
        	irrigationsource.selectByIndex(3);
        }
        
        String LATITUDE = latitude;
        driver.findElement(By.id("LatitudeNew")).clear();
        driver.findElement(By.id("LatitudeNew")).sendKeys(LATITUDE);
        String LONGITUDE = longitude;
        driver.findElement(By.id("LongitudeNew")).clear();
        driver.findElement(By.id("LongitudeNew")).sendKeys(LONGITUDE);
        
        
        driver.findElement(By.id("save")).click();
        Thread.sleep(20000);
       
        
    }
   
    public void writeResult(WebDriver driver,Row row,File file,Workbook book) throws IOException, InterruptedException {
    	try {
    		try {
    			 if(driver.findElement(By.id("successMessage")).isDisplayed()) {
    		         	row.getCell(ExcelInfo.mainResult).setCellType(row.getCell(ExcelInfo.mainResult).CELL_TYPE_STRING);
    		             System.out.print("\n Writing registration number");
    		             row.getCell(ExcelInfo.mainResult).setCellValue(driver.findElement(By.id("successMessage")).getText().trim().split("Id:")[1]);
    		     		FileOutputStream fos = new FileOutputStream(file);
    		     		book.write(fos);
    		     		fos.close();
    		         	
    		         }
    		}catch(Exception e) {System.out.println("Write Result Failed 1");}
    		if(driver.findElement(By.className("ErrorMessage")).isDisplayed()) {
    			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            	driver.findElement(By.id("btn_addFarmer")).click();
            	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                driver.findElement(By.id("uid")).clear();
                driver.findElement(By.id("IsAgree")).click();
                
                driver.findElement(By.id("save")).click();
                Thread.sleep(20000);
                row.getCell(ExcelInfo.mainResult).setCellType(row.getCell(ExcelInfo.mainResult).CELL_TYPE_STRING);
                System.out.print("\n Writing registration number");
                row.getCell(ExcelInfo.mainResult).setCellValue(driver.findElement(By.id("successMessage")).getText().trim().split("Id:")[1]);
        		FileOutputStream fos = new FileOutputStream(file);
        		book.write(fos);
        		fos.close();
    		}
    	}catch(Exception e) {
    		System.out.println("Write Result Failed 2");
    	}
    }
    public void AddCrop(WebDriver driver) throws InterruptedException, IOException {
    	File file =    new File(".\\"+"crop.xlsx");
    	//File file =    new File("C:\\Users\\VinodJagtap\\Desktop\\SoilHealthFinal\\"+"crop.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook book = null;
        book = new XSSFWorkbook(inputStream);
        Sheet sheet = book.getSheet("Sheet1");
        Row row=null;
        row = sheet.getRow(0);
        Double noOfCrops=  row.getCell(0).getNumericCellValue();
        for(int i=0;i<noOfCrops;i++) {
        	
        int cropCol=(int) (ExcelInfo.crop+(i*4));
        int cropGroupCol=(int) (ExcelInfo.cropGroup+(i*4));
        int durationCol=(int) (ExcelInfo.duration+(i*4));
        int seasonCol=(int) (ExcelInfo.cropSeason+(i*4));
        
    	String crop=row.getCell(cropCol).getStringCellValue();
        String cropGroup=row.getCell(cropGroupCol).getStringCellValue();
        String Duration = row.getCell(durationCol).getStringCellValue();
        String CropSeason = row.getCell(seasonCol).getStringCellValue();
         
    	Select CropGroup = new Select(driver.findElement(By.id("Crop_Season_F")));
        CropGroup.selectByVisibleText(cropGroup.trim());
        Thread.sleep(4000);
        Select Crop = new Select(driver.findElement(By.id("Crop_cd_F")));
        Crop.selectByVisibleText(crop.trim());
        
        Select Crop_Duration = new Select(driver.findElement(By.id("Duration_F")));
        if(Duration.equalsIgnoreCase("annual")) {
        	Crop_Duration.selectByIndex(1);
        } else if(Duration.equalsIgnoreCase("long")){
        	Crop_Duration.selectByIndex(2);
        }
        else if(Duration.equalsIgnoreCase("medium")){
        	Crop_Duration.selectByIndex(3);
        }else if(Duration.equalsIgnoreCase("other")){
        	Crop_Duration.selectByIndex(4);
        }else if(Duration.equalsIgnoreCase("perennial")){
        	Crop_Duration.selectByIndex(5);
        }else if(Duration.equalsIgnoreCase("short")){
        	Crop_Duration.selectByIndex(6);
        }else{
        	Crop_Duration.selectByIndex(4);
        }
        
        Select Crop_Season = new Select(driver.findElement(By.id("CropSeasonCode")));
        if(CropSeason.equalsIgnoreCase("summar")) {
        	
        	Crop_Season.selectByIndex(1);
        } else if(CropSeason.equalsIgnoreCase("kharif")){
        	Crop_Season.selectByIndex(2);
        }else{
        	Crop_Season.selectByIndex(3);
        }
        
        
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        Thread.sleep(2000);
        driver.findElement(By.id("btn_addcrop")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        driver.findElement(By.id("btn_addcrop1")).click();
        }
        book.close();
        inputStream.close();
       
    }
    
    
    public void AddFarmers(int noOfFarmers,Row r,WebDriver driver,File f,Workbook w) throws IOException {
    	int farmerNum = 1;
    	System.out.println("In Add Farmer:No of farmers:-"+noOfFarmers);
    	int columnNo = ExcelInfo.mainResult;
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	outerloop:
    	for(int i=0;i<noOfFarmers;i++) {
    		try {
    			Thread.sleep(5000);
    			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    			driver.findElement(By.id("btn_addFarmer")).click();
    		for(int j=1;j<=5;j++) {
    			if(r.getCell(columnNo+((farmerNum)*6)).getStringCellValue().equals("NA"))
    			{
    			if(j==1) {
            		String NAME = r.getCell(columnNo+j+((farmerNum-1)*6)).getStringCellValue();
    	            
    	            driver.findElement(By.id("F_Name")).sendKeys(NAME);
    	            
    	            try {
    	            if(NAME.contains("  ")) {
    	            	NAME = NAME.replace("  ", " ");
    	        	}
    	        	if(NAME.split(" ").length > 2) {
    	        		String FatherName= NAME.split(" ")[1]+" "+NAME.split(" ")[2];
    	        		driver.findElement(By.id("Father_Name")).clear();
    	                driver.findElement(By.id("Father_Name")).sendKeys(FatherName);
    	        	//System.out.println("FatherName From Name:"+Name.split(" ")[1]+" "+Name.split(" ")[2]);
    	        	}
    	        	}catch(Exception e){System.out.println("Exception in set Father Name");}
    			}
    			else if(j==2) {
    				String GENDAR = r.getCell(columnNo+j+((farmerNum-1)*6)).getStringCellValue();
    	            
    	            if(GENDAR.toLowerCase().equals("male")||GENDAR.toLowerCase().equals("m"))
    	            {
    	            	driver.findElement(By.xpath("//input[@id='Gender' and @value='M']")).click();
    	            }
    	            else if(GENDAR.toLowerCase().equals("female")||GENDAR.toLowerCase().equals("f"))
    	            {
    	            	driver.findElement(By.xpath("//input[@id='Gender' and @value='F']")).click();
    	            }
    			}
    			else if(j==3) {
            		String CATEGORY = r.getCell(columnNo+j+((farmerNum-1)*6)).getStringCellValue();
    	            
    	            Select category = new Select(driver.findElement(By.id("Category_Code")));
    	            if(CATEGORY.toLowerCase().equals("gn"))
    	            {
    	            	category.selectByIndex(1);
    	            }
    	            else if(CATEGORY.toLowerCase().equals("obc"))
    	            {
    	            	category.selectByIndex(2);
    	            }
    	            else if(CATEGORY.toLowerCase().equals("sc"))
    	            {
    	            	category.selectByIndex(3);
    	            }
    	            else if(CATEGORY.toLowerCase().equals("st"))
    	            {
    	            	category.selectByIndex(4);
    	            }
    	            else
    	            {
    	            	System.out.print("\n Invalid CATEGORY = "+ CATEGORY);
    	            }
    	            Thread.sleep(10000);
        			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        			
    	        	}
    			
    			else if(j==4) {
            		//String SURVEY_NO = r.getCell(columnNo+j+((farmerNum-1)*6)).getStringCellValue();
            		String SURVEY_NO=getCellValueAsString(r.getCell(columnNo+j+((farmerNum-1)*6)));
    	            if(!SURVEY_NO.equals("NA")){
    	            driver.findElement(By.id("SurveyNo")).sendKeys(SURVEY_NO);
    	            }
    	        	}
            	else if(j==5) {
            		Double FARM_SIZE  = r.getCell(columnNo+j+((farmerNum-1)*6)).getNumericCellValue();
    	            System.out.print("\n FARM_SIZE:"+i+" = "+ FARM_SIZE );
    	            
    	            driver.findElement(By.id("Area_Land")).sendKeys(Double.toString(FARM_SIZE));
    	            Select unit2 = new Select(driver.findElement(By.id("Area_Land_Unit")));
    	            unit2.selectByIndex(2);
    	            if(! r.getCell(columnNo+j+2+((farmerNum-1)*6)).getStringCellValue().equalsIgnoreCase("NA")) {
    	            	System.out.println("Values of i and NoOffarmers"+i+"::"+noOfFarmers);
    	            	 driver.findElement(By.id("save")).click();
    	            	 Thread.sleep(4000);
    	    	         ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	            }
    	            else {
    	            	flag=true;
    	            	System.out.println("In enter next sample");
    	            	//driver.findElement(By.id("new")).click();
    	            	driver.findElement(By.xpath("//input[@id='new' and @value='Enter next sample']")).click();
    	            	try {
    	            		driver.switchTo().alert().accept();
    	            	}catch(Exception e){}
    	            	//Enter next sample
    	            }
    	           
    	            
    	            r.getCell(columnNo+j+1+((farmerNum-1)*6)).setCellValue("Done");
    	    		FileOutputStream fos = new FileOutputStream(f);
    	    		w.write(fos);
    	    		fos.close();
    	        	}
            	
    		}
    			else {
    				break outerloop;
    			}
    		}
    		farmerNum = farmerNum +1;
    		}catch(Exception e){
    			System.out.println("In Catch="+e.getMessage());
    			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    			driver.findElement(By.id("refresh")).click();
    			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 300)");
    			farmerNum = farmerNum +1;
    			
    		}
    	}
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
