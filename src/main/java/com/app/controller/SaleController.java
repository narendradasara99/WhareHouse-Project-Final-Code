package com.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.model.Sale;
import com.app.model.SaleDtl;
import com.app.service.IPartService;
import com.app.service.ISaleService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.util.CommonUtil;
import com.app.util.SaleUtil;
import com.app.view.CustomerInvocePdfView;
import com.app.view.SaleExcelView;
import com.app.view.SalePdfView;

@Controller
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private IPartService partService;
	
	
	@Autowired
	private ISaleService service;

	//for pie chart
		@Autowired
		private ServletContext context;
		@Autowired
	private SaleUtil util;
	
		@Autowired
		private IWhUserTypeService whUserTypeservice;
		@Autowired
		private IShipmentTypeService shipmentEnabledService;
		private void  addUiComponents(ModelMap map) {
			List<Object[]> users=whUserTypeservice.getWhUserTypeIdAndCode("Customer");
			Map<Integer,String> userMap=CommonUtil.convertData(users);
			map.addAttribute("userss", userMap);
			
			List<Object[]> shipmentEnabled=shipmentEnabledService.getShipmentTypeIdAndEnable("Yes");
			Map<Integer,String> ShipmentEnabledMap=CommonUtil.convertData(shipmentEnabled);
			map.addAttribute("shipmentcode", ShipmentEnabledMap);
	}
	
	//1 show Register page
	@RequestMapping("/register")
	public String  showRegister(ModelMap map) {
		map.addAttribute("sale", new Sale());
		Sale p=new Sale();
		p.setSaleOrderStatus("OPEN");
		map.addAttribute("sale", p);
		addUiComponents(map);
		return "SaleRegister";
	}
	
	// Save data on  click submit
		@RequestMapping(value="/save", method = RequestMethod.POST)	
			public String saveData(@ModelAttribute Sale sale, ModelMap map ) {
				Integer id= service.saveSale(sale);
				String message ="Sale '"+id+"'Created Sussessfully";
				map.addAttribute("msg",message);
				// For clearing Register page field data ,After first request done 
				map.addAttribute("sale", new Sale());
				addUiComponents(map);
				return "SaleRegister";	
		}

	// Fetch Data from database
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		//make service layuer call
				List<Sale> sales=service.getAllSales();
				//send data to UI
				map.addAttribute("list",sales);
				//goto UI
				return "SaleData";
	}

	//4 delete sale Id
	@RequestMapping("/delete")
		public String delete(@RequestParam Integer id, ModelMap map){

			//call service 
			service.deleteSale(id);
			//get new data
			List<Sale> sales=service.getAllSales();
			//success msg
			String msg="Deleted'"+id+"' Successfully";
			//send  to UI
			map.addAttribute("list",sales);
			map.addAttribute("msg", msg);	
		
		return "SaleData";
	}

	


	// 5.Show Edit Page
	@RequestMapping("/edit")
	public  String  showEdit(@RequestParam Integer id, ModelMap map) {

			// call service
			Sale s= service.getOneSale(id);
			map.addAttribute(id);
			map.addAttribute("sale", s);
			addUiComponents(map);
		return "SaleEdit";				
	}

	// 6 update Purchase one Row 
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute Sale sale, ModelMap map) {
			service.updateSale(sale);
			String messgae="Sale '"+sale.getId()+"' updated successfully";
			map.addAttribute("msg", messgae);
			List<Sale> sales=service.getAllSales();
			map.addAttribute("list", sales);
		return "SaleData";
	}

	// view one Page
	@RequestMapping("/view")
		public String getOne(@RequestParam Integer id,ModelMap map) {
		Sale sale=service.getOneSale(id);
			map.addAttribute("ob" ,sale) ;
		return "SaleView";
	}


	//8 Export to Pdf
	@SuppressWarnings("unused")
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(required = false) Integer id) {

		List<Sale> sales=null;
		if(sales==null)
			sales=service.getAllSales();
		else
			sales=Arrays.asList(service.getOneSale(id));

		//read data from Db
		ModelAndView m= new  ModelAndView();
		m.setView(new SalePdfView());
		m.addObject("list",sales);

		return m;

	}	

	//8 Excel View

	@RequestMapping("/excel") 
	public ModelAndView exportExcel(
			@RequestParam(required = false) Integer id){

		List<Sale>  sales=null;

		if(id==null) {
			sales=service.getAllSales();
		} else {
			Sale s=service.getOneSale(id);
			sales=Arrays.asList(s);
		}
		ModelAndView m= new ModelAndView();
		m.setView(new SaleExcelView());
		m.addObject("list",sales);
		return m;

	}
	
	
		
	//Generate Chart
		@RequestMapping("/charts")
		public  String genChart() {
			List<Object[]> list=service.getStockModeAndCount();
			String path=context.getRealPath("/");
			util.genPie(path, list);
			util.genBar(path, list);
			return "SaleChart";

		}	
		
		
		
		
		
/* Integration of sale with  part to show Sale details */
		
		//1 show register page
			@RequestMapping("/parts")
			public String showParts( 
					 @RequestParam Integer id,ModelMap map) {
						
				//1 form Backing object
				SaleDtl saleDtl =new SaleDtl();
				//get Parent with All childs to show as Table
				
				Sale po=service.getOneSale(id);
				map.addAttribute("parent",po);
				//Lint with parent (PK-FK-ID)
				saleDtl.setParent(new Sale(id)); 
	
				map.addAttribute("saleDtl" ,saleDtl); 
				
				//Drop Down data for Parts
				List<Object[]> parts= partService.getPartIdAndCodes();
				Map<Integer,String> partsMap=CommonUtil.convertData(parts);
				map.addAttribute("parts",partsMap);
				//allocate Slno
			     util.allocateSlno(po);
						return "SaleParts";
			}
			

			
			// on click  Add button 
			@RequestMapping(value = "/add",method = RequestMethod.POST)
			public String addPart(@ModelAttribute SaleDtl saleDtl, ModelMap map ) {
				 service.saveSaleDtl(saleDtl);
				//On Add chnage status to PICKING
					service.updateStatusById(saleDtl.getParent().getId(),"READY");
				return "redirect:parts?id="+saleDtl.getParent().getId();
				//return "PurchaseParts";			
			}
			
			 
	
	  //GET/ remove?id=12&dtlId=15
	  
	  @RequestMapping("/remove")
	  public String delete(
	  
	  @RequestParam Integer id,
	  
	  @RequestParam Integer dtlId ) {
		  service.deleteSaleDtl(dtlId);
		  
		//if order contains zero Childs.
			if(service.getOneSale(id)
					.getChilds().isEmpty()) {
				service.updateStatusById(id,"OPEN");
			}
	  return  "redirect:parts?id="+id; 
	  }
	  
	
		//4. Generate Vendor invoce PDF
			//GET /venInvoice?id=25
			@RequestMapping("/CumInvoice")
			public ModelAndView generateVI(
					@RequestParam Integer id)
			{
				ModelAndView m=new ModelAndView();
				m.setView(new CustomerInvocePdfView());
				//send data (Purchase with Dtls)
				Sale po=service.getOneSale(id);
				m.addObject("parent",po);
				return m;
			}
			
		//  updateStatus?id=__&saleOrderStatus
			//  Page: SaleData
			//  Redirect:all
			@RequestMapping("/updateStatus")
			public String updateStatus(
					@RequestParam Integer id, 
					@RequestParam String saleOrderStatus 
					) 
			{
				service.updateStatusById(id,saleOrderStatus);
				return "redirect:all";
			}
			
	 
			 
}
