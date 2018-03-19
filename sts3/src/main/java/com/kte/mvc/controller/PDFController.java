package com.kte.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PDFController {
	
	@RequestMapping(value="/pdf1.do", method=RequestMethod.GET)
	public String pdf1(Model model) {
		model.addAttribute("title", "PDF만들기");
		//pdfView.jsp가 호출되는것이 아니라 PDFBuilder가 호출됨.
		return "pdfView";
	}
}
