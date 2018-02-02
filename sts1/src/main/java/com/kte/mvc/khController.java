package com.kte.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kte.mvc.dao.MemberDAO;
import com.kte.mvc.vo.V3_MemberVO;

@Controller
public class khController {

	@RequestMapping(value="/kh_login.do", method=RequestMethod.GET)
	public String login() {
		return "kh_login";
	}
	
	@RequestMapping(value="/kh_join.do", method=RequestMethod.GET)
	public String join() {
		return "kh_join";
	}
	
	@RequestMapping(value="/kh_edit.do", method=RequestMethod.GET)
	public String edit() {
		return "kh_edit";
	}

}
