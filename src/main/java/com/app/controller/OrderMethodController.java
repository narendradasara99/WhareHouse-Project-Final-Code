
package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	//for pie chart
	@Autowired 
	private ServletContext context;
	@Autowired 
	private OrderMethodUtil util;
	@Autowired 
	private IOrderMethodService service;
	
	//1 ***********show register page************
	@RequestMapping("/register") 
	public String showRegister(ModelMap map) {
		map.addAttribute("orderMethod",new OrderMethod());
		return	"OrderMethodRegister";
	}

	//2 **********save data on click submit*************
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveData(@ModelAttribute OrderMethod orderMethod, ModelMap map ) {
		Integer	id= service.saveOrderMethod(orderMethod);
		String message="OrderMethod '"+id+"'Created Sussessfully";
		map.addAttribute("msg",message);
		// For clearing Register page field data ,After first request done 
		map.addAttribute("orderMethod",new OrderMethod());
		//end
		return "OrderMethodRegister";
	}
	//***********fetch data from Database for shipments***
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		//make service layuer call
		List<OrderMethod> orderMethod=service.getAllOrderMethods();

		//send data to Ui
		map.addAttribute("list",orderMethod); 
		//goto UI
		return "OrderMethodData";
	}

	//4 *********delete OrderMethod id************
	@RequestMapping("/delete")
	public String delete(
			@RequestParam Integer id, ModelMap map){
		
		//call service 
		service.deleteOrderMethod(id); 
		//get new data
		List<OrderMethod> orderMethod=service.getAllOrderMethods(); 
		//success msg
		String msg="deleted'"+id+"' Successfully"; 
		//send to UI
		map.addAttribute("list",orderMethod);
		map.addAttribute("msg",msg);
		return "OrderMethodData";
	}


	// 5 . ******show Edit Page************
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id,
			ModelMap map) {
		// call service
		OrderMethod orderMethods= service.getOneOrderMethod(id);
		map.addAttribute(id);
		map.addAttribute("orderMethod", orderMethods);

		return "OrderMethodEdit";

	} //6 *******update page*************

	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		service.updateOrderMethod(orderMethod);
		String	messgae="OrderMethod '"+orderMethod.getId()+"' updated successfully";
		map.addAttribute("msg", messgae);
		List<OrderMethod>orderMethods=service.getAllOrderMethods();
		map.addAttribute("list",orderMethods);
		return "OrderMethodData";

	}

	//7 **********view one Page************

	@RequestMapping("/view") 
	public String getOne(@RequestParam Integer id, ModelMap map) {
		OrderMethod orderMethod=service.getOneOrderMethod(id);
		map.addAttribute("ob",orderMethod) ;
		return "OrderMethodView";
	}

	//8 *******Excel View**********

	@RequestMapping("/excel") public ModelAndView exportExcel(
			@RequestParam(required = false) Integer id){
		List<OrderMethod> orders=null;
		if(id==null) {
			orders=service.getAllOrderMethods(); 
		} else { 
			OrderMethod	o=service.getOneOrderMethod(id); 
			orders=Arrays.asList(o);
		} 
		ModelAndView m=	new ModelAndView();
		m.setView(new OrderMethodExcelView());
		m.addObject("list",orders);
		return m;
	}

	//9. **********Export to Pdf*****************
	@RequestMapping("/pdf") 
	public ModelAndView showPdf(
			@RequestParam(required=false)Integer id) {
		List<OrderMethod> orders=null; 
		if(id==null)
			orders=service.getAllOrderMethods(); else
				orders=Arrays.asList(service.getOneOrderMethod(id));
		//read Data FROM Db
		ModelAndView m= new ModelAndView();
		m.setView(new OrderMethodPdfView());
		m.addObject("list",orders);

		return m;

	}
	
	//**********Generate Chart*************
	@RequestMapping("/charts") 
	public String genChart() {
		List<Object[]>list=service.getOrderModeTypeAndCount();
		String path=context.getRealPath("/"); 
		util.genPie(path, list); 
		util.genBar(path,list);
		return "OrderMethodCharts";

	}

}




