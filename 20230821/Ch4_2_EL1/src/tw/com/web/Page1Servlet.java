package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.beans.MyItem;
import tw.com.beans.MyUser;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyItem it1 = new MyItem("MyItem",100);
		MyUser user1 = new MyUser("MyUser",25);
		req.setAttribute("Item1", it1);
		HttpSession session =  req.getSession();
		session.setAttribute("User1", user1);
		
		Map<String,MyUser> myUserMap = new HashMap<>();
		myUserMap.put("user1",new MyUser("Ken",18));
		myUserMap.put("user2 vivin",new MyUser("Vivin",25));
		req.setAttribute("userMap", myUserMap);
		
		
		List<MyUser> arryList = new ArrayList<>();
		arryList.add(new MyUser ("Lucy",10));
		arryList.add(new MyUser ("Joy",20));
		arryList.add(new MyUser ("Ken",25));
		req.setAttribute("userList", arryList);
		
		req.getRequestDispatcher("/page1.jsp").
		forward(req, resp);
	}
}
