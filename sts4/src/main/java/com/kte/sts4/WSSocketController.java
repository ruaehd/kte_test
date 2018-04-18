package com.kte.sts4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WSSocketController {
	@RequestMapping(value = "/chat_client.do", method = RequestMethod.GET)
	public String chat(Model model) {
		return "chat_client";
	}
}
