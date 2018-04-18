package com.kte.sts4;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kte.sts4.dao.ChatDAO;
import com.kte.sts4.vo.Member;

@Controller
public class MemberController {
	
	@Autowired private ChatDAO chatDAO = null;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String longin(Model model) {
		
		Member vo = new Member();
		model.addAttribute("vo", vo);
		
		return "login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String longin(HttpSession httpsession, @ModelAttribute("vo") Member vo) {
		if(vo.getId().equals("khlee") && vo.getPw().equals("123")) {
			httpsession.setAttribute("SID", "khlee");
			return "redirect:chat_client.do";
		}
		return "redirect:login.do";
	}
}
