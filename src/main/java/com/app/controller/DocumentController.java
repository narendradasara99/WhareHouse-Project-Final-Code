package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private IDocumentService service;
	// 1. show Doc Page
	@RequestMapping("/register")
	public String showDoc( ModelMap map) {
		List<Object[]> list=service.getDocumentIdAndName();
		map.addAttribute("list",list);
		return "Documents";

	}

	/**************************************************************************************/
	// 2. on click Upload
	@RequestMapping(value="/upload", method=RequestMethod.POST) 
	public String uploadDoc(@RequestParam Integer fid,
			@RequestParam CommonsMultipartFile fdoc) {

		if(fdoc!=null) {
			Document doc=new Document();
			doc.setFileId(fid);
			doc.setFileName(fdoc.getOriginalFilename());
			doc.setFiledata(fdoc.getBytes());
			service.saveDocument(doc);

		}
		return "redirect:register";
	}
	/**************************************************************************************/
	//3 Download Process
	@RequestMapping("/download")
	public void downloadDoc(
			@RequestParam Integer fid,
			HttpServletResponse resp) {
		//read Object Baset on id
		Document doc=service.getOneDocument(fid);

		//Construct head
		resp.addHeader("Content-Disposition","attachement;filename="+doc.getFileName());
		try {
			//Construct body

			FileCopyUtils.copy(doc.getFiledata(),
					resp.getOutputStream());

		}	catch(IOException e) {
			e.printStackTrace();
		}

	}


}
