package com.kte.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kte.mvc.dao.V6_BoardReplyDAO;
import com.kte.mvc.dao.V6_ItemDAO;
import com.kte.mvc.vo.V6_BoardReply;
import com.kte.mvc.vo.V6_ItemB;
import com.kte.mvc.vo.V6_ItemC;

@RestController
public class AjaxController {

	@Autowired V6_BoardReplyDAO brDAO = null;;
	@Autowired V6_ItemDAO iDAO = null;
	
	@RequestMapping(value="/ajax_v6_board_reply.do", method= {RequestMethod.GET, RequestMethod.POST})
	public V6_BoardReply v6boardreply(@RequestParam("brd_no") int bn, @RequestParam("rep_content") String rc, @RequestParam("rep_writer") String rw) {
		System.out.println(bn);
		System.out.println(rc);
		System.out.println(rw);
		
		V6_BoardReply vo = new V6_BoardReply();
		vo.setRep_content(rc);
		vo.setBrd_no(bn);
		vo.setRep_writer(rw);
		
		brDAO.insertBoardReply(vo);
		
		V6_BoardReply vo1 = brDAO.selectBoardReply(vo.getRep_no());
		
		return vo1;
	}
	
	@RequestMapping(value="/ajax_v6_item_b.do", method= {RequestMethod.GET ,RequestMethod.POST})
	public List<V6_ItemB> v6Itemb(@RequestParam("itema_code") int code){
		List<V6_ItemB> list = iDAO.selectItemBList(code);
		return list;
	}
	
	@RequestMapping(value="/ajax_v6_item_c.do", method= {RequestMethod.GET ,RequestMethod.POST})
	public List<V6_ItemC> v6Itemc(@RequestParam("itemb_code") int code){
		List<V6_ItemC> list = iDAO.selectItemCList(code);
		return list;
	}
}
