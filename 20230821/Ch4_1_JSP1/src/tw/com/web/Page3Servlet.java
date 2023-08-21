package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.beans.Item;

@WebServlet("/page3")
public class Page3Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Item it1 = new Item();
		it1.setId(1);
		it1.setName("A1");
		Item it2 = new Item();
		it2.setId(2);
		it2.setName("A2");
		Item it3 = new Item();
		it3.setId(3);
		it3.setName("A3");
		
		
		ArrayList<Item> list = new ArrayList();
		list.add(it1);
		list.add(it2);
		list.add(it3);
	 	HttpSession session = req.getSession();
	 	session.setAttribute("itemList", list);
	 	req.getRequestDispatcher("page3.jsp").forward(req, resp);
	}
}
