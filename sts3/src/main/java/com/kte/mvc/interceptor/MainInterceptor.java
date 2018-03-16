package com.kte.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MainInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		//String root = request.getContextPath();
		String path = request.getServletPath();
		String query = request.getQueryString();
		
		HttpSession httpsession = request.getSession();
		if(query != null) {	//	/mvc/boardlist.do?page=1
			httpsession.setAttribute("back_url", path + "?" + query);
		}
		else {	//	/mvc/login.do
			httpsession.setAttribute("back_url",  path);
		}
		System.out.println("interceptor - " +  path);
		
		return super.preHandle(request, response, handler);
	}
	
}
