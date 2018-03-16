package com.kte.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kte.mvc.dao.V3_BoardXMLDAO;
import com.kte.mvc.mapper1.V3_BoardDAO;
import com.kte.mvc.vo.V3_Board;

@Controller
@MapperScan("com.kte.mvc.mapper1")	//DAO interface위치
public class BoardController {
		
	//DAO의 객체 생성
	//interface를 사용한 방법
	@Autowired
	private V3_BoardDAO bDAO = null;
	//기존방법
	@Autowired
	private V3_BoardXMLDAO bxDAO = null;
	
	@RequestMapping(value="/board.do", method = RequestMethod.GET)
	public String board(Model model) {
		
		List<V3_Board> list = bxDAO.selectBoardList();
		model.addAttribute("list", list);
		
		return "board";
	}
	
	/*
	 * 주소로 바로 접속하는것 막기
	 */
	@RequestMapping(value="/boardw.do", method = RequestMethod.GET)
	public String boardw(HttpServletRequest request) {
		String prev_url = request.getHeader("referer");
		if(prev_url != null) {
			String[] tmp = prev_url.split("/");
			if(tmp[tmp.length-1].equals("board.do")) {
				return "boardw";
			}
		}
		return "redirect:board.do";
	}

}
