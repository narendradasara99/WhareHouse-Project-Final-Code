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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtil;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/ship")
public class ShipmentTypeController {

	//for pie chart
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;

	@Autowired
	private IShipmentTypeService service;
	//1 show register page
	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";

		//2 ::::::::::::::::save data on click  submit::::::::::::::::
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveData(@ModelAttribute ShipmentType shipmentType, ModelMap map ) {
		Integer id= service.saveShipmentType(shipmentType);
		String message ="ShipmentType '"+id+"'Created Sussessfully";

		map.addAttribute("msg",message);
		// For clearing Register page field data ,After request done 
		map.addAttribute("shipmentType", new ShipmentType());
		//end
		
		
		return "ShipmentTypeRegister";	

	}

	//:::::::::::fetch data from Database::::::::::::::::
	@RequestMapping("/all")
	public String getAll(ModelMap map) {

		//make service layuer call
		List<ShipmentType> shipmentType=service.getAllShipmentTypes();

		//send data to Ui
		map.addAttribute("list",shipmentType);
		//goto UI

		return "ShipmentTypeData";

	}

	//4   :::::::::::::::delete Shipmenttype  id::::::::::::::::::
	@RequestMapping("/delete")
	public String delete(
			@RequestParam Integer id, ModelMap map)

	{
		//call service 
		service.deleteShipmentType(id);
		//get new data
		List<ShipmentType> shipmenttype=service.getAllShipmentTypes();
		//success msg
		String msg="deleted'"+id+"' Successfully";
		//send  to UI
		map.addAttribute("list",shipmenttype);
		map.addAttribute("msg", msg);	

		return "ShipmentTypeData";

	}


	// 5 . ::::::::::::::::show Edit Page:::::::::::::::::::::::::::
	@RequestMapping("/edit")
	public  String  showEdit(@RequestParam Integer id, ModelMap map) {

		// call service
		ShipmentType shipmentType= service.getOneShipmentType(id);
		map.addAttribute(id);
		map.addAttribute("shipmentType", shipmentType);

		return "ShipmentTypeEdit";
		//testing
		//return "ShipEdit";

	}
	//::::::::::::update shipmentType one row :::::::::::::::::
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute ShipmentType shipmentType, ModelMap map) {

		service.updateShipmentType(shipmentType);
		String messgae="ShipmentType '"+shipmentType.getId()+"' updated successfully";
		map.addAttribute("msg", messgae);
		List<ShipmentType> shipmentTypes=service.getAllShipmentTypes();
		map.addAttribute("list", shipmentTypes);
		return "ShipmentTypeData";
		//testing
		//return "ShipData";

	}


	// view one Page
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {

		ShipmentType  shipmentType=service.getOneShipmentType(id);
		map.addAttribute("ob" ,shipmentType) ;

		return "ShipmentTypeView";


	}

	//8 Excel View
	@RequestMapping("/excel")
	public ModelAndView exportExcel(
			@RequestParam(required = false) Integer id){

		List<ShipmentType>  shipments=null;

		if(id==null) {
			shipments=service.getAllShipmentTypes();
		} else {
			ShipmentType s=service.getOneShipmentType(id);
			shipments=Arrays.asList(s);
		}

		ModelAndView m= new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		m.addObject("list", shipments);

		return m;

	}

	// 9.Export to Pdf
	@RequestMapping("/pdf")
	public ModelAndView showPfd(
			@RequestParam(required = false) Integer id){
		List<ShipmentType> shipments=null;
		if(id== null)
			shipments= service.getAllShipmentTypes();
		else 
			shipments=Arrays.asList(service.getOneShipmentType(id));

		//read Datra from DB

		ModelAndView m=new  ModelAndView();
		m.setView(new ShipmentTypePdfView());
		m.addObject("list",shipments);	
		return m;

	}

	//Generate Chart
	@RequestMapping("/charts")
	public  String genChart() {
		List<Object[]> list=service.getShipmentTypeModeAndCount();
		String path=context.getRealPath("/");
		util.genPie(path, list);
		util.genBar(path, list);
		return "shipmentTypeCharts";

	}



}