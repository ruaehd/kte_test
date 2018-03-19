package com.kte.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kte.mvc.dao.V6_MemberDAO;
import com.kte.mvc.vo.V6_Member;
import com.kte.mvc.vo.V6_MemberList;
import com.kte.mvc.vo.V6_Member_chk;

@Controller
@SessionAttributes({"map"})
public class Member2Controller {
	
	@Autowired private V6_MemberDAO mDAO = null;
	
	@RequestMapping(value="/v6_member.do", method= RequestMethod.GET)
	public String v6member(Model model) {
		V6_Member vo = new V6_Member();
		List<V6_Member_chk> list = new ArrayList<V6_Member_chk>();
		
		String[] str = {"java", "c", "Spring", "servlet", "jsp", "hadoop"};
		
		for(int i=0; i<6; i++) {
			V6_Member_chk vo1 = new V6_Member_chk();
			vo1.setMemc_title(str[i]);
			list.add(vo1);
		}
		
		vo.setList(list);
		model.addAttribute("vo", vo);
		
		return "v6_member";
	}
	
	@RequestMapping(value="/v6_member.do", method= RequestMethod.POST)
	public String v6member(@ModelAttribute("vo") V6_Member vo) {
		
		System.out.println(vo.getMem_id());
		System.out.println(vo.getMem_pw());
		System.out.println(vo.getMem_name());
		
		for(V6_Member_chk tmp : vo.getList()) {
			System.out.println(tmp.getMemc_title());
			System.out.println(tmp.isMemc_title1());
		}
		return "redirect:v6_member.do";
	}
	
	
	
	
	
	@RequestMapping(value="/v6_member1.do", method= RequestMethod.GET)
	public String v6member1(Model model) {
		V6_Member vo = new V6_Member();
		String[] str = {"java", "c", "Spring", "servlet", "jsp", "hadoop"};

		model.addAttribute("vo", vo);
		model.addAttribute("str", str);
		
		return "v6_member1";
	}
	
	@RequestMapping(value="/v6_member1.do", method= RequestMethod.POST)
	public String v6member1(@ModelAttribute("vo") V6_Member vo, @RequestParam("str[]") String[] chk) {
		
		//체크박스를 포함하는 vo객체를 담을 list를 만듬
		List<V6_Member_chk> list = new ArrayList<V6_Member_chk>();
		int no = mDAO.selectMemcNo();
		int i = 0;
		for(String tmp : chk) {
			i++;
			//체크박스 한개당 vo 생성
			V6_Member_chk vo1 = new V6_Member_chk();
			vo1.setMem_id(vo.getMem_id());
			vo1.setMemc_title(tmp);
			vo1.setMemc_no(no+i);
			list.add(vo1);
		}
		vo.setList(list);
		
		mDAO.insertMember(vo);
		
		return "redirect:v6_member1.do";
	}
	
	
	
	@RequestMapping(value="/v6_memberlist.do", method= RequestMethod.GET)
	public String v6memberlist(Model model) {
		List<V6_Member> list = mDAO.selectMemberList();
		
		
		model.addAttribute("list", list);
		
		return "v6_memberlist";
	}
	
	@RequestMapping(value="/v6_memberupdate.do", method= RequestMethod.POST)
	public String v6memberupdate(@RequestParam("mem_id[]") String[] mem_id, @RequestParam("mem_pw[]") String[] mem_pw, @RequestParam("mem_name[]") String[] mem_name) {
		
		List<V6_Member> list = new ArrayList<V6_Member>();
		for(int i=0; i<mem_id.length; i++) {
			V6_Member vo = new V6_Member();
			vo.setMem_id(mem_id[i]);
			vo.setMem_pw(mem_pw[i]);
			vo.setMem_name(mem_name[i]);
			
			list.add(vo);
		}
		
		mDAO.updateMemberAll(list);
		
		return "redirect:v6_memberlist.do";
	}
	
	
	
	
	@RequestMapping(value="/v6_memberlist1.do", method= RequestMethod.GET)
	public String v6memberlist1(Model model) {
		List<V6_Member> list = mDAO.selectMemberList();
		
		V6_MemberList mlist = new V6_MemberList();
		mlist.setList(list);
		
		model.addAttribute("mlist", mlist);
		
		return "v6_memberlist1";
	}
	
	@RequestMapping(value="/v6_memberupdate1.do", method= RequestMethod.POST)
	public String v6memberupdate1(@ModelAttribute("mlist") V6_MemberList mlist) {
		
		List<V6_Member> list = mlist.getList();
		mDAO.updateMemberAll(list);
		
		return "redirect:v6_memberlist1.do";
	}
	
	
	
	@RequestMapping(value="/v6_memberdeletelist.do", method= RequestMethod.GET)
	public String v6memberdeletelist(Model model) {
		List<V6_Member> list = mDAO.selectMemberList();
		
		model.addAttribute("list", list);
		return "v6_memberdeletelist";
	}
	
	@RequestMapping(value="/v6_memberdeletelist.do", method= RequestMethod.POST)
	public String v6memberdeletelist(@RequestParam("chk[]") String[] ids) {
		
		//1. deleteMemberAll SQL수행
		//String[] -> List<String>
		//List<String> list = Arrays.asList(ids);
		//mDAO.deleteMemberAll(list);
		
		//2. deleteMemberProc 프로시저 호출
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_id", ids[0]);
		//프로시저 수행
		mDAO.deleteMemberProc(map);
		//결과값이 int_ret에 담김
		int ret = (Integer)map.get("in_ret");
		System.out.println(ret);
		return "redirect:v6_memberdeletelist.do";
	}
	
	@RequestMapping(value="/v6_membermain.do", method= RequestMethod.GET)
	public String v6MemberMain(Model model) {
		return "v6_membermain";
	}
	
	@RequestMapping(value="/v6_memberlogin.do", method= RequestMethod.GET)
	public String v6MemberLogin(Model model) {
		V6_Member vo = new V6_Member();
		
		model.addAttribute("vo", vo);
		return "v6_memberlogin";
	}
	
	@RequestMapping(value="/v6_memberlogin.do", method = RequestMethod.POST)
	public String v6MemberLogin(RedirectAttributes model, @ModelAttribute("vo") V6_Member vo) {
		V6_Member vo1 = mDAO.selectMemberLogin(vo);
		if(vo1 != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", vo1.getMem_id());
			map.put("name", vo1.getMem_name());
			model.addFlashAttribute("map", map);
			
			return "redirect:v6_membermain.do";
		}
		return "redirect:v6_memberlogin.do";
	}
	
	@RequestMapping(value="/v6_memberlogout.do", method = RequestMethod.GET)
	public String v6MemberLogout(Model model,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		//model.addAttribute("message","로그아웃 되었습니다.");
		//model.addAttribute("url","v6_membermain.do");
		return "redirect:v6_membermain.do";	
	}

}
