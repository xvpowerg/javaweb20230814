package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.User;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Object user = req.getAttribute("user");
		 PrintWriter out = resp.getWriter();
		 User myUser = (User)user;
		 out.print("<html>");
		 out.print("<body>");
		 out.print("<div>Acc:"+myUser.getAcc()+"</div>");
		 out.print("<div>Pwd:"+myUser.getPwd()+"</div>");
		 out.print("</body>");
		 out.print("</html>");
		 out.print("Success!"+user);
	}
}
