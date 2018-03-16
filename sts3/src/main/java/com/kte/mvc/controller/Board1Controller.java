package com.kte.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.mvc.dao.V6_BoardDAO;
import com.kte.mvc.dao.V6_BoardReplyDAO;
import com.kte.mvc.vo.V6_Board;
import com.kte.mvc.vo.V6_BoardReply;

@Controller
public class Board1Controller {
	@Autowired
	private V6_BoardDAO bDAO = null;

	@Autowired
	private V6_BoardReplyDAO brDAO = null;

	@RequestMapping(value = "/v6_board.do", method = RequestMethod.GET)
	public String board(Model model) {
		List<V6_Board> list = bDAO.boardList();
		model.addAttribute("aaa", list);
		// jsp호출
		return "v6_board"; // views/폴더안의 v6_board.jsp
	}

	@RequestMapping(value = "/v6_boardw.do", method = RequestMethod.GET)
	public String boardw(HttpServletRequest request, Model model) {
		String prev_url = request.getHeader("referer");
		if (prev_url != null) {
			// http://127.0.0.1:8080/mvc/v6_board.do
			String[] tmp = prev_url.split("/");
			if (tmp[tmp.length - 1].equals("v6_board.do")) {
				// 회원가입, 글쓰기, 로그인...
				// 사용자가 입력한 값을 받아야 할 경우에 사용
				V6_Board vo = new V6_Board();

				// V6_BoardDAO클래스의 selectLastNo()
				int no = bDAO.selectLastNo();

				vo.setBrd_no(no + 1);
				model.addAttribute("vo", vo);
				return "v6_boardw";
			}
		}
		return "redirect:v6_board.do";
	}

	@RequestMapping(value = "/v6_boardw.do", method = RequestMethod.POST)
	public String boardw(@ModelAttribute("vo") V6_Board vo) {
		int ret = bDAO.insertBoard(vo);
		if (ret > 0) {
			return "redirect:v6_board.do";
		}
		return "redirect:v6_boardw.do";
	}

	@RequestMapping(value = "/v6_boardc.do", method = RequestMethod.POST)
	public String boardc(@RequestParam("brd_no") int brd_no) {
		// 조회수를 증가하기 위해 글번호를 넘김
		int ret = bDAO.updateBoardHit(brd_no);
		if (ret > 0) {
			// v6_boardc.do => GET
			return "redirect:v6_boardc.do?brd_no=" + brd_no;
		}
		// 실패시 게시판 목록으로
		return "redirect:v6_board.do";
	}

	@RequestMapping(value = "/v6_boardc.do", method = RequestMethod.GET)
	public String boardc(@RequestParam("brd_no") int brd_no, Model model) {
		// 글번호를 넘기면 해당 게시물 1개를 받음.
		V6_Board vo = bDAO.selectBoardOne(brd_no);

		// 이전글
		int brd_pno = bDAO.selectBoardPrev(brd_no);
		// 다음글
		int brd_nno = bDAO.selectBoardNext(brd_no);
		
		List<V6_BoardReply> brVO = brDAO.selectBoardReplyList(brd_no);
		model.addAttribute("brvo", brVO);

		
		// jsp로 전달함.
		model.addAttribute("vo", vo);
		model.addAttribute("pno", brd_pno);
		model.addAttribute("nno", brd_nno);
		

		return "v6_boardc";
	}

}
