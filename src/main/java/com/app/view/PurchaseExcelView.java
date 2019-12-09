package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Purchase;

public class PurchaseExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		resp.addHeader("Content-disposition", "attachment;filename=purchase.xlsx");
		//read data
		List<Purchase> list =(List<Purchase>)  model.get("list");
		
		// create new Sheet
		
		Sheet sheet =book.createSheet("Purchase");
		addHeader(sheet);
		addBody(sheet, list);
		
	}
	
	
	private void addHeader(Sheet sheet) {
		
		
		
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("ORDER CODE");
		row.createCell(2).setCellValue("SHIPMENT MODE");
		row.createCell(3).setCellValue("VENDOR");
		row.createCell(4).setCellValue("REFRENCE NUMBER");
		row.createCell(5).setCellValue("QUALITY CHECK");
		row.createCell(6).setCellValue("CHECK QUALITY");
		row.createCell(7).setCellValue("DESCRIPTION");
		
	}
	
private  void addBody(Sheet sheet, List<Purchase> list) {
	int rowNum=1;
	for(Purchase p:list){
	
	Row row= sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(p.getId());
	row.createCell(1).setCellValue(p.getOrderCode());
	row.createCell(2).setCellValue(p.getShipmentMode().toString());
	row.createCell(3).setCellValue(p.getWhcode().toString());
	row.createCell(4).setCellValue(p.getWhcode().toString());
	row.createCell(5).setCellValue(p.getQualityCheck());
	row.createCell(6).setCellValue(p.getDefectStatus());
	row.createCell(7).setCellValue(p.getDescription());
}
	
	
}
}
	
		
		
		
		
	
		
		
		
		
	
		
		




