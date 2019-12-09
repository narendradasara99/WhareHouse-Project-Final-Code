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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	//for pie chart
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtil util;

	@Autowired
	private IUomService service;
	//1 show register page
	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}
		//2 save data on click  submit

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveData(@ModelAttribute Uom uom, ModelMap map ) {
		Integer id= service.saveUom(uom);
		String message ="Uom '"+id+"'Created Sussessfully";
		map.addAttribute("msg",message);
		map.addAttribute("uom", new Uom());

		return "UomRegister";	

	}

	//fetch data from Database
	@RequestMapping("/all")
	public String getAll(ModelMap map) {

		//make service layuer call
		List<Uom> uoms=service.getAllUom();

		//send data to Ui
		map.addAttribute("list",uoms);
		//goto UI

		return "UomRegisterData";

	}
	//4   delete Uom id
	@RequestMapping("/delete")
	public String delete(
			@RequestParam Integer id, ModelMap map)

	{
		//call service 
		service.deleteUom(id);
		//get new data
		List<Uom> uoms=service.getAllUom();
		//success msg
		String msg="deleted'"+id+"' Successfully";
		//send  to UI
		map.addAttribute("list",uoms);
		map.addAttribute("msg", msg);	

		return "UomRegisterData";

	}

	// 5 . show Edit Page
	@RequestMapping("/edit")
	public  String  showEdit(@RequestParam Integer id, ModelMap map) {

		// call service
		Uom u= service.getOneUom(id);
		map.addAttribute(id);
		map.addAttribute("uom", u);

		return "UomEdit";

	}

	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute Uom uom, ModelMap map) {

		service.updateUom(uom);
		String messgae="Uom '"+uom.getId()+"' updated successfully";
		map.addAttribute("msg", messgae);
		List<Uom> uoms=service.getAllUom();
		map.addAttribute("list", uoms);
		return "UomRegisterData";

	}

	// view one Page
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {

		Uom uom=service.getOneUom(id);
		map.addAttribute("ob" ,uom) ;

		return "UomView";




	}

	/*
	 * //8 Excel View
	 * 
	 * @RequestMapping("/excel") public ModelAndView exportExcel() { List<Uom>
	 * uoms=service.getAllUom(); ModelAndView m= new ModelAndView(); m.setView(new
	 * UomExcelView()); m.addObject("list",uoms);
	 * 
	 * 
	 * return m;
	 * 
	 * }
	 */




	//8 Excel View

	@RequestMapping("/excel") 
	public ModelAndView exportExcel(
			@RequestParam(required = false) Integer id){

		List<Uom>  uoms=null;

		if(id==null) {
			uoms=service.getAllUom();
		} else {
			Uom u=service.getOneUom(id);
			uoms=Arrays.asList(u);
		}
		ModelAndView m= new ModelAndView();
		m.setView(new UomExcelView());

		m.addObject("list",uoms);


		return m;

	}


	//9 Export to Pdf
	@SuppressWarnings("unused")
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(required = false) Integer id) {

		List<Uom> uoms=null;
		if(uoms==null)
			uoms=service.getAllUom();
		else
			uoms=Arrays.asList(service.getOneUom(id));

		//read data from Db
		ModelAndView m= new  ModelAndView();
		m.setView(new UomPdfView());
		m.addObject("list",uoms);


		return m;

	}

	//Generate Chart
	@SuppressWarnings("static-access")
	@RequestMapping("/charts")
	public  String genChart() {
		List<Object[]> list=service.getUomTypeAndCount();
		String path=context.getRealPath("/");
		util.genPie(path, list);
		util.genBar(path, list);
		return "UomChart";

	}			
}






