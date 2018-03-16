package com.kte.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.mvc.exception.PageNotFoundException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@ExceptionHandler(PageNotFoundException.class)
	public String pageNotFound() {
		return "pagenotfound";
	}
	
	@RequestMapping(value="/test_a.do", method = RequestMethod.GET)
	public String testA() {
		return "test_a";
	}
	
	@RequestMapping(value="/test_a.do", method = RequestMethod.POST)
	public String testA(@RequestParam("no") int no, @RequestParam("no1") int no1) {
		System.out.println(no);
		return "redirect:test_a.do";
	}
	
	@RequestMapping(value = "/{path}", method = RequestMethod.GET)
	public String home(@PathVariable("path") String path) {
		if(path.equals("home")) {
			return "home";
		}
		else {
			throw new PageNotFoundException();
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
