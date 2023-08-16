package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	private String[] foods = {"Âû»L¶º","±Æ°©¶º","³½±Æ¶º"};
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			// TODO Auto-generated method stub
			 PrintWriter  out =  resp.getWriter();
			 out.println("Page1!");
			//String item =  req.getParameter("items");
			 //out.println("item:"+item);
			String[] items =  req.getParameterValues("items");
			
			for (String v : items) {
				 int index =  Integer.parseInt(v);
				out.println(foods[index]);
			}
		}
}
