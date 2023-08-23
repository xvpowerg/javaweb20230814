package tw.com.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated met;hod stub
		  Part part =   req.getPart("photo");
		  String fileName =   part.getSubmittedFileName(); 
		  //System.out.println(fileName);
		  String fileDir = "C:\\upload_images"+File.separator+fileName;
		  try(InputStream intStream = part.getInputStream();
				FileOutputStream out = new FileOutputStream(fileDir)  ){
			  byte[] buffer = new byte[1024];
			  int index = -1;
			  while( (index = intStream.read(buffer)) != -1) {
				  out.write(buffer,0,index);
			  }
			  
		  }
		  
		  resp.sendRedirect("view_images");
		  
	}

}
