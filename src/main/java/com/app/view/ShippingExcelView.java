package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Shipping;

public class ShippingExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		resp.addHeader("Content-disposition", "attachment;filename=shippings.xlsx");
		//read data
		List<Shipping> list =(List<Shipping>)  model.get("list");
		
		// create new Sheet
		
		Sheet sheet =book.createSheet("shippings");
		addHeader(sheet);
		addBody(sheet, list);
		
	}

	private void addHeader(Sheet sheet) {
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("SHIPPING CODE");
		row.createCell(2).setCellValue("SHIPPING Ref Num");
		row.createCell(3).setCellValue("CORIER Ref Num");
		row.createCell(4).setCellValue("CONTACT DETAILS");
		row.createCell(5).setCellValue("SALE ORDER CODE");
		row.createCell(6).setCellValue("BILL TO ADDRESS");
		row.createCell(7).setCellValue("SHIP TO ADDRESS");
		row.createCell(8).setCellValue("DESCRIPTION");
		
	}
	
private  void addBody(Sheet sheet, List<Shipping> list) {
	int rowNum=1;
	for(Shipping s:list){
	
	Row row= sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(s.getId());
	row.createCell(1).setCellValue(s.getShippingCode());
	row.createCell(2).setCellValue(s.getShippingRefNum());
	row.createCell(3).setCellValue(s.getCorierRefNum());
	row.createCell(4).setCellValue(s.getContactDetails());
	row.createCell(5).setCellValue(s.getSaleOrder().toString());
	row.createCell(6).setCellValue(s.getBillToaddress());
	row.createCell(7).setCellValue(s.getShipToAddress());
	row.createCell(8).setCellValue(s.getDescription());
}
	
	
}
}
	
		
		