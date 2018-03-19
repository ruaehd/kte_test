package com.kte.mvc.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBuilder extends AbstractITextPdfView{

	@Override
	protected void buildDocument(Map<String, Object> arg0, Document doc, PdfWriter writer, HttpServletRequest arg1, HttpServletResponse arg2) throws Exception {
		// TODO Auto-generated method stub
		
		//테이블 크기 100%
		PdfPTable table= new PdfPTable(5);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
		table.setSpacingBefore(10);
		//폰트설정
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.GREEN);
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
		cell.setPhrase(new Phrase("id", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("addr", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("tel", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("email", font));
		table.addCell(cell);
		
		doc.add(table);
		
	}

}
