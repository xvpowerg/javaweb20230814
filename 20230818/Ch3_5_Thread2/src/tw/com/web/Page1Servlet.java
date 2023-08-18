package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	private ExecutorService es;
	//init Servlet第一次創建時呼叫
	@Override
	public void init() throws ServletException {
		es = Executors.newCachedThreadPool();		
	}
	
	private void test( HttpServletResponse resp) throws IOException {
		System.out.println("Test Run Start");
		try {
			Thread.sleep(5000);
		}catch(Exception ex) {
			
		}
		resp.getWriter().println("Test Run End");
		System.out.println("Test Run End");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		out.println("Page1 Start!");
		es.execute(()->{
			try {
				test(resp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		out.println("Page1 End");
	}
}
