package tw.com.web;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebScoketSession {
	
	@OnMessage
	public void onMessage(String message,Session session) throws IOException, InterruptedException {
		session.getBasicRemote().sendText("我收到訊息了:"+message);
		for (int i = 0 ; i <= 10; i++) {
			Thread.sleep(500);
		   session.getBasicRemote().sendText("Server Send Msg:"+i);	
		}
	}
}
