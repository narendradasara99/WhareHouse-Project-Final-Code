package com.app.view;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Grn;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class GrnPdfView extends AbstractPdfView {

	@SuppressWarnings("deprecation")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachement;filename=grns.pdf");
		Paragraph p=new Paragraph( "Welcome To Part Data");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Grn> grns=(List<Grn>) model.get("list");
		PdfPTable table=new PdfPTable(8);
		table.addCell("GRN CODE");
		table.addCell("GRN TYPE");
		table.addCell("ORDER CODE");
		table.addCell("DESCRIPTION");
		for(Grn  p1:grns) {
			table .addCell(p1.getId().toString());
			table .addCell(p1.getCode());
			table .addCell(p1.getGrnType());
			table .addCell(p1.getCode().toString());
			table .addCell(p1.getNote());
		}
		document.add(table);
		document.add(new Paragraph( new Date(0, 0, 0).toString()));


	}

}
