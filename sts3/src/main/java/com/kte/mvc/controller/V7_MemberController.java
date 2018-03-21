package com.kte.mvc.controller;

import java.security.MessageDigest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kte.mvc.mapper1.V7_MemberDAO;
import com.kte.mvc.vo.V7_Member;

@Controller
@MapperScan("com.kte.mvc.mapper1")
public class V7_MemberController {
	@Autowired 
	private V7_MemberDAO mDAO = null;
	
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
