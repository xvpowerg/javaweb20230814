package tw.com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/testdb20230828?serverTimezone=CST&useSSL=false&allowPublicKeyRetrieval=true";
	    String user = "root";
	    String password = "123456";
	    String sql = "INSERT INTO student(stname,score1)VALUES(?,?)";
	   try(Connection con = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = con.prepareStatement(sql)){
		   ps.setString(1, "Ken");
		   ps.setInt(2, 95);
		   ps.executeUpdate();
	   }catch(SQLException ex) {
		   System.out.println(ex);
	   }
	}
}
