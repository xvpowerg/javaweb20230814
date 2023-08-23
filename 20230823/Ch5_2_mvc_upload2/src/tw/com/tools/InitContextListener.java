package tw.com.tools;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitContextListener  implements ServletContextListener{
		@Override
		public void contextInitialized(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			 ServletContext context =  sce.getServletContext();
			 String filePath = context.getInitParameter("file_path");
			 ImageTools.setImagePath(filePath);
			System.out.println("InitContextListener!!"+context.getInitParameter("file_path"));
		}
}
