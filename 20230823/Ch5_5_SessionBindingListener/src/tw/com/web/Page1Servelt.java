package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.beans.MyUser;

@WebServlet("/page1")
public class Page1Servelt extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session =  req.getSession();
		 if (req.getParameter("test") != null) {
			 session.setAttribute("test", "test");
			 return;
		 }
		 if (req.getParameter("logout") != null) {
			 session.removeAttribute("myuser");
		 }else {
			 MyUser myUser = new MyUser();
			 myUser.setName("Ken");
			 session.setAttribute("myuser", myUser);
		 }
		
		
	}
}
