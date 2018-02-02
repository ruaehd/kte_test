package com.kte.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kte.mvc.dao.MemberDAO;
import com.kte.mvc.vo.V3_FormVO;
import com.kte.mvc.vo.V3_MemberVO;

@Controller
public class Member1Controller {
	
	@Autowired						//DAO사용하기위해
	private MemberDAO mDAO = null;
	
	@RequestMapping(value="/v1_join.do", method= {RequestMethod.GET})
	//Model model == HttpServletRequest request
	public String join(Model model) {
		V3_MemberVO vo = new V3_MemberVO();
		//vo.setNo("aaa"); 수정할때 미리 넣어주기
		//model.addAttribute() == request.setAttribute()
		model.addAttribute("mvo", vo);
	
		return "v1_join"; //표시
	}

	@RequestMapping(value="/v1_join.do", method= {RequestMethod.POST})
	//Model model == HttpServletRequest request
	public String join(@ModelAttribute("mvo") V3_MemberVO vo) {
		System.out.println(vo.getNo());
		System.out.println(vo.getPw());
		
		mDAO.insertMember(vo);
		return "redirect:v1_join.do";
	}
	
	@RequestMapping(value="/v1_select.do",method= {RequestMethod.GET})
	public String select(Model model) {
		//jsp에서 돌려 받기 위한 vo
		V3_FormVO vo = new V3_FormVO();
		vo.setSelect("c");
		
		List<String> list1 = new ArrayList<String>();
		list1.add("c");
		list1.add("android");
		vo.setSelectmulti(list1);
		model.addAttribute("mvo", vo);
		
		//select의 option항목에 추가될 내용
		List<String> list = new ArrayList<String>();
		list.add("java");	
		list.add("c");
		list.add("android");
		list.add("nodejs");
		model.addAttribute("list", list);
		
		return "v1_select";
	}
	
	@RequestMapping(value="/v1_select.do",method= {RequestMethod.POST})
	public String select(@ModelAttribute("mvo") V3_FormVO vo) {
		//1개
		System.out.println(vo.getSelect());
		
		//여러개
		for(String tmp : vo.getSelectmulti()) {
			System.out.println(tmp);
		}
		
		return "redirect:v1_select.do";
	}

	
	@RequestMapping(value="/v1_edit.do", method=RequestMethod.GET)
	public String edit(Model model) {
		V3_MemberVO vo = mDAO.selectMemberOne("khlee");
		model.addAttribute("mvo", vo);
		
		return "v1_edit";
	}
	
	@RequestMapping(value="/v1_checkbox.do", method=RequestMethod.GET)
	public String checkbox(Model model) {
		V3_FormVO vo = new V3_FormVO();
		model.addAttribute("mvo", vo);
		
		String[] list = {"java", "c", "android", "nodejs"};
		model.addAttribute("list", list);
		
		return "v1_checkbox";
	}
	
	@RequestMapping(value="/v1_checkbox.do",method= {RequestMethod.POST})
	public String checkbox(@ModelAttribute("mvo") V3_FormVO vo) {
		//1개
		System.out.println(vo.getCheckboxmulti());
		
		//여러개
		for(String tmp : vo.getCheckboxmulti()){
			System.out.println(tmp);
		}
		
		return "redirect:v1_checkbox.do";
	}
	
	@RequestMapping(value="/v1_radiobutton.do", method=RequestMethod.GET)
	public String radiobutton(Model model) {
		V3_FormVO vo = new V3_FormVO();
		model.addAttribute("mvo", vo);
		
		String[] list = {"java", "c", "android", "nodejs"};
		model.addAttribute("list", list);
		
		return "v1_radiobutton";
	}
	
	@RequestMapping(value="/v1_radiobutton.do",method= {RequestMethod.POST})
	public String radiobutton(@ModelAttribute("mvo") V3_FormVO vo) {
		//1개
		System.out.println(vo.getRadio());
		
		//라디오는 여러개 안씀
		return "redirect:v1_radiobutton.do";
	}
}
