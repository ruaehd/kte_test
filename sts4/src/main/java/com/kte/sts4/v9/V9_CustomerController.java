package com.kte.sts4.v9;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kte.sts4.dao.V9_CustomerDAO;
import com.kte.sts4.vo.V9_Member;

@Controller
@MapperScan({ "com.kte.sts4.dao" })
public class V9_CustomerController {

	@Autowired
	private V9_CustomerDAO csDAO = null;

	@RequestMapping(value = { "/v9_customerjoin.do" }, method = RequestMethod.GET)
	public String customerJoin(Model model) {
		model.addAttribute("vo", new V9_Member());
		return "v9/customerjoin";
	}

	@RequestMapping(value = { "/v9_customerjoin.do" }, method = RequestMethod.POST)
	public String customerJoin(@ModelAttribute("vo") V9_Member vo) {
		try {
			// 전달되는 값 확인
			System.out.println(vo.toString());
			csDAO.insertCustomer(vo);
			return "redirect:v9_main.do";
		} catch (Exception e) {
			return "redirect:v9_alert.do";
		}
	}

	@RequestMapping(value = { "/v9_customerlogin.do" }, method = RequestMethod.GET)
	public String customerLogin(Model model) {
		model.addAttribute("vo", new V9_Member());
		return "v9/customerlogin";
	}

	@RequestMapping(value = { "/v9_customerlogout.do" }, method = RequestMethod.GET)
	public String customerLogin(HttpSession httpsession) {
		httpsession.invalidate();
		return "redirect:v9_main.do";
	}

	@RequestMapping(value = {"/v9_customerlogin.do"}, method = RequestMethod.POST)
	public String customerLogin(@ModelAttribute("vo") V9_Member vo, HttpSession httpsession ) {
		try {
			V9_Member vo1= csDAO.selectLogin(vo);
			if(vo1 != null) {
				httpsession.setAttribute("_id", vo1.getId());
				httpsession.setAttribute("_name", vo1.getName());
				return "redirect:v9_main.do";
			}
			else {
				return "redirect:v9_customerlogin.do";
			}
		}
		catch(Exception e) {
			return "redirect:v9_customerlogin.do";
		}
	}


}
