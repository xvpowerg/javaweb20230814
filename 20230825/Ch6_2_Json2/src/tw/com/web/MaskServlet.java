package tw.com.web;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.Mask;
import tw.com.json.MaskJsonTools;
import tw.com.net.MaskNetTools;

@WebServlet(urlPatterns = {"/mask"},asyncSupported = true)
public class MaskServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet:"+Thread.currentThread().getName());
		AsyncContext ctx = req.startAsync();
		
		Consumer<List<Mask>> maskObjTOpage = list->{
			
			System.out.println(list);
			try {
			 	ServletRequest newReq =  ctx.getRequest();
			    ServletResponse newResp = ctx.getResponse();
			    newReq.setAttribute("maskList", list);
			    newReq.getRequestDispatcher("/mask.jsp").
				forward(newReq, newResp);
	
			    
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ctx.complete();
		
		};
		
			MaskNetTools.getMaskJson(json->{
				try {
					System.out.println(Thread.currentThread().getName());
					MaskJsonTools.makJsonToObj(json, maskObjTOpage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
	}
}
