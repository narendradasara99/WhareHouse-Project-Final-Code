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

import com.app.model.Part;
import com.app.service.IOrderMethodService;
import com.app.service.IPartService;
import com.app.service.IUomService;
import com.app.util.CommonUtil;
import com.app.util.PartUtil;
import com.app.view.PartExcelView;
import com.app.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController {
	@SuppressWarnings("unused")
	@Autowired
	private IOrderMethodService ordermethodservice;
	@Autowired
	private IUomService uomservice;
	@Autowired
	private ServletContext context;
	@Autowired
	private PartUtil util;
	@Autowired
	private IPartService service;
	
	
	@SuppressWarnings("unused")
	private void addUiComponents(ModelMap map) {
	
	List<Object[]> uomList=uomservice.getUomIdAndModels();
	List<Object[]>ordermethodList=ordermethodservice.getOrderMethodIdAndOrderCodes("Sale");
	List<Object[]>omPurchase=ordermethodservice.getOrderMethodIdAndOrderCodes("Purchase");
	//convert to map
	Map<Integer,String> uomss=CommonUtil.convertData(uomList);
	Map<Integer,String> ordermethodss=CommonUtil.convertData(ordermethodList);
	Map<Integer,String> omPurchaseMap=CommonUtil.convertData(omPurchase);
	//Send  to Ui  Show as Dropdown
	map.addAttribute("uoms",uomss);
	map.addAttribute("sales",ordermethodss);
	map.addAttribute("purchases",omPurchaseMap);
	}
	
	//1 *********show Register page**************
	@RequestMapping("/register")
	public String  showRegister(ModelMap map) {
		map.addAttribute("part",new Part());
		addUiComponents(map);
		return "PartRegister";
	}


		//*****************save Page***********
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveData(@ModelAttribute Part part, ModelMap map ) {
		Integer id= service.savePart(part);
		String message ="Part '"+id+"'Created Sussessfully";
		map.addAttribute("msg",message);
		// For clearing Register page field data ,After first request done 
		map.addAttribute("part",new Part());
		//end
		addUiComponents(map);
		return "PartRegister";	

	}

	//*************fetch data from Database**************
	@RequestMapping("/all")
	public String getAll(ModelMap map) {

		//make service layuer call
		List<Part> parts=service.getAllParts();

		//send data to Ui
		map.addAttribute("list",parts);
		//goto UI

		return "PartData";

	}
	//4   ***********delete Uom id**************
	@RequestMapping("/delete")
	public String delete(
			@RequestParam Integer id, ModelMap map) {

		//call service 
		service.deletePart(id);
		//get new data
		List<Part> parts=service.getAllParts();
		//success msg
		String msg="deleted'"+id+"' Successfully";
		//send  to UI
		map.addAttribute("list",parts);
		map.addAttribute("msg", msg);	

		return "PartData";

	}

	// 5 . show Edit Page
	@RequestMapping("/edit")
	public  String  showEdit(@RequestParam Integer id, ModelMap map) {

		// call service
		Part p= service.getOnePart(id);
		map.addAttribute(id);
		map.addAttribute("part", p);

		addUiComponents(map);

		return "PartEdit";

	}
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute Part part, ModelMap map) {

		service.updatepart(part);
		String messgae="Part '"+part.getId()+"' updated successfully";
		map.addAttribute("msg", messgae);
		List<Part> parts=service.getAllParts();
		map.addAttribute("list", parts);
		return "PartData";

	}

	// 8 Generate Chart
	@RequestMapping("/charts")
	public  String genChart() {
		List<Object[]> list=service.getPartBaseCurrencyAndCount();
		String path=context.getRealPath("/");
		util.genPie(path, list);
		util.genBar(path, list);
		return "PartChart";

	}	

	// 9view one Page
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {

		Part parts=service.getOnePart(id);
		map.addAttribute("ob" ,parts) ;

		return "PartView";

	}


	//10 Excel View

	@RequestMapping("/excel") 
	public ModelAndView exportExcel(
			@RequestParam(required = false) Integer id){

		List<Part>  parts=null;

		if(id==null) {
			parts=service.getAllParts();
		} else {
			Part p=service.getOnePart(id);
			parts=Arrays.asList(p);
		}
		ModelAndView m= new ModelAndView();
		m.setView(new PartExcelView());

		m.addObject("list",parts);
		return m;

	}

	//11 Export to Pdf
	@SuppressWarnings("unused")
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(required = false) Integer id) {

		List<Part> parts=null;
		if(parts==null)
			parts=service.getAllParts();
		else
			parts=Arrays.asList(service.getOnePart(id));

		//read data from Db
		ModelAndView m= new  ModelAndView();
		m.setView(new PartPdfView());
		m.addObject("list",parts);
		return m;
	}
}



