package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.MyApple;
import tw.com.bean.MyUser;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Inject
	@Named("redApple")
	MyApple myApple;
	
	@Inject
	@Named("kenUser")
	MyUser myUser;
	
	@Inject
	@Named("myUserList")
	List<MyUser> myUserList;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  PrintWriter out = 	resp.getWriter();
	  out.println("Page1:"+myApple);
	  out.println("MyUser:"+myUser);
	  out.println("myUserList:"+myUserList);
	}
}
