package com.kte.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kte.mvc.dao.MemberDAO;
import com.kte.mvc.vo.V3_FormVO;
import com.kte.mvc.vo.V3_MemberVO;

@Controller
public class khController {

	@Autowired						//DAO사용하기위해
	private MemberDAO mDAO = null;
	
	@RequestMapping(value="/kh_join.do", method= {RequestMethod.GET})
	//Model model == HttpServletRequest request
	public String join() {
		return "kh_join"; //표시
	}

	@RequestMapping(value="/kh_login.do", method=RequestMethod.GET)
	public String login() {
		return "kh_login";
	}
	

	@RequestMapping(value="/kh_edit.do", method=RequestMethod.GET)
	public String edit() {		
		return "kh_edit";
	}

}
