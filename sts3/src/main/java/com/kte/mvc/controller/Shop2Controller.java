package com.kte.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kte.mvc.vo.V6_Member;

@Controller
@SessionAttributes({"vo"})
public class Shop2Controller {

	@RequestMapping(value="/v6_shoppayment2.do",	method = RequestMethod.GET)
	public String shopPayment(@ModelAttribute("vo")V6_Member vo) {
		//로그인이 되었기 때문에 결제 진행
		if(vo.getMem_id() != null) {
			return "v6_shoppayment2";
		}
		else { //로그인 안되었음.
			return "v6_memberlogin2.do";
		}
	}
}
