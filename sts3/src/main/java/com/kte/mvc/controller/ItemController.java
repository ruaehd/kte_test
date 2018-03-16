package com.kte.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kte.mvc.dao.V6_ItemDAO;
import com.kte.mvc.vo.V6_ItemA;

@Controller
public class ItemController {

	@Autowired
	private V6_ItemDAO iDAO = null;
	
	@RequestMapping(value = "/v6_item.do", method = RequestMethod.GET)
	public String item(Model model) {
		List<V6_ItemA> list = iDAO.selectItemAList();
		
		model.addAttribute("list", list);
		return "v6_item";
	}

}
