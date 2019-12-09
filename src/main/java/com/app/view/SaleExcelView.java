package com.app.view;

import java.util.List;							
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Sale;

public class SaleExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		resp.addHeader("Content-disposition", "attachment;filename=sales.xlsx");
		//read data
		List<Sale> list =(List<Sale>)  model.get("list");
		
		// create new Sheet
		
		Sheet sheet =book.createSheet("Sales");
		addHeader(sheet);
		addBody(sheet, list);
		
	}

	private void addHeader(Sheet sheet) {
		
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("SALE CODE");
		row.createCell(2).setCellValue("SHIPMENT MODE");
		row.createCell(3).setCellValue("CUSTOMER");
		row.createCell(4).setCellValue("STOCK MODE");
		row.createCell(5).setCellValue("STOCK SOURCE");
		row.createCell(6).setCellValue("DESCRIPTION");
		
	}
	
private  void addBody(Sheet sheet, List<Sale> list) {
	int rowNum=1;
	for(Sale s:list){
	
	Row row= sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(s.getId());
	row.createCell(1).setCellValue(s.getOrderCode());
			
			  row.createCell(2).setCellValue(s.getShipmentMode().toString());
			  row.createCell(3).setCellValue(s.getWhcode().toString());
			  row.createCell(4).setCellValue(s.getStockMode());
			  row.createCell(5).setCellValue(s.getStockSource());
			  row.createCell(6).setCellValue(s.getDescription());
			 
}
	
}
}
	
		
		