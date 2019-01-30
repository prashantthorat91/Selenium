package scp.selenium.sample2;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PiechartCode {

	public static DefaultPieDataset dataset;
	public static void setDatasetValue(DefaultPieDataset dataset2)
	{
		dataset=dataset2;
	}
	public static void createPieCart() throws IOException
	{
		JFreeChart chart = ChartFactory.createPieChart(
		         "Pie Chart",   // chart title
		         dataset,          // data
		         true,             // include legend
		         true,
		         false);
		         
		      int width = 640;   /* Width of the image */
		      int height = 480;  /* Height of the image */ 
		      File pieChart = new File( "C:\\Users\\VinodJagtap\\Desktop\\PieChart"+GregorianCalendar.getInstance().getTimeInMillis()+".jpeg" ); 
		      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
	}
}
