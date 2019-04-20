package scp.selenium.package1;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PichartReport {
	
public static void generateTestReport(int passCount,int failCount,int skipCount) {
		
		System.out.println("In generate report");
		 DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue("Pass", new Double( passCount ) );
	      dataset.setValue("Fail", new Double( failCount) );
	      dataset.setValue("Skip", new Double( skipCount ) );
	      //dataset.setValue("Nokia Lumia", new Double( 10 ) );

	      JFreeChart chart = ChartFactory.createPieChart(
	         "MyTestReport",   // chart title
	         dataset,          // data
	         true,             // include legend
	         true,
	         false);
	         
	      int width = 640;   /* Width of the image */
	      int height = 480;  /* Height of the image */ 
	      File pieChart = new File( "C:\\Users\\Prashant\\Desktop\\TestReport2.jpeg" ); 
	      try {
			ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
