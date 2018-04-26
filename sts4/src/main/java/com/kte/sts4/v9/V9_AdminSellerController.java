package com.kte.sts4.v9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.sts4.dao.ItemDAOImpl;

@Controller
public class V9_AdminSellerController {
	
	@Autowired ItemDAOImpl itemDAO = null;
	
	@RequestMapping(value="/v9_adminseller.do", method=RequestMethod.GET)
	public String updateSeller(Model model, @RequestParam(value="menu", defaultValue="0") int menu) {
		final String[] menu_name = {"물품관리", "판매관리", "배송관리"};
		final String[] menu_url = {"item", "sell", "delivery"};
		
		List<Object> list = null;
		
		if(menu==0) {
				list = itemDAO.selectItemList();
		}
		else if(menu==1) {
			
		}
		else if(menu==2) {
			
		}
		
		model.addAttribute("list", list);
		model.addAttribute("menu_name", menu_name);
		model.addAttribute("menu_url", menu_url);
		
		return "v9/adminseller";
	}
}
