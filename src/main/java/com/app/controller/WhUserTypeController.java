
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.EmailUtil;
import com.app.util.WhUserTypeUtil;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	// For Email
	@SuppressWarnings("unused")
	@Autowired
	private EmailUtil emailUtil;

	//for pie chart
		@Autowired
		private ServletContext context;
		@Autowired
		private WhUserTypeUtil util;
	@Autowired
	private IWhUserTypeService service;
	//1 show register page
	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";	
	}
/***
 * 
 * @param whUserType
 * @param map
 * @return
 */
	/*
	 * //2 save data on click submit
	 * 
	 * @RequestMapping(value = "/save",method = RequestMethod.POST) public String
	 * saveData(@ModelAttribute WhUserType whUserType, ModelMap map ) { Integer id=
	 * service.saveWhUserType(whUserType); String message
	 * ="WhUserType '"+id+"'Created Sussessfully"; map.addAttribute("msg",message);
	 * return "WhUserTypeRegister";
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveWhUserType(
			@ModelAttribute WhUserType whUserType,
			@RequestParam CommonsMultipartFile fileDoc,
			ModelMap map) {
		
		Integer id=service.saveWhUserType(whUserType);
		map.addAttribute("whUserType",new WhUserType()) ;
		String message="User created with Id:"+id;
		
		
		
		if(id!=null) { //on saved successfully send email
			String text=" Hello: "+whUserType.getWhuserCode()
			+", You are :"+whUserType.getWhuserType()
			+" , You can have :"+whUserType.getWhuserFor();
			
			boolean isSent=emailUtil.send(
					whUserType.getWhuserEmail(),
					"Welcome to Warehouse App",
					text,
					fileDoc.getSize()!=0?
							fileDoc:null);
			
			if(isSent) message+=", Email also sent";
			else  message+=",Email sending Failed";
		}
		
		
		map.addAttribute("msg",message);
		// For clearing Register page field data ,After first request done 
		map.addAttribute("whUserType", new WhUserType());
		//end
		
		return "WhUserTypeRegister";
	}
	


	//fetch data from Database

	@RequestMapping("/all") public String getAll(ModelMap map) {

		//make service layuer call 
		List<WhUserType> users=service.getAllWhUserTypes();

		//send data to Ui
		map.addAttribute("list",users);
		//goto UI

		return "WhUserTypeData";

	}
	//4 delete Uom id

	@RequestMapping("/delete")
	public String delete(
	@RequestParam Integer id, ModelMap map)

	{ 
		//call service
		service.deleteWhUserType(id);
		//get new data 
		List<WhUserType> users=service.getAllWhUserTypes(); 
		//success msg 
		String  msg="deleted'"+id+"' Successfully";
		//send to UI
		map.addAttribute("list",users);
		map.addAttribute("msg", msg);

		return "WhUserTypeData";

	}



	// 5 . show Edit Page
	@RequestMapping("/edit")
	public  String  showEdit(@RequestParam Integer id, ModelMap map) {

		// call service
		WhUserType u= service.getOneWhUserType(id);
		map.addAttribute(id);
		map.addAttribute("user", u);

		return "WhUserTypeEdit";

	}
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute WhUserType whUserType, ModelMap map) {

		service.updateWhUserType(whUserType);
		String messgae="WhUserType '"+whUserType.getId()+"' updated successfully";
		map.addAttribute("msg", messgae);
		List<WhUserType> users=service.getAllWhUserTypes();
		map.addAttribute("list", users);
		return "WhUserTypeData";

	}

	// view one Page
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {

		WhUserType user=service.getOneWhUserType(id);
		map.addAttribute("ob" ,user) ;

		return "WhUsertypeView";
	}

	//8 Excel View

	@RequestMapping("/excel")
	public ModelAndView exportExcel() {
		List<WhUserType>  users=service.getAllWhUserTypes();
		ModelAndView m= new ModelAndView();
		m.setView(new  WhUserTypeExcelView()); m.addObject("list",users);


		return m;

	}

	//9 Export to Pdf
	@SuppressWarnings("unused")
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(required = false) Integer id) { 
		List<WhUserType> users=null;
		if(users==null)
			users=service.getAllWhUserTypes();
		else
			users=Arrays.asList(service.getOneWhUserType(id));

		//read data from Db
		ModelAndView m= new  ModelAndView();
		m.setView(new WhUserTypePdfView());
		m.addObject("list",users);
		return m;

	}
	
	//Generate Chart
	  @RequestMapping("/charts")
	  public  String genChart() {
		  List<Object[]> list=service.getWhuserTypeAndCount();
		  String path=context.getRealPath("/");
		  util.genPie(path, list);
		  util.genBar(path, list);
		return "WhUserTypeCharts";
		  
	  }	
	  

}






