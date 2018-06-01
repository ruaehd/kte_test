package com.kte.mvc.wssocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WSSocketServer extends TextWebSocketHandler {

	private List<WebSocketSession> list = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		list.remove(session);
		System.out.println(session.getId() + "님 퇴장");
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		list.add(session);
		System.out.println(session.getId() + "님 입장");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		// 전달된 메세지 TextMessage클래스를 String으로 변경
		String payloadMessage = message.getPayload();
		System.out.println("서버 - " + payloadMessage);
		// list에 담겨져 있는 회원수 만큼 반복
		for (WebSocketSession client : list) {
			// 전달할 메세지를 만듬
			TextMessage msg = new TextMessage("ECHO : " + payloadMessage);
			// 클라이언트가 연결된 상태이면
			if (client.isOpen()) {
				// 메세지를 전송함.
				client.sendMessage(msg);
			}
		}
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		String payloadMessage = message.getPayload().toString();
		System.out.println("서버1 - " + payloadMessage);
	}

}
