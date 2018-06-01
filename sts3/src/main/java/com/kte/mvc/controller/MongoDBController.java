package com.kte.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.mvc.vo.MongoDBVO;

@Controller
public class MongoDBController {

	@Autowired
	private MongoTemplate mongoTemplate = null;
	
	@RequestMapping(value = "/mongodb_list.do", 
			method = RequestMethod.GET)
	public String mongodbList(Model model) {
		//SELECT * FROM 테이블 LIMIT 100;
		Query query = new Query();
		query.limit(100);
		
		//SELECT * FROM 테이블 ORDER BY id ASC
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		query.with(sort);

		//SELECT * FROM 테이블 WHERE id=a
		Criteria criteria = Criteria.where("id").is("a");
		query.addCriteria(criteria);
	
		//SELECT * FROM 테이블 WHERE age BETWEEN 20 AND 50
		//Criteria criteria1 = Criteria.where("age").lt(50).gt(20);
		//query.addCriteria(criteria1);
		
		//(query, 클래스명, Collection명-테이블명)
		List<MongoDBVO> list 
			= mongoTemplate.find(query, MongoDBVO.class, "member");
		model.addAttribute("list", list);
		
		return "mongodb/mongodb_list";
	}

	
	
	@RequestMapping(value = "/mongodb_insert.do", 
			method = RequestMethod.GET)
	public String mongodbInsert(Model model) {
		
		return "mongodb/mongodb_insert";
	}
	@RequestMapping(value = "/mongodb_insert.do", 
			method = RequestMethod.POST)
	public String mongodbInsert(
			@RequestParam("id")String id,
			@RequestParam("pw")String pw,
			@RequestParam("name")String name) {
		MongoDBVO vo = new MongoDBVO(id,pw,name);

		//(추가할 값, 테이블명)
		mongoTemplate.save(vo, "member");
		
		return "redirect:mongodb_insert.do";
	}
}
