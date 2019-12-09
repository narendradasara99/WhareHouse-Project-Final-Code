package com.app.view;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Part;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PartPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attachement;filename=parts.pdf");
		Paragraph p=new Paragraph( "Welcome To Part Data");
		document.add(p);
		List<Part> parts=(List<Part>) model.get("list");
		PdfPTable table=new PdfPTable(11);
		table.addCell("ID");
		table.addCell("CODE");
		table.addCell("BASE COST");
		table.addCell("BBASE CURRENCY");
		table.addCell("WIDTH");
		table.addCell("LENGTH");
		table.addCell("HEIGTH");
		table.addCell("UOM");
		table.addCell("ORDER METHOD CODE");
		table.addCell("PURCHASE");
		table.addCell("DESCRIPTION");
			for(Part p1:parts) {
				table .addCell(p1.getId().toString());
				table .addCell(p1.getCode());
				table .addCell(p1.getBaseCost().toString());
				table .addCell(p1.getBaseCurrency());
			/*
			 * table .addCell(p1.getWidth()); table .addCell(p1.getLength()); table
			 * .addCell(p1.getHeigth());
			 */
			
			}
			
			document.add(table);
			document.add(new Paragraph( new Date(0, 0, 0).toString()));


	}

}
