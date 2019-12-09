package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.model.SaleDtl;
import com.app.model.Shipping;
import com.app.model.ShippingDtl;
import com.app.service.ISaleService;
import com.app.service.IShippingService;

@Component
public class ShippingUtil {
	@Autowired
	private IShippingService shippingService;
	@Autowired
	private ISaleService saleService;
	
	/* For Integrations */
	
	/*	*************************************************************************/
	
	public void saveShippingDtls(Shipping shipping) {
		//Get purchase id form backing obj ui data
		Integer id=shipping.getSaleOrder().getId();
		//select purchase details 
		List<SaleDtl> pdtls=saleService.getOneSale(id).getChilds();
		List<ShippingDtl> purdtls=new ArrayList<ShippingDtl>();
		for(SaleDtl pdtl:pdtls) {
			//shipping mapping one purchase tetails to one grn details
			
			ShippingDtl gdtl=new ShippingDtl(pdtl.getPart().getCode(),pdtl.getPart().getBaseCost(),pdtl.getQty(),pdtl.getPart().getBaseCost()*pdtl.getQty());
			purdtls.add(gdtl);
		}
		//set back Shipping
		
		shipping.setChilds(purdtls);
		
		
	}
	
	
	/*
	 * END
	 */
	
	
	
	public void genPie( String path,List<Object[]> list) {
		
		//1 create dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//create JFreeChart object
		JFreeChart chart=ChartFactory.createPieChart3D("SHIPPING PIE CHART",dataset);

		// save as image 
		try {
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/shippingpie.jpg"),
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
	
}





