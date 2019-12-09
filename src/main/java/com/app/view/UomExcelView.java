package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		resp.addHeader("Content-disposition", "attachment;filename=uoms.xlsx");
		//read data
		List<Uom> list =(List<Uom>)  model.get("list");
		
		// create new Sheet
		
		Sheet sheet =book.createSheet("Uoms");
		addHeader(sheet);
		addBody(sheet, list);
		
	}
	
	
	private void addHeader(Sheet sheet) {
		
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");
		
	}
	
private  void addBody(Sheet sheet, List<Uom> list) {
	int rowNum=1;
	for(Uom u:list){
	
	Row row= sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(u.getId());
	row.createCell(1).setCellValue(u.getUomType());
	row.createCell(2).setCellValue(u.getUomModel());
	row.createCell(3).setCellValue(u.getDescription());
}
	
	
}
}
	
		
		
		
		
	
		
		
		
		
	
		
		




