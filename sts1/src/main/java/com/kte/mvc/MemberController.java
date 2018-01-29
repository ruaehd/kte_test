package com.kte.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {		
		return "v1_login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login1(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		return "redirect:login.do";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(HttpServletRequest request, HttpServletResponse response) {
		return "v1_join";
	}
	
	public String changeMember() {
		return null;
	}
	
	
}
