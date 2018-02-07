package com.web.khl91;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.khl91.dao.V3_BoardDAO;
import com.web.khl91.vo.V3_BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private V3_BoardDAO bDAO = null;
	
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public String board(Model model) {
		V3_BoardVO vo = new V3_BoardVO();
		
		List<V3_BoardVO> list = bDAO.boardlist(vo);
		model.addAttribute("list", list);
		
		return "board";
	}
	
	
	@RequestMapping(value = "/boardwrite.do", method = RequestMethod.GET)
	public String boardwrite(Model model, HttpSession httpsession ) {
		//세션에서 이메일 값을 받아옴
		String email = (String)httpsession.getAttribute("_email");
		//이메일 값이 없다면 로그인이 되지 않은 상태
		if(email == null) {
			return "redirect:/login.do";
		}
		//로그인이 되어 있다면 글쓰기화면을 표시
		
		//1. 전달할 VO 생성
		V3_BoardVO vo = new V3_BoardVO();
		
		//2. 글번호를 DAO에서 가져옴
		int no = bDAO.selectLastNo();
		String name = (String)httpsession.getAttribute("_name");
		
		//3. 전달할 값을 넣음(글번호, 작성자)
		vo.setNo(no+1);
		vo.setWriter(name);
		
		//4. jsp로 V3_Board의 객체 vo를 전달함
		model.addAttribute("bvo", vo);
		
		return "boardwrite";
	}
	@RequestMapping(value = "/boardwrite.do", method = RequestMethod.POST)
	public String boardwrite(@ModelAttribute("bvo") V3_BoardVO vo) {

			//1. DAO로 vo를 전달하여 추가함
			int ret = bDAO.boardwrite(vo);
			
			//2. 추가가 되었다면
			if(ret>0) {
				return "redirect:/board.do";
			}
			//실패 했다면
			return "redirect:/boardwrite.do";
	
	}
	
	
		@RequestMapping(value = "/boardcontent.do", method = RequestMethod.GET)
	public String boardcontent(@RequestParam("no") int no,  Model model) {
		
		V3_BoardVO vo = bDAO.boardcontent(no);
		model.addAttribute("vo", vo);
		
		return "boardcontent";
	}
	
	
}
