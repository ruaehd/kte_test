package com.kte.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.mvc.vo.MongoDBVO;

@Controller
public class MongoDBCOntroller {
	
	@Autowired private MongoTemplate mongoTemplate = null;
	
	@RequestMapping(value="/mongodb_insert.do", method = RequestMethod.GET)
	public String mongodbInsert(Model model) {
		return "mongodb/mongodb_insert";
	}
	
	@RequestMapping(value="/mongodb_insert.do", method = RequestMethod.POST)
	public String mongodbInsert(@RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("name") String name) {
		
		MongoDBVO vo = new MongoDBVO(id, pw, name);
		
		//(추가할 값, 테이블 명)
		mongoTemplate.save(vo, "member");
		
		return "redirect:mongodb_insert.do";
	}
}
