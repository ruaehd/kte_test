package com.kte.mvc.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kte.mvc.func.Function;
import com.kte.mvc.mapper1.V7_BoardDAO;
import com.kte.mvc.mapper1.V7_MemberDAO;
import com.kte.mvc.vo.V7_Board;
import com.kte.mvc.vo.V7_BoardImg;
import com.kte.mvc.vo.V7_Member;

@RestController
@MapperScan("com.kte.mvc.mapper1")
public class V7_AjaxController {
	
	@Autowired 
	private V7_MemberDAO mDAO = null;
	@Autowired
	private V7_BoardDAO bDAO = null;
	
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
			@RequestParam(value="mem_email", defaultValue="") String mem_email) throws Exception {
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		V7_Member vo = new V7_Member();
		vo.setMem_id(mem_id);
		vo.setMem_pw(Function.getEncSHA256(mem_pw));
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
	
	@RequestMapping(value="v7_ajax_memberlogin.do", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody V7_Member memberLogin(
			HttpServletResponse response, 
			@RequestParam("key") String key,
			@RequestParam("mem_id") String mem_id, 
			@RequestParam("mem_pw") String mem_pw) throws Exception{
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		if(key.equals("key")) {
			V7_Member vo = new V7_Member();
			vo.setMem_id(mem_id);
			vo.setMem_pw(Function.getEncSHA256(mem_pw));
			return mDAO.memberLogin(vo);
		}
		return null;
	}
	
	@RequestMapping(value="/ajax_selectImg.do", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody ResponseEntity<byte[]> selectImg(@RequestParam("no") int no, @RequestParam("idx") int idx, HttpServletRequest request, HttpServletResponse response){
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		V7_BoardImg vo = bDAO.selectBoardImg(no);
		byte[] imgData = null;
		
		if(idx==1) imgData = vo.getBrd_img_1();
		if(idx==2) imgData = vo.getBrd_img_2();
		if(idx==3) imgData = vo.getBrd_img_3();
		
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			
			if(imgData == null ) {
				InputStream in = request.getSession().getServletContext().getResourceAsStream("/resources/imgs/default.png");
				imgData = IOUtils.toByteArray(in);
			}
			
			return new ResponseEntity<byte[]>(imgData, headers, HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(value="/ajax_v7_board.do", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody List<V7_Board> boardList(@RequestParam(value="code", defaultValue="1") int code, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//{"ret":"y"} map
		//{"mem_id:"zbc", "mem_pw":"bbb"} vo
		//[{},{},{}] List
		return bDAO.selectBoardList(code);
	}
}
