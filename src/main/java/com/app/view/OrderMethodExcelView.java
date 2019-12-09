package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		resp.addHeader("Content-disposition", "attachment;filename=Orders.xlsx");
		//read data
		List<OrderMethod> list =(List<OrderMethod>)  model.get("list");
		
		// create new Sheet
		
		Sheet sheet =book.createSheet("Orders");
		addHeader(sheet);
		addBody(sheet, list);
		
	}
	
	
	private void addHeader(Sheet sheet) {
		
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("ORDERMODE");
		row.createCell(2).setCellValue("ORDERCODE");
		row.createCell(3).setCellValue("ORDERTYPE");
		row.createCell(4).setCellValue("ORDERACCEPT");
		row.createCell(4).setCellValue("DESCRIPTION");
		
		
	}
	
private  void addBody(Sheet sheet, List<OrderMethod> list) {
	int rowNum=1;
	for(OrderMethod o:list){
	
	Row row= sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(o.getId());
	row.createCell(1).setCellValue(o.getOrderMode());
	row.createCell(2).setCellValue(o.getOrderCode() );
	row.createCell(3).setCellValue(o.getOrderType());
	row.createCell(4).setCellValue(o.getOrderAccept().toString());
	row.createCell(5).setCellValue(o.getDescription());
}
	
	
}
}
	
		
		
		
		
	
		
		
		
		
	
		
		




