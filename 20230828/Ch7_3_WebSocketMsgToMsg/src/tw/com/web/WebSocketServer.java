package tw.com.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.bean.Msg;

@ServerEndpoint("/websocket")
public class WebSocketServer {
	private static Map<String,Session> sessionMap = new HashMap(); 
	@OnMessage
	public void onMessage(String message,Session session) 
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMap = new ObjectMapper();
		Msg msg = objMap.readValue(message, Msg.class);
		  System.out.println(msg);
		  session.getBasicRemote().sendText("我收到訊息:"+message);
		  
	     sessionMap.putIfAbsent(msg.getFromUser(), session);
		  
		 
		  if (sessionMap.containsKey(msg.getToUser())) {
			  String msgStr = msg.getMsg();
			  sessionMap.get(msg.getToUser()).
			  getBasicRemote().sendText(msgStr);
		  }else {
			  session.getBasicRemote().sendText("無法傳送!");
		  }
		
	}
//	@OnMessage
//	public void onMessage(String message,Session session) 
//			throws JsonParseException, JsonMappingException, IOException {
//		ObjectMapper objMap = new ObjectMapper();
//		  Map<String,String> mapMsg =
//				  objMap.readValue(message, Map.class);
//		  System.out.println(mapMsg);
////		  session.getBasicRemote().sendText("我收到訊息:"+message);
//		  
//		  if (mapMsg.containsKey("fromUser")) {
//			  String fromUser = mapMsg.get("fromUser");
//			  sessionMap.putIfAbsent(fromUser, session);
//		  }
//		  String toUser = mapMsg.get("toUser");
//		  if (sessionMap.containsKey(toUser)) {
//			  String msg = mapMsg.get("msg");
//			  sessionMap.get(toUser).
//			  getBasicRemote().sendText(msg);
//		  }else {
//			  session.getBasicRemote().sendText("無法傳送!");
//		  }
//		
//	}
}
