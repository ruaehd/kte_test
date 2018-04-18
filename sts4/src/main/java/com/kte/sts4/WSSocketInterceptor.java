package com.kte.sts4;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class WSSocketInterceptor extends HttpSessionHandshakeInterceptor{

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		// TODO Auto-generated method stub
		super.afterHandshake(request, response, wsHandler, ex);
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2,
			Map<String, Object> arg3) throws Exception {
		// TODO Auto-generated method stub
		
		//ServerHttpRequest -> ServletServerHttpRequest -> HttpServletRequest -> session()에서 값 꺼냄
		
		ServletServerHttpRequest ssreq = (ServletServerHttpRequest) arg0;
		
		HttpServletRequest req =  ssreq.getServletRequest();
		
		arg3.put("_ID", req.getParameter("id"));
		
		return super.beforeHandshake(arg0, arg1, arg2, arg3);
	}
	
}
