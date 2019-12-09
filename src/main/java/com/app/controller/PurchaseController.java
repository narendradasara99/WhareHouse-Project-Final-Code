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

import com.app.model.Purchase;
import com.app.model.PurchaseDtl;
import com.app.service.IPartService;
import com.app.service.IPurchaseService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.util.CommonUtil;
import com.app.util.PurchaseUtil;
import com.app.view.PurchaseExcelView;
import com.app.view.PurchasePdfView;
import com.app.view.VendorInvocePdfView;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@SuppressWarnings("unused")
	@Autowired
	private IPartService partService;
	
	
	//for pie chart
		@Autowired
		private ServletContext context;
		@Autowired
		private PurchaseUtil util;

	@Autowired
	private IPurchaseService service;
	@Autowired
	private IWhUserTypeService whUserTypeservice;
	@Autowired
	private IShipmentTypeService shipmentEnabledService;
	private void  addUiComponents(ModelMap map) {
		List<Object[]> users=whUserTypeservice.getWhUserTypeIdAndCode("Vendor");
		Map<Integer,String> userMap=CommonUtil.convertData(users);
		map.addAttribute("userss", userMap);
		
		List<Object[]> shipmentEnabled=shipmentEnabledService.getShipmentTypeIdAndEnable("Yes");
		Map<Integer,String> ShipmentEnabledMap=CommonUtil.convertData(shipmentEnabled);
		map.addAttribute("shipmentcode", ShipmentEnabledMap);	
		
	}
	
	
	//1 show register page
	@RequestMapping("/register")
	public String showRegister( ModelMap map) {
		Purchase p=new Purchase();
		p.setDefectStatus("OPEN");
		map.addAttribute("purchase", p);
		addUiComponents(map);
		return "PurchaseRegister";

	}
	//2 save data on click  submit
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveData(@ModelAttribute Purchase purchase, ModelMap map ) {
		Integer id= service.savePurchase(purchase);
		String message ="Purchase '"+id+"'Created Sussessfully";
		map.addAttribute("msg",message);
		addUiComponents(map);

		return "PurchaseRegister";	

	}

	//fetch data from Database
	@RequestMapping("/all")
	public String getAll(ModelMap map) {

		//make service layuer call
		List<Purchase> purchases=service.getAllPurchases();

		//send data to Ui
		map.addAttribute("list",purchases);
		//goto UI

		return "PurchaseData";

	}
	//4   delete Purchase through  id
	@RequestMapping("/delete")
	public String delete(
			@RequestParam Integer id, ModelMap map) {
		//call service 
		service.deletePurchse(id);
		//get new data
		List<Purchase> purchases=service.getAllPurchases();
		//success msg
		String msg="deleted'"+id+"' Successfully";
		//send  to UI
		map.addAttribute("list",purchases);
		map.addAttribute("msg", msg);	

		return "PurchaseData";

	}

	// 5 . show Edit Page
	@RequestMapping("/edit")
	public  String  showEdit(@RequestParam Integer id, ModelMap map) {
		//map.addAttribute("purchase" ,new Purchase());
		// call service
		Purchase p= service.getOnePurchase(id);
		map.addAttribute(id);
		map.addAttribute("purchase", p);
		addUiComponents(map);

		return "PurchaseEdit";

	}

	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute Purchase purchase, ModelMap map) {

		service.updatePurchse(purchase);
		String messgae="Purchase '"+purchase.getId()+"' updated successfully";
		map.addAttribute("msg", messgae);
		@SuppressWarnings("unused")
		List<Purchase> purchases=service.getAllPurchases();
		map.addAttribute("list", purchase);
		return "PurchaseData";

	}

	// view one Page
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {
		Purchase purchase=service.getOnePurchase(id);
		map.addAttribute("ob" ,purchase) ;
		return "PurchaseView";

	}
	
	
	
	


	// Excel View

	@RequestMapping("/excel") 
	public ModelAndView exportExcel(
			@RequestParam(required = false) Integer id){

		List<Purchase>  purchases=null;

		if(id==null) {
			purchases=service.getAllPurchases();
		} else {
			Purchase p=service.getOnePurchase(id);
			p=(Purchase) Arrays.asList(p);
		}
		ModelAndView m= new ModelAndView();
		m.setView(new PurchaseExcelView());

		m.addObject("list",purchases);


		return m;

	}


	// Export to Pdf
	@SuppressWarnings("unused")
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(required = false) Integer id) {

		List<Purchase> purchases=null;
		if(purchases==null)
			purchases=service.getAllPurchases();
		else
			purchases=Arrays.asList(service.getOnePurchase(id));

		//read data from Db
		ModelAndView m= new  ModelAndView();
		m.setView(new PurchasePdfView());
		m.addObject("list",purchases);


		return m;

	}
	
	
	  //Generate Chart
	  
	  @SuppressWarnings("static-access")
	@RequestMapping("/charts")
	  public String genChart() {
		  List<Object[]> list=service.getPurchaseQualityCheckAndCount();
		  String path=context.getRealPath("/"); 
		  util.genPie(path, list); 
		  util.genBar(path, list);
	  return "PurchaseChart";
	  
	  }
	  
	                     /* SCREEN-2 */

		/* Integration of purchase with  part to show purchase details */
		
		//1 show register page
			@RequestMapping("/parts")
			public String showParts( 
					 @RequestParam Integer id,ModelMap map) {
				
				
				
				//1 form Backing object
				PurchaseDtl purchaseDtl =new PurchaseDtl();
				//get Parent with All childs to show as Table
				
				Purchase po=service.getOnePurchase(id);
				map.addAttribute("parent",po);
				//Lint with parent (PK-FK-ID)
				purchaseDtl.setParent(new Purchase(id)); 
	
				map.addAttribute("purchaseDtl" ,purchaseDtl); 
				
				//Drop Down data for Parts
				List<Object[]> parts= partService.getPartIdAndCodes();
				Map<Integer,String> partsMap=CommonUtil.convertData(parts);
				map.addAttribute("parts",partsMap);
				//allocate Slno
			    util.allocateSlno(po);
				return "PurchaseParts";
			}
			
			//2. call on add button (PART ADD)
			// /add, POST 
						@RequestMapping(value = "/add",method = RequestMethod.POST)
						public String addPart(@ModelAttribute PurchaseDtl purchaseDtl, ModelMap map ) {
							 service.savePurchaseDtl(purchaseDtl);
							 
							//On Add chnage status to PICKING
								service.updateStatusById(purchaseDtl.getParent().getId(),"PICKING");
							return "redirect:parts?id="+purchaseDtl.getParent().getId();
							//return "PurchaseParts";			
								
						}
						
						 
						//3. Call on remove Part
						//GET/ remove?id=12&dtlId=15
						 @RequestMapping("/remove")
						 public String delete(
						   @RequestParam Integer id,
						   @RequestParam Integer dtlId
						   )
						 {
						  service.deletePurchaseDtl(dtlId);
						//if order contains zero Childs.
							if(service.getOnePurchase(id)
									.getChilds().isEmpty()) {
								service.updateStatusById(id,"OPEN");
							}
						  return "redirect:parts?id="+id;
						 }
						  
						//4. Generate Vendor invoce PDF
							//GET /venInvoice?id=25
							@RequestMapping("/venInvoice")
							public ModelAndView generateVI(
									@RequestParam Integer id)
							{
								ModelAndView m=new ModelAndView();
								m.setView(new VendorInvocePdfView());
								//send data (Purchase with Dtls)
								Purchase po=service.getOnePurchase(id);
								m.addObject("parent",po);
								return m;
							}
							
						//  updateStatus?id=__&status___
							//  Page: PurchaseData
							//  Redirect:all
							@RequestMapping("/updateStatus")
							public String updateStatus(
									@RequestParam Integer id, 
									@RequestParam String defectStatus 
									) 
							{
								service.updateStatusById(id,defectStatus);
								return "redirect:all";
							}
							
      }	




