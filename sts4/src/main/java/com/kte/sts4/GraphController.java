package com.kte.sts4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GraphController {
	
	@RequestMapping(value = "/table.do", method = RequestMethod.GET)
	public String table(Model model) {
		return "table";
	}
}
