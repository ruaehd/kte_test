package com.kte.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kte.mvc.dao.MemberDAO;
import com.kte.mvc.vo.V3_MemberVO;

@Controller
public class MemberController {
	
	@Autowired						//DAO사용하기위해
	private MemberDAO mDAO = null;
	
	@RequestMapping(value="/memberlist.do", method=RequestMethod.GET)
	public String memberList(HttpServletRequest request, HttpServletResponse response) {

		List<V3_MemberVO> list = mDAO.selectMemberList();
		/*List<V3_MemberVO> list1 = mDAO.selectMemberList1();*/
		
		request.setAttribute("list", list);
/*		request.setAttribute("list1", list1);*/
		return "v1_memberlist";
	}
	@RequestMapping(value="/idcheck.do", method=RequestMethod.GET)
	//@ResponseBody는 추가하면 jsp파일이 표시되는 것이 아닌 리턴값 자체가 전달됨
	public @ResponseBody Boolean join(HttpServletRequest request) {		
		String id = request.getParameter("id");
		System.out.println(id);
		if(id.equals("test1")) {
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {		
		return "v1_login";
	}
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main() {		
		return "v1_main";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login1(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join(HttpServletRequest request, HttpServletResponse response) {
		return "v1_join";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join1(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String na = request.getParameter("name");
			String bi = request.getParameter("birth");
			String te = request.getParameter("tel");
			String ph = request.getParameter("phone");
			String po = request.getParameter("postcode");
			String ad = request.getParameter("addr");
			
			V3_MemberVO vo = new V3_MemberVO();
			vo.setNo(id);
			vo.setPw(pw);
			vo.setName(na);
			vo.setBirth(bi);
			vo.setTel(te);
			vo.setPhone(ph);
			vo.setPostcode(po);
			vo.setAddr(ad);
			
			mDAO.insertMember(vo);
			
			return "redirect:main.do";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:join.do";
		}
		
	}
	
	public String changeMember() {
		return null;
	}
	
	
}
