package com.kte.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.mvc.dao.V4_BookXMLDAO;
import com.kte.mvc.vo.V4_Book;
import com.kte.mvc.vo.V4_BookCheckout;

@Controller
public class BookController {
	
	@Autowired private V4_BookXMLDAO bookDAO = null;
	
	@RequestMapping(value="/book_checkout.do", method=RequestMethod.GET)
	public String bookcheckout(Model model) {
		
		//도서 목록
		List<V4_Book> list = bookDAO.selectBookList();
		model.addAttribute("list", list);
		
		//jsp로 vo를 전달함
		V4_BookCheckout vo = new V4_BookCheckout();
		//vo.setCheckout_book_list(list);
		model.addAttribute("vo", vo);
		return "book_checkout";
	}
	
	@RequestMapping(value="/book_checkout.do", method=RequestMethod.POST)
	public String bookcheckout(@ModelAttribute("vo") V4_BookCheckout vo) {
		
		vo.setMember_id("khlee");
		bookDAO.insertBookCheckout(vo);
		
		return "redirect:book_checkoutlist.do";
	}
	
	@RequestMapping(value="/book_checkoutlist.do", method=RequestMethod.GET)
	public String bookcheckoutlist(Model model) {
		
		List<V4_BookCheckout> list = bookDAO.selectBookCheckoutList("khlee");
		
		model.addAttribute("list", list);
		return "book_checkoutlist";
	}
	
	@RequestMapping(value="/book_checkoutdel.do", method=RequestMethod.GET)
	public String bookcheckoutDel(@RequestParam("code") int code) {
		bookDAO.deleteBookCheckoutList(code);
		return "redirect:book_checkoutlist.do";
	}
}
