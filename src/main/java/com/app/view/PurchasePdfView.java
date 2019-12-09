package com.app.view;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Purchase;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class PurchasePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attachement;filename=purchases.pdf");
		
	
		Paragraph p=new Paragraph( "welcome to Purchase Data");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Purchase> purchases=(List<Purchase>) model.get("list");
		PdfPTable table=new PdfPTable(8);
		
		table.addCell("Id");
		table.addCell("ORDER CODE");
		table.addCell("SHIPMENT MODE");
		table.addCell("VENDOR");
		table.addCell("REFRENCE NUMBER");
		table.addCell("QUALITY CHECK");
		table.addCell("CHECK QUALITY");
		table.addCell("DESCRIPTION");
			for(Purchase p1:purchases) {
				table .addCell(p1.getId().toString());
				table.addCell(p1.getOrderCode());
				table.addCell(p1.getShipmentMode().toString());
				table.addCell(p1.getWhcode().toString());
				table.addCell(p1.getRefrenceNumber());
				table.addCell(p1.getQualityCheck());
				table.addCell(p1.getDefectStatus());
				table.addCell(p1.getDescription());
			}
			
			document.add(table);
			document.add(new Paragraph( new Date(0).toString()));

	}

}
