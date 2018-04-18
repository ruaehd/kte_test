package socket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// ws서버주소 => 'ws://127.0.0.1:8080/web2/wsserver
@ServerEndpoint("/wsserver")
public class WebSocketServer {

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());	//비 순차적, 속도 장점, 동기화 필요	//List 순차적
	
	
	@OnMessage
	public void onMessage(String message, Session session)
		throws IOException{
		synchronized (clients) {
			for(Session one : clients) {
				/*if(session != one) {*/
					//여기서 메세지를 보냄
					one.getBasicRemote().sendText(message);
				/*}*/
			}
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("참여 : "+session);
		clients.add(session);
		/*SqlSession sqlsession = SqlMapClient.getSession();
		sqlsession.insert("V3_Sale.insert", session.getId());
		sqlsession.commit();*/
		
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("나감 : "+session);
		clients.remove(session);
		
	}
}
