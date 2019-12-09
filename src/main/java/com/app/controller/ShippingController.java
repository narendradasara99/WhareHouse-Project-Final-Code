package com.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Shipping;
import com.app.model.ShippingDtl;
import com.app.service.ISaleService;
import com.app.service.IShippingService;
import com.app.util.CommonUtil;
import com.app.util.ShippingUtil;
import com.app.view.ShippingExcelView;
import com.app.view.ShippingPdfView;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

	@Autowired
	private IShippingService shippiongService;
	@Autowired
	private ISaleService saleService;
	@Autowired
	private ShippingUtil util;
	
	
	@SuppressWarnings("unused")
	private void addUiComponents(ModelMap map) {
		/**DropDown for Sale-start*/
		List<Object[]> saleList=saleService.getSaleIdAndOrderCodes();
		//convert to map
		Map<Integer,String> saleMap=CommonUtil.convertData(saleList);
		//Send  to Ui  Show as Dropdown
		map.addAttribute("sale",saleMap);
		/**end*/
		}
	//1 ************show Register page************
	@RequestMapping("/register")
	public String  showRegister(ModelMap map) {
		map.addAttribute("shipping",new Shipping());
		addUiComponents(map);
		return "ShippingRegister";
	}

	// ***********Save data on  click submit*************
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveData(@ModelAttribute Shipping shipping, ModelMap map ) {
		util.saveShippingDtls(shipping);
		Integer id= shippiongService.saveShipping(shipping);
		String message ="Shipping '"+id+"'Created Sussessfully";
		map.addAttribute("msg",message);
		// For clearing Register page field data ,After first request done 
		map.addAttribute("shipping",new Shipping());
		//end
		addUiComponents(map);
		
		return "ShippingRegister";	

	}

	//*************fetch data from Database**************
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		//make service layuer call
		List<Shipping> shippings=shippiongService.getAllShippings();
		//send data to Ui
		map.addAttribute("list",shippings);
		//goto UI   
		return "ShippingData";

	}
	//4   delete Uom id
	@RequestMapping("/delete")
	public String delete(
			@RequestParam Integer id, ModelMap map){

		//call service 
		shippiongService.deleteShipping(id);
		//get new data
		List<Shipping> shippings=shippiongService.getAllShippings();
		//success msg
		String msg="deleted'"+id+"' Successfully";
		//send  to UI
		map.addAttribute("list",shippings);
		map.addAttribute("msg", msg);	
		return "ShippingData";

	}

	// 5 . ***********show Edit Page************
	@RequestMapping("/edit")
	public  String  showEdit(@RequestParam Integer id, ModelMap map) {

		// call service
		Shipping s= shippiongService.getOneShipping(id);
		map.addAttribute(id);
		map.addAttribute("shipping", s);
		addUiComponents(map);
		return "ShippingEdit";

	}

	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute Shipping shipping, ModelMap map) {
		shippiongService.updateShipping(shipping);
		String messgae="Shipping '"+shipping.getId()+"' updated successfully";
		map.addAttribute("msg", messgae);
		List<Shipping> shippings=shippiongService.getAllShippings();
		map.addAttribute("list", shippings);
		addUiComponents(map);
		return "ShippingData";	
	}

	// view one Page
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {
		Shipping shipping=shippiongService.getOneShipping(id);
		map.addAttribute("ob" ,shipping) ;
		return "ShippingView";
	}


	//8 Export to Pdf
	@SuppressWarnings("unused")
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(required = false) Integer id) {

		List<Shipping> shippings=null;
		if(shippings==null)
			shippings=shippiongService.getAllShippings();
		else
			shippings=Arrays.asList(shippiongService.getOneShipping(id));

		//read data from Db
		ModelAndView m= new  ModelAndView();
		m.setView(new ShippingPdfView());
		m.addObject("list",shippings);

		return m;

	}	

	//8 Excel View 
	@RequestMapping("/excel") 
	public ModelAndView exportExcel(
			@RequestParam(required = false) Integer id){

		List<Shipping>  shippings=null;

		if(id==null) {
			shippings=shippiongService.getAllShippings();
		} else {
			Shipping sg=shippiongService.getOneShipping(id);
			shippings=Arrays.asList(sg);
		}
		ModelAndView m= new ModelAndView();
		m.setView(new ShippingExcelView());
		m.addObject("list",shippings);
		return m;

	}
	
	
	/****Childs Screen#2***/
	@RequestMapping("/parts")
	public String showParts(
			@RequestParam Integer id,ModelMap map) {
		
		//get shipping Childs
		
		List<ShippingDtl> childs=shippiongService.getShippingDtlByShippingId(id);
		map.addAttribute("childs",childs);
		return "ShippingParts";
	}
	


}