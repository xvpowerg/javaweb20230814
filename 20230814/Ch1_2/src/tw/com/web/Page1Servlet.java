package tw.com.web;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws  IOException{
			//HttpServletRequest 接收輸入
		    //HttpServletResponse 輸出
		PrintWriter out = resp.getWriter();
		out.print("Page1");
		
	}
}
