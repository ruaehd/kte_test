package com.web.khl91.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MainInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션 객체 얻기
		HttpSession httpsession = request.getSession();
		
		//현재 주소창에 표시된 주소 얻기
		//주소 예제 login.do board.do?page=1
		String path = request.getServletPath();
		String query = request.getQueryString();
		
		//query가 존재하지 않는 주소라면
		if(query == null) {
			//path
			httpsession.setAttribute("_url",  path);
		}
		else {
			//path+"?"+query
			httpsession.setAttribute("_url",  path+"?"+query);
		}
		
		// TODO Auto-generated method stub
		
		System.out.println(path);
		
		// true면 controller이 실행
		return true;
	}
	

}
