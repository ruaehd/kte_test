package com.kte.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.mvc.dao.V5_CurAppXMLDAO;
import com.kte.mvc.mapper1.V5_StudentDAO;
import com.kte.mvc.vo.V5_CourseApplication;
import com.kte.mvc.vo.V5_Department;
import com.kte.mvc.vo.V5_Student;
import com.kte.mvc.vo.V5_Subject;

@Controller

public class StudentController {
	
	@Autowired private V5_CurAppXMLDAO caDAO = null;
	@Autowired private V5_StudentDAO sDAO = null;
	
	@RequestMapping(value="/student_insert.do", method = RequestMethod.GET)
	public String studentInsert(Model model) {
		
		V5_Student vo = new V5_Student();
		model.addAttribute("vo", vo);
		
		return "student_insert";
	}
	
	@RequestMapping(value="/student_insert.do", method = RequestMethod.POST)
	public String studentInsert(@ModelAttribute("vo") V5_Student vo) {
		
		int n = sDAO.insertStudent(vo);
		vo.getStd_id();
		
		return "redirect:student_main.do";
	}
	
	
	
	@RequestMapping(value="/student_login.do", method = RequestMethod.GET)
	public String studentLogin(Model model) {
		
		V5_Student vo = new V5_Student();
		model.addAttribute("vo", vo);
		
		return "student_login";
	}
	
	@RequestMapping(value="/student_login.do", method = RequestMethod.POST)
	public String studentLogin(@ModelAttribute("vo") V5_Student vo, HttpSession httpsession) {
		
		V5_Student vo1 = sDAO.loginStudent(vo);
		
		if(vo1 == null) {
			return "redirect:student_login.do";
		}
		else {
			httpsession.setAttribute("std_id", vo.getStd_id());
			httpsession.setAttribute("std_name", vo.getStd_name());
			
			return "redirect:student_main.do";
		}
		
	}
	
	@RequestMapping(value="/student_logout.do", method = RequestMethod.GET)
	public String studentLogout(Model model, HttpSession httpsession) {
		
		httpsession.invalidate();
		
		return "redirect:student_main.do";
	}
	
	
	
	@RequestMapping(value="/student_main.do", method = RequestMethod.GET)
	public String studentMain(Model model) {
		return "student_main";
	}
	
	@RequestMapping(value="/student_list.do", method = RequestMethod.GET)
	public String studentList(Model model) {
		
		List<V5_Student> list = sDAO.selectStudentList();
		
		model.addAttribute("list", list);
		return "student_list";
	}
	
	@RequestMapping(value="/course_app.do", method = RequestMethod.GET)
	public String courseapp(Model model) {
		
		List<V5_Department> d_list = sDAO.selectDepartmentList();
		List<V5_Subject> s_list = sDAO.selectSubjectList();
		
		model.addAttribute("d_list", d_list);
		model.addAttribute("s_list", s_list);
		
		V5_CourseApplication vo = new V5_CourseApplication();
		vo.setCrs_code(sDAO.selectMaxCrscode()+1);
		model.addAttribute("vo", vo);
		return "courseapp";
	}
	
	@RequestMapping(value="/course_app.do", method=RequestMethod.POST)
	public String courseapp(@ModelAttribute("vo") V5_CourseApplication vo, HttpSession httpsession) {
		String id = (String) httpsession.getAttribute("std_id");
		vo.setStd_id(id);
		//caDAO.insertCurApp(vo);
		sDAO.insertCurApp(vo);
		
		return "redirect:course_applist.do";
	}
	
	@RequestMapping(value="/course_applist.do", method = RequestMethod.GET)
	public String courseapplist(Model model, HttpSession httpsession) {
		String id = (String) httpsession.getAttribute("std_id");
		List<V5_CourseApplication> list = caDAO.selectCurAppList(id);
		
		model.addAttribute("list", list);
		return "course_applist";
	}
	
	@RequestMapping(value="/course_appdel.do", method = RequestMethod.GET)
	public String courseappdel(@RequestParam("code") String code) {
		
		caDAO.delectCurApp(code);		

		return "redirect:course_applist.do";
	}
}
