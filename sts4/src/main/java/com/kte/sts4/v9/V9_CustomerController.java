package com.kte.sts4.v9;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kte.sts4.vo.V9_Member;

@Controller
public class V9_CustomerController {
	@RequestMapping(value="/v9_customerjoin.do", method=RequestMethod.GET)
	public String customerJoin(Model model) {
		
		model.addAttribute("vo", new V9_Member());
		return "v9/customerjoin";
	}
}
