package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = Integer.parseInt(req.getParameter("count"));
		String title = req.getParameter("title");
		req.setAttribute("count", count);
		req.setAttribute("title", title);
		req.getRequestDispatcher("/page2.jsp").forward(req, resp);
	}
}
