package com.kte.mvc.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kte.mvc.mapper1.V7_BoardDAO;
import com.kte.mvc.vo.V7_Board;
import com.kte.mvc.vo.V7_BoardCode;
import com.kte.mvc.vo.V7_BoardImg;
import com.kte.mvc.vo.V7_Reply;

@Controller
@MapperScan("com.kte.mvc.mapper1")
public class V7_BoardController {
	
	@Autowired
	private V7_BoardDAO bDAO = null;
	
	@RequestMapping(value="/v7_board.do", method=RequestMethod.GET)
	public String boardList(Model model, 
			@RequestParam(value="code", defaultValue="0") int no, 
			@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="type", defaultValue="brd_title") String type,
			@RequestParam(value="text", defaultValue="") String text) {
		
		if(no == 0) {
			return "redirect:v7_board.do?code=1";
		}
		
		List<V7_BoardCode> code = bDAO.selectBoardCode();
		//List<V7_Board> list = bDAO.selectBoardList(no);
		//List<V7_Board> list = bDAO.selectBoardList1(no, (page-1)*10+1);
		
		//int totPage = bDAO.selectBoardTotPage2(no);
		int totPage = bDAO.selectBoardTotPage2(no, type, text);
		
		List<V7_Board> list = bDAO.selectBoardList2(no, (page-1)*10+1, type, text);
		
		model.addAttribute("totPage", (totPage-1)/10+1);
		
		model.addAttribute("list", list);
		model.addAttribute("code", code);
		return "v7/v7_board";
	}
		
	@RequestMapping(value="/v7_boardw.do", method=RequestMethod.GET)
	public String boardWrite(Model model, @RequestParam(value="code", defaultValue="1") int no) {
		V7_Board vo = new V7_Board();
		int max_no = bDAO.selectBoardMaxNo();
		
		vo.setBrd_no(max_no+1);
		//vo.setBrd_cd_no(no);
		vo.setMem_id("a1");
		
		model.addAttribute("vo", vo);
		return "v7/v7_boardw";
	}
	
	@RequestMapping(value="/v7_boardw.do", method=RequestMethod.POST)
	public String boardWrite(@RequestParam("code") int code, @ModelAttribute("vo") V7_Board vo) {
		return "redirect:v7_boardw.do";
	}
	
	/*@RequestMapping(value="/v7_boardw.do", method=RequestMethod.POST)
	public String boardWrite(@RequestParam("code") int code, @ModelAttribute("vo") V7_Board vo, MultipartHttpServletRequest request) {
		
		try {
			Map<String, MultipartFile> map = request.getFileMap();
			V7_BoardImg imgVO = new V7_BoardImg();
			imgVO.setBrd_no(vo.getBrd_no());
			
			for(int i=0; i<map.size(); i++) {
				MultipartFile tfile = map.get("img"+(i+1));
				if(tfile != null && !tfile.getOriginalFilename().equals("")) {
					if(i==0) {
						imgVO.setBrd_img_1(tfile.getBytes());
					}
					if(i==1) {
						imgVO.setBrd_img_2(tfile.getBytes());
					}
					if(i==2) {
						imgVO.setBrd_img_3(tfile.getBytes());
					}
				}
			}
			vo.setBrd_cd_no(code);
			bDAO.insertBoard(vo, imgVO);
			return "redirect:v7_board.do?code="+code;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:v7_boardw.do?code="+code;
		}
	}*/
	
	@RequestMapping(value="/selectImg.do", method=RequestMethod.GET)
	public ResponseEntity<byte[]> selectImg(@RequestParam("no") int no, @RequestParam("idx") int idx, HttpServletRequest request){
		
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
	
	@RequestMapping(value="/v7_boardc.do", method=RequestMethod.GET)
	public String boardContent(Model model, @RequestParam(value="no", defaultValue="0") int no, @RequestParam(value="code", defaultValue="0") int cd) {
		if(cd <= 0){
			return "redirect:v7_board.do?code=1";
		}
		if(no <= 0) {
			return "redirect:v7_board.do?code="+cd;
		}
		
		V7_Board vo = bDAO.selectBoardOne(no);
		model.addAttribute("vo", vo);
		
		return "v7/v7_boardc";
	}
	
	@RequestMapping(value="/v7_boardreply.do", method=RequestMethod.POST)
	public String boardReply(@RequestParam("brd_no") int no, @RequestParam("content") String content, @RequestParam("code") int code) {
		V7_Reply vo = new V7_Reply();
		vo.setBrd_no(no);
		vo.setRep_content(content);
		
		bDAO.insertBoardReply(vo);
		
		return "redirect:v7_boardc.do?brd_no="+no+"&code="+code;
	}
}
