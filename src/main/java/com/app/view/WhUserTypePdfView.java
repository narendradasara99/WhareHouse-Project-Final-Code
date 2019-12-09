package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {


		response.addHeader("Content-Disposition", "attachement;filename=whusers.pdf");



		Paragraph p=new Paragraph( "welcome to WhUserType Data");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<WhUserType> users=(List<WhUserType>) model.get("list");
		PdfPTable table=new PdfPTable(4);
		table.addCell("Id");
		table.addCell("WHUSER TYPE");
		table.addCell("WHUSER CODE");
		table.addCell("WHUSER FOR");
		table.addCell("WHUSER EMAIL ");
		table.addCell("WHUSER CONTACT");
		table.addCell("WHUSER ID TYPE");
		table.addCell("WHUSER ID IF OTHER");
		table.addCell("WHUSER ID NUMBER");
		for(WhUserType u:users) {
			
			
			table .addCell(u.getId().toString());
			table.addCell(u.getWhuserType());
			table.addCell(u.getWhuserCode());
			table.addCell(u.getWhuserFor());
			table.addCell(u.getWhuserEmail());
			table.addCell(u.getWhuserContact());
			table.addCell(u.getWhuserIdType());
			table.addCell(u.getWhuserIdOther());
			table.addCell(u.getWhuserIdNumber());
		}

		document.add(table);
		document.add(new Paragraph( new Date().toString()));

	}


}
