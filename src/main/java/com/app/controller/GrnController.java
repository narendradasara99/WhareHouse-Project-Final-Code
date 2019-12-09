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

import com.app.model.Grn;
import com.app.model.GrnDtl;
import com.app.service.IGrnService;
import com.app.service.IPurchaseService;
import com.app.util.CommonUtil;
import com.app.util.GrnUtil;
import com.app.view.GrnExcelView;
import com.app.view.GrnPdfView;

@Controller
@RequestMapping("/grn")
public class GrnController {
	@Autowired
	private IGrnService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private IPurchaseService purchaseService;
	@Autowired
	private GrnUtil util;


	/*  Commons Code Start here ***************************************************************************************/
	private void addChildUi(ModelMap map) {
		/**DropDown for Purchase-start*/
		List<Object[]> plist=purchaseService.getPurchaseIdAndCode();
		Map<Integer,String> purchase=CommonUtil.convertData(plist);
		map.addAttribute("pobs",purchase);
		/**end*/
		/*  Commons Code End  here ***************************************************************************************/
	}

	/*
	 * Start
	 ***************************************************************************************/
	@RequestMapping("/register")
	public String regGrn(ModelMap map) {
		map.addAttribute("grn",new Grn());
		addChildUi(map);
		return "GrnRegister";
	}

	/*
	 * End
	 ***************************************************************************************/

	/* Start***************************************************************************************/
	@RequestMapping(value = "/save",method =RequestMethod.POST)
	public String saveGrn(@ModelAttribute Grn grn, ModelMap map) {
		Integer id=service.saveGrn(grn);
		util.saveGrnDtls(grn);
		map.addAttribute("message","Grn created with Id:"+id);
		// For clearing Register page field data ,After first request done 
		map.addAttribute("grn",new Grn()) ;
		//end
		//change Purchase Status
		purchaseService.updateStatusById(grn.getPurchase().getId(),"RECEIVED");
		//copyGrnDtlsFromPurchseDtls
		addChildUi(map);
		return "GrnRegister";
	}
	/* End***************************************************************************************/

	/* Start***************************************************************************************/
	@RequestMapping(value = "/update", method =RequestMethod.POST)	
	public String updateGrn(@ModelAttribute Grn grn, ModelMap map) {
		service.updateGrn(grn);
		map.addAttribute("message","Grn updated");
		List<Grn> list=service.getAllGrns();
		map.addAttribute("list",list);
		addChildUi(map);
		return "GrnData";
	}


	/* End***************************************************************************************/

	/* Start***************************************************************************************/
	@RequestMapping("/delete")
	public String deleteGrn(@RequestParam Integer id, ModelMap map) {
		service.deleteGrn(id);
		map.addAttribute("message","Grn deleted with Id:"+id);
		List<Grn> list=service.getAllGrns();
		map.addAttribute("list",list);
		return "GrnData";
	}
	/* End***************************************************************************************/


	/* Start***************************************************************************************/
	@RequestMapping("/edit")
	public String editGrn(@RequestParam Integer id, ModelMap map) {
		Grn ob=service.getOneGrn(id);
		map.addAttribute("grn",ob);
		addChildUi(map);
		return "GrnEdit";
	}
	/* End***************************************************************************************/

	/* Start***************************************************************************************/
	@RequestMapping("/all")
	public String getAllGrns(ModelMap map) {
		List<Grn> list=service.getAllGrns();
		map.addAttribute("list",list);
		return "GrnData";
	}
	/* End***************************************************************************************/


	/* Start***************************************************************************************/
	//view one Page
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {

		Grn Grns=service.getOneGrn(id);
		map.addAttribute("ob" ,Grns) ;

		return "GrnView";
	}
	/* End***************************************************************************************/


	/* Start***************************************************************************************/
	//7 ****Excel View***********
	@RequestMapping("/excel") 
	public ModelAndView exportExcel(
			@RequestParam(required = false) Integer id){

		List<Grn>  grns=null;
		if(id==null) {
			grns=service.getAllGrns();
		} else {
			Grn g=service.getOneGrn(id);
			grns=Arrays.asList(g);
		}
		ModelAndView m= new ModelAndView();
		m.setView(new GrnExcelView());
		m.addObject("list",grns);
		return m;

	}
	/* End***************************************************************************************/


	/* Start***************************************************************************************/
	//8 ***********Export to Pdf*************
	@SuppressWarnings("unused")
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(required = false) Integer id) {

		List<Grn> grns=null;
		if(grns==null)
			grns=service.getAllGrns();
		else
			grns=Arrays.asList(service.getOneGrn(id));

		//*******read data from Db**************
		ModelAndView m= new  ModelAndView();
		m.setView(new GrnPdfView());
		m.addObject("list",grns);
		return m;

	}

	/* End***************************************************************************************/

	/* Start***************************************************************************************/
	//Generate Chart

	@RequestMapping("/charts")
	public  String genChart() {
		List<Object[]> list=service.getGrnTypeAndCount();
		String path=context.getRealPath("/");
		util.genPie(path, list);
		util.genBar(path, list);
		return "GrnChart";

	}

	/* End***************************************************************************************/

	/* Start***************************************************************************************/



	/****************************************Childs Screen#2*********************************************************/


	@RequestMapping("/parts")
	public String showParts(
			@RequestParam Integer id,ModelMap map) {

		//get Grn Childs

		List<GrnDtl> childs=service.getGrnDtlByGrnId(id);
		map.addAttribute("childs",childs);
		return "GrnParts";
	}
	/* End***************************************************************************************/


}

