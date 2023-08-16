package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.User;


@WebServlet("/login")
public class LoginServlet  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String acc = req.getParameter("acc");
		String pwd = req.getParameter("pwd");
		if (acc.equals("qwer") && pwd.equals("12345")) {
			User user = new User();
			user.setAcc(acc);
			user.setPwd(pwd);
			req.setAttribute("user", user);
			req.getRequestDispatcher("/page1").forward(req, resp);//Âà´«­¶­±
		}else {
			req.getRequestDispatcher("/page2").forward(req, resp);
		}
	}
}
