package com.kte.sts4.v9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.sts4.dao.BoardDAOImpl;
import com.kte.sts4.vo.V9_Board;

@Controller
public class V9_BoardController {
	
	@Autowired BoardDAOImpl brDAO = null; 
	
	@RequestMapping(value="/v9_board.do", method = RequestMethod.GET)
	public String board(Model model) {
		
		List<V9_Board> list = brDAO.selectBoardList();
		
		model.addAttribute("list", list);
		return "v9/board";
	}
	
	@RequestMapping(value="/v9_boardwrite.do", method = RequestMethod.GET)
	public String boardWrite(Model model, HttpSession httpSession) {
		
		if(httpSession.getAttribute("_id")!=null) {
			V9_Board vo = new V9_Board();
			String id = (String)httpSession.getAttribute("_id");
			vo.setWriter(id);
			
			model.addAttribute("vo", vo);
			return "v9/boardwrite";
		}
		else {
			return "redirect:v9_customerlogin.do";
		}
		
	}
	
	@RequestMapping(value="/v9_boardwrite.do", method = RequestMethod.POST)
	public String boardWrite(@ModelAttribute("vo") V9_Board vo) {
		
		try {
			System.out.println("Controller : "+vo.toString());
			brDAO.insertBoard(vo);
			System.out.println("MAX NO :" +vo.getNo());
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:v9_board.do";
	}
	
	@RequestMapping(value="/v9_boardcontent.do", method = RequestMethod.GET)
	public String boardContent(Model model, @RequestParam("no") int no, HttpServletRequest request) {
		if(request.getHeader("REFERER") != null) {
			model.addAttribute("vo", brDAO.selectBoardOne(no));
			
			Map <String, Object> map = new HashMap<String, Object>();
			map.put("no", no);
			
			model.addAttribute("prev", brDAO.selectBoardPrev(map));
			model.addAttribute("next", brDAO.selectBoardNext(map));
			
			return "v9/boardcontent";
		}
		else {
			return "redirect:v9_board.do";
		}
	}
	
	
}
