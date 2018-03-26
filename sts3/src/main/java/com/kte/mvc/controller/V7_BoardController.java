package com.kte.mvc.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.mvc.mapper1.V7_BoardDAO;
import com.kte.mvc.vo.V7_Board;
import com.kte.mvc.vo.V7_BoardCode;

@Controller
@MapperScan("com.kte.mvc.mapper1")
public class V7_BoardController {
	
	@Autowired
	private V7_BoardDAO bDAO = null;
	
	@RequestMapping(value="/v7_board.do", method=RequestMethod.GET)
	public String boardList(Model model, @RequestParam(value="code", defaultValue="0") int no) {
		
		if(no == 0) {
			return "redirect:v7_board.do?code=1";
		}
		
		List<V7_BoardCode> code = bDAO.selectBoardCode();
		
		model.addAttribute("code", code);
		return "v7/v7_board";
	}
	
	@RequestMapping(value="/v7_boardw.do", method=RequestMethod.GET)
	public String boardWrite(Model model, @RequestParam(value="code", defaultValue="1") int no) {
		V7_Board vo = new V7_Board();
		int max_no = bDAO.selectBoardMaxNo();

		vo.setBrd_no(max_no+1);
		vo.setBrd_cd_no(no);
		vo.setMem_id("a1");
		
		model.addAttribute("vo", vo);
		return "v7/v7_boardw";
	}
	
	@RequestMapping(value="/v7_boardw.do", method=RequestMethod.POST)
	public String boardWrite(@ModelAttribute("vo") V7_Board vo) {
		
		//bDAO.insertBoard(vo);
		return "redirect:board.do";
	}
}
