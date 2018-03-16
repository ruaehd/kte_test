package com.kte.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kte.mvc.dao.V3_MemberXMLDAO;
import com.kte.mvc.vo.V3_Member;


@Controller
public class MemberController {
	
	@Autowired
	private V3_MemberXMLDAO mxDAO = null;
	
	@RequestMapping(value="/memberlist.do", method = RequestMethod.GET)
	public String memberlist(Model model) {
		
		List<V3_Member> list = mxDAO.selectMemberList();
		model.addAttribute("list", list);
		
		return "memberlist";
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.GET)
	public String join(Model model) {
		
		V3_Member vo = new V3_Member();
		
		model.addAttribute("vo", vo);

		return "join";
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.POST)
	public String join(@ModelAttribute("vo") V3_Member vo) {
		
		try {
			
			for(String tmp : vo.getNs_name()) {
				System.out.println(tmp);
			}
			
			//ArratList의 값을을 한개의 String로 변경, 구분자는 ","
			String a = String.join(",", vo.getNs_name());
			vo.setNs_name_str(a);
			
			System.out.println(a);
			
			mxDAO.insertMember(vo);
			return "redirect:/";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	@RequestMapping(value="/edit.do", method = RequestMethod.GET)
	public String edit(Model model, HttpSession httpsession) {
		
		//세션에서 이메일(기본키)를 받음
		String em = (String)httpsession.getAttribute("_email");
		
		if(em != null) {	//세션이 시간이 지나면 자동으로 값이 사라지기 때문에 확인해주는 단계 필요
			//DAO로 이메일을 전달함 => 이메일에 해당하는 회원정보를 받음
			V3_Member vo = mxDAO.selectMemberOne(em);
			
			//jsp로 vo값 전달
			model.addAttribute("vo", vo);

			return "edit";
		}
		else {
			return "redirect:memberlogin.do";
		}
		
	}
	
	@RequestMapping(value="/edit.do", method = RequestMethod.POST)
	public String edit(@ModelAttribute("vo") V3_Member vo, HttpSession httpsession, Model model) {
		try {
			String em = (String)httpsession.getAttribute("_email");
			
			if(em != null) {
				mxDAO.updateMember(vo);
				httpsession.setAttribute("_name", vo.getName());	//바뀐 이름 세션에 다시 넣음
				
				model.addAttribute("message", "회원정보가 수정되었습니다.");
				model.addAttribute("url", "/mvc/");
				return "alert";
			}
			else {
				return "redirect:memberlogin.do";
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public String delete(Model model, HttpSession httpsession) {
		
		String em = (String)httpsession.getAttribute("_email");
		
		if(em != null) {
			V3_Member vo = mxDAO.selectMemberOne(em);
						
			model.addAttribute("vo", vo);
			return "delete";
		}
		else {
			return "redirect:memberlogin.do";
		}
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public String delete(@ModelAttribute("vo") V3_Member vo, HttpSession httpsession, Model model) {
		try {
			String em = (String)httpsession.getAttribute("_email");
			
			if(em != null) {
				int ret = mxDAO.deleteMember(vo);
				
				if(ret > 0) {
					model.addAttribute("message", "회원정보가 삭제 되었습니다.");
					model.addAttribute("url", "memberlogout.do");
					return "alert";
				}
				else {
					model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
					model.addAttribute("url", "delete.do");
					return "alert";
				}
				
			}
			else {
				return "redirect:memberlogin.do";
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(value="/memberlogin.do", method = RequestMethod.GET)
	public String memberLogin(Model model) {
		V3_Member vo = new V3_Member();

		model.addAttribute("vo", vo);

		return "memberlogin";
	}
	
	@RequestMapping(value="/memberlogin.do", method = RequestMethod.POST)
	public String memberLogin(Model model, @ModelAttribute("vo") V3_Member vo, HttpSession httpsession) {
		try {
			V3_Member rvo = mxDAO.selectMemberLogin(vo);
			
			if(rvo != null) {
				String tmp = (String)httpsession.getAttribute("back_url");
				httpsession.setAttribute("_email", rvo.getEmail());
				httpsession.setAttribute("_name", rvo.getName());
				return "redirect:"+tmp;
			}
			else {
				model.addAttribute("message", "아이디 또는 암호가 틀립니다.");
				model.addAttribute("url", "memberlogin.do");
				return "alert";
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	

	@RequestMapping(value="/memberlogout.do", method = RequestMethod.GET)
	public String memberLogout(HttpSession httpsession) {
		
		httpsession.invalidate();
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/memberchangepw.do", method = RequestMethod.GET)
	public String memberchangepw(Model model, HttpSession httpsession) {
		String em = (String)httpsession.getAttribute("_email");
		
		if(em != null) {
			V3_Member vo = new V3_Member();
			vo.setEmail(em);
			
			model.addAttribute("vo", vo);
			return "memberchangepw";
		}
		else {
			return "redirect:memberlogin.do";
		}
	}
	
	@RequestMapping(value="/memberchangepw.do", method = RequestMethod.POST)
	public String memberchangepw(Model model, @ModelAttribute("vo") V3_Member vo, HttpSession httpsession) {
		String em = (String)httpsession.getAttribute("_email");
		
		if(em != null) {
			int ret = mxDAO.updateMemberPw(vo);
			
			if(ret > 0) {
				model.addAttribute("message", "비밀번호가 수정되었습니다.");
				model.addAttribute("url", "/mvc/");
				return "alert";
			}
			else {
				model.addAttribute("message", "기존 비밀번호가 일치하지 않습니다.");
				model.addAttribute("url", "memberchangepw.do");
				return "alert";
			}
			
		}
		else {
			return "redirect:memberlogin.do";
		}
	}
	
}
