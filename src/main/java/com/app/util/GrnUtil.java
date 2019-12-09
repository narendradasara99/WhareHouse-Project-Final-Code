package com.app.util;

import java.io.File;
import java.io.IOException;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Grn;
import com.app.model.GrnDtl;
import com.app.model.Purchase;
import com.app.model.PurchaseDtl;
import com.app.service.IGrnService;
import com.app.service.IPurchaseService;

@Component
public class GrnUtil {
	public void genPie( String path,List<Object[]> list) {

		//1 create dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//create JFreeChart object
		JFreeChart chart=ChartFactory.createPieChart3D("GRN PIE CHART",dataset);

		// save as image 
		try {
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/grnpie.jpg"),
					chart,400,400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 

	public static void genBar(String path,List<Object[]> list) {
		// create DataSet 
		DefaultCategoryDataset  dataset=new DefaultCategoryDataset();
		for(Object[] ob:list) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(),"");

		}
		//2 Create JFreeChart Object
		try {
			JFreeChart chart=ChartFactory.createBarChart("Gen Bar chart", "Grn Type", "Count", dataset);
			// 3. Save as Image
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/grnBar.jpg"), chart, 400, 400);
		}catch(IOException e) {
			System.out.println(e);
		}		
	}
	
	
	//For Integrations
	@Autowired
	private IGrnService service;
	@Autowired
	private IPurchaseService purchaseService;
	
	public void saveGrnDtls(Grn grn) {
		//read first purchase by pid
		Purchase po=purchaseService.getOnePurchase(grn.getPurchase().getId());
		
		//from purchase read PurchaseDtls
		List<PurchaseDtl> pdtls=po.getChilds();
		
		// One PurchaseDtl -> one GrnDtl
		for(PurchaseDtl pdtl:pdtls) {
			GrnDtl gdtl=new GrnDtl();
			gdtl.setItemCode(pdtl.getPart().getCode());
			gdtl.setBaseCost(pdtl.getPart().getBaseCost());
			gdtl.setQnty(pdtl.getQty());
			gdtl.setItemVal(gdtl.getBaseCost()*gdtl.getQnty());
			
			//link with (GrnId)PrimaryKey as Fk
			//for bi-directional code 
			gdtl.setParent(new Grn(grn.getId()));
			//save GrnDtl
			service.saveGrnDtl(gdtl);
		}
		
	}
}





