package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		resp.addHeader("Content-disposition", "attachment;filename=users.xlsx");
		//read data
		List<WhUserType> list =(List<WhUserType>)  model.get("list");
		
		// create new Sheet
		
		Sheet sheet =book.createSheet("Users");
		addHeader(sheet);
		addBody(sheet, list);
		
	}
	
	
	private void addHeader(Sheet sheet) {
		
		
		 
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("WHUSER TYPE");
		row.createCell(2).setCellValue("WHUSER CODE");
		row.createCell(3).setCellValue("WHUSER FOR");
		row.createCell(4).setCellValue("WHUSER EMAIL");
		row.createCell(5).setCellValue("WHUSER CONTACT ");
		row.createCell(6).setCellValue("WHUSER ID TYPE");
		row.createCell(7).setCellValue("WHUSER ID IF OTHER");
		row.createCell(8).setCellValue("WHUSER ID NUMBER");
		
		
	}
	
private  void addBody(Sheet sheet, List<WhUserType> list) {
	int rowNum=1;
	for(WhUserType u:list){
	
	Row row= sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(u.getId());
	row.createCell(1).setCellValue(u.getWhuserType());
	row.createCell(2).setCellValue(u.getWhuserCode());
	row.createCell(3).setCellValue(u.getWhuserFor());
	row.createCell(4).setCellValue(u.getWhuserEmail());
	row.createCell(5).setCellValue(u.getWhuserContact());
	row.createCell(6).setCellValue(u.getWhuserIdType());
	row.createCell(7).setCellValue(u.getWhuserIdOther());
	row.createCell(8).setCellValue(u.getWhuserIdNumber());


}
	
	
}
}
	
		
		
		
		
	
		
		
		
		
	
		
		




