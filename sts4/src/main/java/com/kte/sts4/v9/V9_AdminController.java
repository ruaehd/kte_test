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
// 1. dao위치 지정
@MapperScan({ "com.kte.sts4.dao" })
public class V9_AdminController {

	// 2. dao객체 생성
	@Autowired
	private V9_BusinessConditionsDAO bcDAO;

	@Autowired
	private V9_SellerDAO selDAO;

	@RequestMapping(value = "/v9_updateseller.do", method = RequestMethod.POST)
	public String updateSeller(@RequestParam("update_cr_number") String cr_number,
			@RequestParam("update_name") String name, @RequestParam("update_tel") String tel,
			@RequestParam("update_addr") String addr, @RequestParam("update_bc_name") String bc_name) {
		try {
			V9_Seller vo = new V9_Seller();
			vo.setCr_number(cr_number);
			vo.setName(name);
			vo.setTel(tel);
			vo.setAddr(addr);
			vo.setCode(bc_name);
			// System.out.println(vo.toString());

			selDAO.updateSeller(vo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:v9_admin.do?menu=0&page=1";
	}

	@RequestMapping(value = "/v9_deleteseller.do", method = RequestMethod.GET)
	public String insertSeller(@RequestParam("cr_number") String cr_number) {
		try {
			selDAO.deleteSeller(cr_number);
		} catch (Exception e) {

		}
		return "redirect:v9_admin.do?menu=0";
	}

	@RequestMapping(value = "/v9_insertseller.do", method = RequestMethod.POST)
	public String insertSeller(@ModelAttribute("vo0") V9_Seller vo) {
		try {
			System.out.println(vo.toString());
			selDAO.insertSeller(vo);
		} catch (Exception e) {

		}
		return "redirect:v9_admin.do?menu=0";
	}

	@RequestMapping(value = "/v9_admin.do", method = RequestMethod.GET)
	public String home(HttpSession httpsession, Model model,
			@RequestParam(value = "menu", defaultValue = "-1") int menu,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "sel_bc", defaultValue = "all") String sel_bc) {
		if (menu == -1) { // menu값이 없을 경우
			return "redirect:v9_admin.do?menu=0&page=1";
		}

		// String id = (String)httpsession.getAttribute("S_ID");
		// if(id == null) {
		// return "redirect:v9_login.do";
		// }

		model.addAttribute("menu_list", Config.menu);
		if (menu == 0) {
			if (sel_bc.equals("all")) {
				model.addAttribute("sel_list_cnt", (selDAO.selectSellerCount1() - 1) / 10 + 1);
				model.addAttribute("sel_list", selDAO.selectSeller1((page - 1) * 10));
			} else {
				model.addAttribute("sel_list_cnt", (selDAO.selectSellerCount(sel_bc) - 1) / 10 + 1);
				model.addAttribute("sel_list", selDAO.selectSeller((page - 1) * 10, sel_bc));
			}
			model.addAttribute("vo0", new V9_Seller());
			model.addAttribute("bc_list", bcDAO.selectBCList());
		}
		return "v9/admin";
	}
}
