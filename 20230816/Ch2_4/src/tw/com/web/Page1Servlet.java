package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	//A~Z
	private String test(int a) {
		char base = 'A';
		int char1 = a % 25 + base;
		String result = ((char)char1)+""; 
		return result;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out =  resp.getWriter();
		 //out.println(test(26));
		 String countStr = req.getParameter("count");
		 int count = Integer.parseInt(countStr);
		 out.println("<html>");
			 out.println("<body>");
			 for (int i = 0; i <count;i++) {
				 out.print("<p>"+test(i)+"</p>");
			 }
			 out.println("</body>");
		 out.println("</html>");
	}
}
