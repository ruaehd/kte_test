package com.web.khl91;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.khl91.dao.V3_BoardDAO;
import com.web.khl91.vo.V3_BoardVO;
import com.web.khl91.vo.V3_Board_ImgVO;

@Controller
public class BoardController {
	
	@Autowired
	private V3_BoardDAO bDAO = null;
	
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public String board(@RequestParam(value="page", defaultValue="1") int page, Model model) {
		//page=1 1,10	page=2 11,20	page=3 21,30
		System.out.println(page);
		List<V3_BoardVO> list = bDAO.boardlist((page*10)-9);
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
	public String boardwrite(@ModelAttribute("bvo") V3_BoardVO vo, MultipartHttpServletRequest request) throws IOException {
		
		try {
			//1. DAO로 vo를 전달하여 추가함
			int ret = bDAO.boardwrite(vo);
			//2. 추가가 되었다면
			if(ret>0) {
				//파일첨부
				Map<String, MultipartFile> map = request.getFileMap();
				for(int i=0; i<map.size(); i++) {
					MultipartFile one = map.get("file_"+i);
					if(one.getBytes().length>0) {
						V3_Board_ImgVO vo1 = new V3_Board_ImgVO();
						vo1.setFilename(one.getOriginalFilename());	//파일명
						vo1.setFiledata(one.getBytes());	//파일데이터	에러발생가능성이 높기에 처리 필요
						vo1.setBoard_no(vo.getNo());	//게시판 글번호
						bDAO.insertBoardImg(vo1);
					}
				}
				return "redirect:/board.do";
			}
			
			

			//실패 했다면
			return "redirect:/boardwrite.do";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	
	}
	
	
		@RequestMapping(value = "/boardcontent.do", method = RequestMethod.GET)
	public String boardcontent(@RequestParam("no") int no,  Model model) {
		
		V3_BoardVO vo = bDAO.boardcontent(no);
		model.addAttribute("vo", vo);
		
		return "boardcontent";
	}
	
	
}
