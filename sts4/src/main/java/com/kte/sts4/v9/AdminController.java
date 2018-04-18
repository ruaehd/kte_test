package com.kte.sts4.v9;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.sts4.dao.V9_BusinessConditionsDAO;
import com.kte.sts4.dao.V9_SellerDAO;
import com.kte.sts4.vo.V9_Seller;

@Controller
@MapperScan("com.kte.sts4.dao")
public class AdminController {
	
	@Autowired V9_BusinessConditionsDAO bcDAO = null;
	@Autowired V9_SellerDAO selDAO = null;
	
	@RequestMapping(value="/v9_admin.do", method=RequestMethod.GET)
	public String home(HttpSession httpSession, Model model, @RequestParam(value="menu", defaultValue="-1") int menu) {
		
		if(menu == -1) {	//menu값이 없을 경우
			return "redirect:v9_admin.do?menu=0";
		}
		String id = (String)httpSession.getAttribute("S_ID");
		/*if(id == null) {
			return "redirect:v9_login.do";
		}*/
		
		model.addAttribute("menu_list", Config.menu);
		
		if(menu==0) {
			model.addAttribute("vo0", new V9_Seller());
			model.addAttribute("bc_list", bcDAO.seectBCList());
			model.addAttribute("slist", selDAO.selectSeller());
		}
		
		return "v9/admin";
	}
	
	@RequestMapping(value="/v9_insertseller.do", method=RequestMethod.POST)
	public String insertSeller(@ModelAttribute("vo0") V9_Seller vo) {
		try {
			System.out.println(vo.toString());
			
			selDAO.insertSeller(vo);
			return "redirect:v9_admin.do?menu=0";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:v9_admin.do?menu=0";
		}
	}
	
}
