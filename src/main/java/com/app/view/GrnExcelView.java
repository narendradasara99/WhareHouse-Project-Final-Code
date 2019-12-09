package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Grn;

public class GrnExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment;filename=grns.xlsx");
		//read data
		@SuppressWarnings("unchecked")
		List<Grn> list =(List<Grn>)  model.get("list");

		// create new Sheet

		Sheet sheet =book.createSheet("grns");
		addHeader(sheet);
		addBody(sheet, list);

	}

	private void addHeader(Sheet sheet) {

		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("GRN CODE");
		row.createCell(2).setCellValue("GRN TYPE");
		row.createCell(3).setCellValue("ORDER CODE");
		row.createCell(4).setCellValue("DESCRIPTION");

	}

	private  void addBody(Sheet sheet, List<Grn> list) {
		int rowNum=1;
		for(Grn p:list){
			Row row= sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(p.getId());
			row.createCell(1).setCellValue(p.getCode());
			row.createCell(2).setCellValue(p.getGrnType());
			row.createCell(3).setCellValue(p.getCode().toString());
			row.createCell(4).setCellValue(p.getId());

		}
	}

}
