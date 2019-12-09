package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Part;

public class PartExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-disposition", "attachment;filename=patrs.xlsx");
		//read data
		List<Part> list =(List<Part>)  model.get("list");

		// create new Sheet

		Sheet sheet =book.createSheet("parts");
		addHeader(sheet);
		addBody(sheet, list);

	}

	private void addHeader(Sheet sheet) {
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("BASE COST");
		row.createCell(3).setCellValue("BBASE CURRENCY");
		row.createCell(4).setCellValue("UON");
		row.createCell(5).setCellValue("ORDER METHOD CODE");
		row.createCell(6).setCellValue("PURCHASE");
		row.createCell(7).setCellValue("DESCRIPTION");

	}

	private  void addBody(Sheet sheet, List<Part> list) {
		int rowNum=1;
		for(Part p:list){

			Row row= sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(p.getId());
			row.createCell(1).setCellValue(p.getCode());
			row.createCell(2).setCellValue(p.getBaseCost());
			row.createCell(3).setCellValue(p.getBaseCurrency());

		}
	}

}
