package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {
	public void genPie( String path,List<Object[]> list) {

		//1 create dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//create JFreeChart object
		JFreeChart chart=ChartFactory.createPieChart3D("SHIPMENT TYPE PIE CHART",dataset);

		// save as image 
		try {
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/shipmenttypepie.jpg"),
					chart,400,400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  


	public void genBar(String path,List<Object[]> list) {
		//! create Dataset
		DefaultCategoryDataset  dataset=new DefaultCategoryDataset();
		for(Object[] ob:list) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(),"");

		}
		//2 Create JFreeChart Object
		try {
			JFreeChart chart=ChartFactory.createBarChart("Shipmenttype Bar chart", "ShipmentType Types", "Count", dataset);
			// 3. Save as Image
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/shipmentTypeBar.jpg"), chart, 400, 400);
		}catch(IOException e) {
			System.out.println(e);
		}		
	}

}



