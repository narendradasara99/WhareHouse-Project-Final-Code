package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		response.addHeader("Content-Disposition", "attachement;filename=shipments.pdf");
		
		Paragraph p =new Paragraph("Welcome to Shipment Type Data");
		document.add(p);
		
	
		@SuppressWarnings("unchecked")
		List<ShipmentType> shipments=(List<ShipmentType>) model.get("list");
		PdfPTable table=new PdfPTable(6);
		table.addCell("Id");
		table.addCell("SHIPMENTTYPE MODE");
		table.addCell("SHIPMENTTYPE CODE");
		table.addCell("ENABLE SHIPMENT");
		table.addCell("SHOPMENTTYPE GRADE");
		table.addCell("DEACRIPTION");
		
		
				for(ShipmentType s:shipments) {
					table.addCell(s.getId().toString());
					table.addCell(s.getShipmentTypeMode());
					table.addCell(s.getShipmentTypeCode());
					table.addCell(s.getEnableShipmentType());
					table.addCell(s.getShipmentTypeGrade());
					table.addCell(s.getDescription());
				}
				
				document.add(table);
				document.add(new Paragraph(new Date().toString()));


	}

}
