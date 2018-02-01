package com.kte.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kte.mvc.dao.MemberDAO;
import com.kte.mvc.vo.Member;
import com.kte.mvc.vo.V3_MemberVO;

@RestController
public class JSONController {
	
	@Autowired						//DAO사용하기위해
	private MemberDAO mDAO = null;
	
	@RequestMapping(value="json_login.do",produces="application/json",
			method= {RequestMethod.GET, RequestMethod.POST})
				public Map<String, Object> jsonLogin(HttpServletResponse response, 
			@RequestParam(value="key", defaultValue="") String key,
						@RequestParam(value="id", defaultValue="") String id,
						@RequestParam(value="pw", defaultValue="") String pw) {
					response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
					response.setHeader("Access-Control-Max-Age", "3600");
					response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
					response.setHeader("Access-Control-Allow-Origin", "*");
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("ret", "잘못된 접근입니다.");
					if(key.equals("123")) {
						V3_MemberVO vo = new V3_MemberVO();
						vo.setNo(id);
						vo.setPw(pw);
						
						int ret = mDAO.selectMemberLogin(vo);
						map.put("ret", "n");
						if(ret > 0) {
							map.put("ret", "y");
						}
					}
					return map;
				}

	
	//1. 1개의 값 => 아이디 중복확인, 전체 게시물수
	//{"ret":"yes"}  or {"ret":"no"}
	//{"ret":1} or {"ret":0}
	//{"ret":true} or {"ret":false}
	@RequestMapping(value="/json_exam1.do",produces="application/json", method= {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> jsonExam1(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="key",defaultValue="") String key){

		//cors 접근 문제	
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");


		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", "잘못된 접근입니다.");
		if(key.equals("123")) {
			//String =>문자
			//Integer => 숫자
			//Boolean => 참 or 거짓
			map.put("ret", "y");
			//map.put("ret", "n");
		}
		return map;
	}
	
	/*
	//JSP에서 jquery에서 사용시
	$.get('json_exam1.do?key=123',function(data){
		
	}, 'json');
	*/


	//2. 한줄=> 회원1명, 게시물 1개
	//{"ret" : { , , } }
	@RequestMapping(value="/json_exam2.do", produces="application/json", method= {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> jsonExam2(@RequestParam(value="key",defaultValue="") String key){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", "잘못된 접근입니다.");
		
		if(key.equals("123")) {
			V3_MemberVO vo = new V3_MemberVO();
			vo.setNo("aaa");
			vo.setName("홍길동");
			vo.setPhone("010-0000-0000");
			//??
			map.put("ret", vo);
		}
		return map;
	}
	

	//3. 여러줄 => 회원목록, 게시물 10개
	//[{"no":"a", "name":"b", "age":13},
	// {"no":"a", "name":"b", "age":13},
	// {"no":"a", "name":"b", "age":13}]
	// {"ret" : [{,,},{,,},{,,}]}
	@RequestMapping(value="/json_exam3.do",produces="application/json", method= {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> jsonExam3(@RequestParam(value="key", defaultValue="") String key){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", "잘못된 접근입니다.");
		if(key.equals("123")) {
			List<V3_MemberVO> list = new ArrayList<V3_MemberVO>();
			for(int i=0;i<3;i++) {
				V3_MemberVO vo = new V3_MemberVO();
				vo.setNo("aaa");
				vo.setName("홍길동");
				vo.setPhone("010-0000-0000");
				list.add(vo);
			}
			map.put("ret", list);
		}
		return map;
	}

	
	@RequestMapping(value="/json_idcheck.do", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Member json_idcheck() {
		
		Member vo = new Member();
		vo.setId("aaa");
		vo.setPw("bbb");
		vo.setName("ccc");
		
		return vo;
	}
	
	
}
