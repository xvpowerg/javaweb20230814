package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.Student;
import tw.com.db.DBTools;
import tw.com.db.StudentDao;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		   StudentDao stDao =  	DBTools.getMySQLStudentDao();
//		   boolean b1 = stDao.createStudent("Vivin", 96);
//		   System.out.println(b1);
		   Student st = stDao.findStudent(2);
		   System.out.println(st.getId()+":"+st.getStName()+":"+st.getScore1());
		}
}
