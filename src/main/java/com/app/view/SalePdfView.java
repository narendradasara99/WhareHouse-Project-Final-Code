package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Sale;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class SalePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attachement;filename=sales.pdf");
		
	
		Paragraph p=new Paragraph( "welcome to Sale Data");
		document.add(p);
		List<Sale> sales=(List<Sale>) model.get("list");
		PdfPTable table=new PdfPTable(7);
		table.addCell("ID");
		table.addCell("SALE CODE");
		table.addCell("SHIPMENT MODE");
		table.addCell("CUSTOMER");
		table.addCell("STOCK MODE");
		table.addCell("STOCK SOURCE");
		table.addCell("DESCRIPTION");
			for(Sale  p1:sales) {
				table .addCell(p1.getId().toString());
				table .addCell(p1.getOrderCode());
			
			  table .addCell(p1.getShipmentMode().toString());
			  table.addCell(p1.getWhcode().toString());
			  table.addCell(p1.getStockMode());
			  table.addCell(p1.getStockSource());
			  table.addCell(p1.getDescription());
			 
			}
			
			document.add(table);
			document.add(new Paragraph( new Date().toString()));

	}

}
