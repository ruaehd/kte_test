package com.kte.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kte.mvc.mapper1.V7_MemberDAO;
import com.kte.mvc.vo.V7_Member;

@RestController
@MapperScan("com.kte.mvc.mapper1")
public class V7_AjaxController {
	
	@Autowired 
	private V7_MemberDAO mDAO = null;
	
	
	@RequestMapping(value="v7_ajax_idcheck.do", method= {RequestMethod.GET, RequestMethod.POST})
	public Map<String, String> idCheck(HttpServletResponse response, @RequestParam("mem_id") String id) {
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		Map<String, String> map = new HashMap<String, String>();
		int ret = mDAO.memberIDCheck(id);
		map.put("ret", "y");
		if(ret>0) {
			map.put("ret", "n");
		}
		return map;
	}
	
	
	@RequestMapping(value="v7_ajax_memberjoin.do", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Map<String, String> memberJoin(
			HttpServletResponse response,
			@RequestParam("mem_id") String mem_id,
			@RequestParam("mem_pw") String mem_pw,
			@RequestParam("mem_name") String mem_name,
			@RequestParam("mem_tel") String mem_tel,
			@RequestParam(value="mem_email", defaultValue="") String mem_email) {
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		V7_Member vo = new V7_Member();
		vo.setMem_id(mem_id);
		vo.setMem_pw(mem_pw);
		vo.setMem_name(mem_name);
		vo.setMem_tel(mem_tel);
		vo.setMem_email(mem_email);
		
		int ret = mDAO.memberJoin(vo);
		Map<String, String> map = new HashMap<String, String>();
		map.put("ret", "n");
		if(ret>0) {
			map.put("ret", "y");
		}
		return map;
	}
}
