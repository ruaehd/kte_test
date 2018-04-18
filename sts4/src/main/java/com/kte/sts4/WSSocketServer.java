package com.kte.sts4;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kte.sts4.dao.ChatDAO;
import com.kte.sts4.vo.Chat;
import com.kte.sts4.vo.Member;


public class WSSocketServer extends TextWebSocketHandler{

	@Autowired private MongoTemplate mongoTemplate = null;
	
	@Autowired private ChatDAO chatDAO = null;
	
	private List<WebSocketSession> list = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		list.remove(session);
		
		Map<String, Object> arg3 = session.getAttributes();
		String id = (String)arg3.get("_ID");
		Member vo = new Member();
		vo.setId(id);
		chatDAO.deleteMember(vo);
		
		//json문서 생성
		JSONObject jobj = new JSONObject();
		jobj.put("id", "server");
		jobj.put("cd", 2);
		jobj.put("msg", "disconnect");

		//json문서를 TextMessage 클래스 객체로 변경
		TextMessage msg = new TextMessage(jobj.toString());
		
		//현재 접속된 모든 사용자에게 메세지 보냄
		for (WebSocketSession client : list) {
			if (client.isOpen()) {
				// 메세지를 전송함.
				client.sendMessage(msg);
			}
		}
		
		
		System.out.println(session.getId() + "님 퇴장");
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		Map<String, Object> arg3 = session.getAttributes();
		String id = (String)arg3.get("_ID");
		Member vo = new Member();
		vo.setId(id);
		chatDAO.insertMember(vo);
		
		//json문서 생성
		JSONObject jobj = new JSONObject();
		jobj.put("id", "server");
		jobj.put("cd", 1);
		jobj.put("msg", "connect");

		//json문서를 TextMessage 클래스 객체로 변경
		TextMessage msg = new TextMessage(jobj.toString());
		
		//현재 접속된 모든 사용자에게 메세지 보냄
		for (WebSocketSession client : list) {
			if (client.isOpen()) {
				// 메세지를 전송함.
				client.sendMessage(msg);
			}
		}
		
		System.out.println(id + "님 입장");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		
		try {
			JSONObject jobj = new JSONObject(message.getPayload());
			Chat chat = new Chat();
			chat.setId(System.currentTimeMillis());
			chat.setMem_id(jobj.getString("id"));
			chat.setCd(jobj.getInt("cd"));
			chat.setMsg(jobj.getString("msg"));
			
			Calendar calendar = Calendar.getInstance();
			java.util.Date date = calendar.getTime();
			String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			chat.setDate(today);
			
			mongoTemplate.save(chat, "chat");	//(vo, "collection 이름)
		
		
		}
		catch(Exception e) {
			
		}

		Map<String, Object> arg3 = session.getAttributes();
		String id = (String)arg3.get("_ID");

		
		// 전달된 메세지 TextMessage클래스를 String으로 변경
		String payloadMessage = message.getPayload();
		System.out.println("서버 - " + payloadMessage);
		// list에 담겨져 있는 회원수 만큼 반복
		for (WebSocketSession client : list) {
			// 전달할 메세지를 만듬
			TextMessage msg = new TextMessage(id+" : " + payloadMessage);
			// 클라이언트가 연결된 상태이면
			if (client.isOpen()) {
				// 메세지를 전송함.
				client.sendMessage(msg);
			}
		}
	}

	/*@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		String payloadMessage = message.getPayload().toString();
		System.out.println("서버1 - " + payloadMessage);
	}*/

}
