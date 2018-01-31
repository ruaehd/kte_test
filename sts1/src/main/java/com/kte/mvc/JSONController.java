package com.kte.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kte.mvc.dao.MemberDAO;
import com.kte.mvc.vo.Member;
import com.kte.mvc.vo.V3_MemberVO;

@RestController
public class JSONController {
	
	@Autowired						//DAO사용하기위해
	private MemberDAO mDAO = null;
	
	@RequestMapping(value="/json_idcheck.do", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Member json_idcheck() {
		
		Member vo = new Member();
		vo.setId("aaa");
		vo.setPw("bbb");
		vo.setName("ccc");
		
		return vo;
	}
	
	@RequestMapping(value="/json_memberblock.do", produces="application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Map<String,String> json_memberblock(HttpServletRequest request, HttpServletResponse response) {
		
			String id = request.getParameter("id");
			String chk = request.getParameter("chk");

			V3_MemberVO vo = new V3_MemberVO();
			vo.setNo(id);
			vo.setChk(Integer.parseInt(chk));
			
			mDAO.updateMemberChk(vo);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("ret", "y");
			
			return map;
		
	}
}
