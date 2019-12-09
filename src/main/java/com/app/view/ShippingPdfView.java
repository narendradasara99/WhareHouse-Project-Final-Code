package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Shipping;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShippingPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attachement;filename=shippings.pdf");
		
	
		Paragraph p=new Paragraph( "welcome to Shipping Data");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Shipping> shipping=(List<Shipping>) model.get("list");
		PdfPTable table=new PdfPTable(9);
		table.addCell("Id");
		table.addCell("SHIPPING CODE");
		table.addCell("SHIPPING Ref Num");
		table.addCell("CORIER Ref Num");
		table.addCell("CONTACT DETAILS");
		table.addCell("SALE ORDER CODE");
		table.addCell("BILL TO ADDRESS");
		table.addCell("SHIP TO ADDRESS");
		table.addCell("DESCRIPTION");
			for(Shipping sg:shipping) {
				table .addCell(sg.getId().toString());
				table.addCell(sg.getShippingCode());
				table.addCell(sg.getShippingRefNum());
				table.addCell(sg.getContactDetails());
				table.addCell(sg.getCorierRefNum());
				table.addCell(sg.getSaleOrder().toString());
				table.addCell(sg.getBillToaddress());
				table.addCell(sg.getShipToAddress());
				table.addCell(sg.getDescription());
			}
			
			document.add(table);
			document.add(new Paragraph( new Date().toString()));

	}

}
