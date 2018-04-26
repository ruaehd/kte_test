package com.kte.sts4.v9;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class V9_MainController {
	@RequestMapping(value = "/v9_main.do", method = RequestMethod.GET)
	public String main() {
		return "v9/main";
	}
	
	@RequestMapping(value = "/v9_alert.do", method = RequestMethod.GET)
	public String alert() {
		return "v9/alert";
	}
}
