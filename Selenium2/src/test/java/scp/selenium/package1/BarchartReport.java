package scp.selenium.package1;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarchartReport {
	public static void generateTestReport(int passCount,int failCount,int skipCount) throws IOException {
		
		
		 final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      dataset.addValue( new Double(passCount) , "Passed" , "Pass" );
	      dataset.addValue( new Double(failCount) , "Failed" , "Fail" );
	      dataset.addValue( new Double(skipCount) , "Skipped" , "Skip" );
	      

	      JFreeChart barChart = ChartFactory.createBarChart(
	         "BAR CHART REPORT", 
	         "STATUS", "PERCENTAGE", 
	         dataset,PlotOrientation.VERTICAL, 
	         true, true, false);
	         
	      int width = 640;    /* Width of the image */
	      int height = 480;   /* Height of the image */ 
	      File BarChart = new File( "C:\\Users\\Prashant\\Desktop\\BarChart.jpeg" ); 
	      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
	}

}
