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

import com.app.model.Sale;
import com.app.model.SaleDtl;

@Component
public class SaleUtil {
	public void genPie( String path,List<Object[]> list) {

		//1 create dataSet
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//create JFreeChart object
		JFreeChart chart=ChartFactory.createPieChart3D("SALE PIE CHART",dataset);

		// save as image 
		try {
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/salepie.jpg"),
					chart,400,400);
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	} 

	public static void genBar(String path,List<Object[]> list) {
		//! create DataSet
		DefaultCategoryDataset  dataset=new DefaultCategoryDataset();
		for(Object[] ob:list) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(),"");

		}
		//2 Create JFreeChart Object
		try {
			JFreeChart chart=ChartFactory.createBarChart("Sale Bar chart", "Stock Mode", "Count", dataset);
			// 3. Save as Image
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/saleBar.jpg"), chart, 400, 400);
		}catch(IOException e) {
			System.out.println(e);
		}		
	}
	// For Slno Number Genatation 
	public void allocateSlno(Sale po) {
		List<SaleDtl> list=po.getChilds();
		int count=1;
		for(SaleDtl dtl:list) {
		dtl.setSlno(count);
		count=count+1;
		}

		}

}





