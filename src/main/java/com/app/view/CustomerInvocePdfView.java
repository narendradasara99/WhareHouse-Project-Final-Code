package com.app.view;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.app.model.Sale;
import com.app.model.SaleDtl;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerInvocePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment;filename=SALEINVOICE.pdf");
		//read data from Controller
		Sale parent=(Sale)model.get("parent");
		//childs
		List<SaleDtl> list=parent.getChilds();
		double finalCost=0.0;
		for(SaleDtl dtl:list){
			finalCost+=dtl.getPart().getBaseCost()*dtl.getQty();
		}
		
		//doc.add(Image.getInstance("resources/images/logo.png"));
		Image img = Image.getInstance(new URL("https://sathyatech.com/wp-content/uploads/2018/04/sathya_technolologies_Logo.png"));

		Phrase phrase = new Phrase();
		phrase.add(new Chunk(img, 100,-5));

		doc.add(new Paragraph(phrase));
		
		doc.add(new Paragraph("CUSTOMER INVOICE CODE:VEN-"+parent.getOrderCode()));
        
		// define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
		
        
		PdfPTable heading=new PdfPTable(4);
		heading.setWidthPercentage(100.0f);
		heading.setWidths(new float[]{2.5f,2.5f,2.5f,2.5f});
		heading.setSpacingBefore(10);
		
		cell.setPhrase(new Phrase("Customer Code", font));
		heading.addCell(cell);
		heading.addCell(parent.getWhcode().getWhuserCode());
		
		cell.setPhrase(new Phrase("Order Code", font));
		heading.addCell(cell);
		heading.addCell(parent.getOrderCode());
		
		cell.setPhrase(new Phrase("Final Cost", font));
		heading.addCell(cell);
		heading.addCell(new BigDecimal(finalCost).setScale(3, RoundingMode.CEILING).toString());
		
		cell.setPhrase(new Phrase("Shipment Type", font));
		heading.addCell(cell);
		heading.addCell(parent.getShipmentMode().getShipmentTypeCode());
		
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {1.0f, 3.0f, 2.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);
         
         
        // write table header
        
        
        cell.setPhrase(new Phrase("Item ", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Cost", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Quantity", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Item Value", font));
        table.addCell(cell);
         
        // write table row data
        int count=0;
        for (SaleDtl details : list) {
            table.addCell(String.valueOf(++count));
            table.addCell(details.getPart().getCode());
            table.addCell(String.valueOf(details.getPart() .getBaseCost()));
            table.addCell(String.valueOf(details.getQty()));
            table.addCell(String.valueOf(details.getPart().getBaseCost()*details.getQty()));
        }
        doc.add(heading);
        doc.add(table);
		doc.add(new Paragraph("Generated On:"+new Date()));
	}

}
