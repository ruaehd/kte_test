package com.kte.mvc.controller;

import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kte.mvc.func.Function;
import com.kte.mvc.mapper1.V7_MemberDAO;
import com.kte.mvc.vo.V7_Member;

@Controller
@SessionAttributes({"vo"})
@MapperScan("com.kte.mvc.mapper1")
public class V7_MemberController {
	@Autowired 
	private V7_MemberDAO mDAO = null;
	
	@ModelAttribute("vo")
	public V7_Member getV7_Member() {
		return new V7_Member();
	}
	
	@RequestMapping(value="v7_memberauth.do", method=RequestMethod.GET)
	public String memberAuth(@ModelAttribute("vo") V7_Member vo, Model model) {
		if(vo!= null) {
			model.addAttribute("vo", vo);
			return "v7/v7_memberauth";
		}
		else {
			return "redirect:v7_memberlogin.do";
		}
	}
	
	@RequestMapping(value="v7_memberauth.do", method=RequestMethod.POST)
	public String memberAuth(@ModelAttribute("vo") V7_Member vo, HttpSession httpsession) throws Exception {
		
		System.out.println(vo.getMem_id());
		System.out.println(vo.getMem_pw());
		
		vo.setMem_pw(Function.getEncSHA256(vo.getMem_pw()));
		V7_Member r_vo = mDAO.memberLogin(vo);
		if(r_vo != null) {
			vo.setMem_auth(true);
			//이전페이지로 이동
			String b_url = (String) httpsession.getAttribute("back_url");
			return "redirect:" + b_url;
		}
		return "redirect:v7_memberauth.do";
	}
	
	@RequestMapping(value="v7_memberedit.do", method=RequestMethod.GET)
	public String memberEdit(@ModelAttribute("vo") V7_Member vo, Model model) {
		
		if(vo != null) {
			if(vo.isMem_auth() == false ) {
				return "redirect:v7_memberauth.do";
			}
			V7_Member vo1 = mDAO.selectMemberOne(vo);
			model.addAttribute("obj", vo1);
			return "v7/v7_memberedit";
		}
		else {
			return "redirect:v7_memberlogin.do";
		}
	}
	
	@RequestMapping(value="v7_memberedit.do", method=RequestMethod.POST)
	public String memberEdit(@ModelAttribute("obj") V7_Member vo) {
		
		int ret = mDAO.updateMemberOne(vo);
		if(ret > 0) {
			return "redirect:v7_main.do";
		}
		return "redirect:v7_memberedit.do";
	}
	
	@RequestMapping(value="v7_memberlogout.do", method=RequestMethod.GET)
	public String memberLogOut(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:v7_main.do";
	}
	
	@RequestMapping(value="v7_memberlogin.do", method=RequestMethod.GET)
	public String memberLogin(Model model) {
		
		V7_Member vo = new V7_Member();
		model.addAttribute("vo", vo);
		return"v7/v7_memberlogin";
	}
	
	@RequestMapping(value="/v7_memberlogin.do", method = RequestMethod.POST)
	public String memberLogin(@ModelAttribute("vo")V7_Member vo,RedirectAttributes model) {
		try {
			vo.setMem_pw( getEncSHA256(vo.getMem_pw()) );
			V7_Member r_vo = mDAO.memberLogin(vo);
			if(r_vo != null) { //로그인 성공
				model.addFlashAttribute("vo", r_vo);
				return "redirect:v7_main.do";
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:v7_memberlogin.do";
	}

	@RequestMapping(value="v7_main.do", method=RequestMethod.GET)
	public String main(@ModelAttribute("vo") V7_Member vo) {
		System.out.println(vo.getMem_id());
		return "v7/v7_main";
	}
	
	@RequestMapping(value="v7_memberjoin.do", method=RequestMethod.GET)
	public String memberJoin(Model model) {
		V7_Member vo = new V7_Member();
		
		//개발용
		vo.setMem_id("a1");
		vo.setMem_pw("a1");
		vo.setMem_name("홍길동");
		vo.setMem_tel("010-0000-0000");
		vo.setMem_email("a@a.com");

		model.addAttribute("obj", vo);
		return "v7/v7_memberjoin";
	}
	
	@RequestMapping(value="v7_memberjoin.do", method=RequestMethod.POST)
	public String memberJoin(@ModelAttribute("obj") V7_Member vo) {
		
		try {
			String tmp_pw = getEncSHA256(vo.getMem_pw());
			vo.setMem_pw(tmp_pw);
			mDAO.memberJoin(vo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:v7_memberjoin.do";
	}
	
	private String getEncSHA256(String txt) throws Exception{
	    StringBuffer sbuf = new StringBuffer();
	     
	    MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
	    mDigest.update(txt.getBytes());
	     
	    byte[] msgStr = mDigest.digest() ;
	     
	    for(int i=0; i < msgStr.length; i++){
	        byte tmpStrByte = msgStr[i];
	        String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);
	        sbuf.append(tmpEncTxt) ;
	    }
	    
	    String tmp = sbuf.toString();
	    System.out.println("A - "+tmp);
	    tmp = tmp.charAt(tmp.length()-1) + tmp.substring(0, tmp.length()-1);
	    tmp = tmp.charAt(tmp.length()-1) + tmp.substring(0, tmp.length()-1);
	    tmp = tmp.charAt(tmp.length()-1) + tmp.substring(0, tmp.length()-1);
	    System.out.println("B - "+tmp);
	    return sbuf.toString();
	}

}
