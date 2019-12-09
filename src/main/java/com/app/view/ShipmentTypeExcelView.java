package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;



public class ShipmentTypeExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		resp.addHeader("Content-disposition", "attachment;filename=shipments.xlsx");
		//read data
		List<ShipmentType> list =(List<ShipmentType>)  model.get("list");
		
		// create new Sheet
		
		Sheet sheet =book.createSheet("Shipments");
		addHeader(sheet);
		addBody(sheet, list);
		
	}
	
	
	private void addHeader(Sheet sheet) {
		
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("SHIPMENTTYPECODE");
		row.createCell(2).setCellValue("SHIPMENTTYPEMODE");
		row.createCell(3).setCellValue("ENABLESHIPMENT");
		row.createCell(4).setCellValue("SHIPMENTTYPEGRADE");
		row.createCell(5).setCellValue("DESCRIPTION");
		
	}
	
private  void addBody(Sheet sheet, List<ShipmentType> list) {
	int rowNum=1;
	for(ShipmentType s:list){
	
	Row row= sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(s.getId());
	row.createCell(1).setCellValue(s.getShipmentTypeCode());
	row.createCell(2).setCellValue(s.getShipmentTypeMode());
	row.createCell(3).setCellValue(s.getEnableShipmentType());
	row.createCell(4).setCellValue(s.getShipmentTypeGrade());
	row.createCell(5).setCellValue(s.getDescription());
}
	
	
}
}
	
		
		
		
		
	
		
		
		
		
	
		
		




