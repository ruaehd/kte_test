package com.kte.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kte.mvc.vo.Member;

@RestController
public class JSONController {
	@RequestMapping(value="/json_idcheck.do", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Member json_idcheck() {
		
		Member vo = new Member();
		vo.setId("aaa");
		vo.setPw("bbb");
		vo.setName("ccc");
		
		return vo;
	}
}
