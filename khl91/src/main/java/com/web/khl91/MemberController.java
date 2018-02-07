package com.web.khl91;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.khl91.dao.V3_MemberDAO;
import com.web.khl91.vo.V3_MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private RedisTemplate<String, String> strTemplate = null;
	
	@Autowired
	private RedisTemplate<String, Object> objTemplate = null;
	
	@Autowired
	private V3_MemberDAO mDAO = null;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession httpsession) {
		
		
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		V3_MemberVO vo = new V3_MemberVO(); 
		vo.setEmail(email);
		vo.setPw(pw);
		
		//1. DAO의 login 메소드 호출
		//2. DAO는 xml의 login을 호출함
		//3. login안에 포함된 SQL문을 수행함
		V3_MemberVO vo1 = mDAO.login(vo);
		if(vo1 != null) {
			
			//redis서버에 값을 넣음
			
			/*strTemplate.opsForValue().set(vo1.getEmail(), vo1.getName());*/
			
			objTemplate.opsForValue().set(vo1.getEmail(), vo1);
			
			//외부(다른서버)에서 세션처럼
			V3_MemberVO vo2 = (V3_MemberVO)objTemplate.opsForValue().get(vo1.getEmail());
			System.out.println(vo2.getPhone());
			/*redis서버에서 값을 가져옴
			strTemplate.opsForValue().get(arg0);*/
			
			/*String tmp = strTemplate.opsForValue().get(vo1.getEmail());
			System.out.println(tmp);*/
			
			//시스템 내부에서 사용할 세션
			httpsession.setAttribute("_email", vo1.getEmail());
			httpsession.setAttribute("_name", vo1.getName());
			
			//세션에서 되돌아갈 url주소를 얻음
			String url = (String) httpsession.getAttribute("_url");
			
			return "redirect:"+url;	
		}
		else {
			request.setAttribute("msg", "이메일/암호가 틀립니다");
			request.setAttribute("url", "login.do");
			return "alert";	
		}
	}
	
	
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(HttpServletRequest request) {
		try {
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			V3_MemberVO vo = new V3_MemberVO(); 
			vo.setEmail(email);
			vo.setPw(pw);
			vo.setName(name);
			vo.setPhone(phone);
			
			mDAO.join(vo);
			return "redirect:/";	//home화면
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/join.do";
		}
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession httpsession) {
		//세션 만료 시키고 다시생성 - 세션에 저장했던 값이 다 지워짐
		
		//(내부에서는) 세션에 저장된 정보 사용
		String em = (String)httpsession.getAttribute("_email");
		
		objTemplate.opsForValue().set(em, null);
		
		httpsession.invalidate();
		
		return "redirect:/";
	}
}
