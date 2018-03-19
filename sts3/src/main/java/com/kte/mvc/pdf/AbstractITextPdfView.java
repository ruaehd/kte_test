package com.kte.mvc.pdf;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractITextPdfView extends AbstractView{

	public AbstractITextPdfView() {
		setContentType("application/pdf");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws Exception {
		// TODO Auto-generated method stub
		ByteArrayOutputStream baos = createTemporaryOutputStream();
		Document doc = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(doc, baos);
		
		writer.setViewerPreferences(PdfWriter.ALLOW_PRINTING|PdfWriter.PageLayoutSinglePage);
		
		doc.open();
		//여기에 문서를 만듬
		buildDocument(arg0, doc, writer, arg1, arg2);
		doc.close();
		writeToResponse(arg2, baos);
	}
	
	protected abstract void buildDocument(Map<String, Object> arg0,  Document doc, PdfWriter writer, HttpServletRequest arg1, HttpServletResponse arg2) throws Exception;
	
}
