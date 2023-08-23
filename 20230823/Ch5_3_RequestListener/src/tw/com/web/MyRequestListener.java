package tw.com.web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestAttributeListener {
		@Override
		public void attributeAdded(ServletRequestAttributeEvent srae) {
			// TODO Auto-generated method stub
			String name = srae.getName();
			String value = srae.getValue().toString();
			System.out.println("Add:"+name+" value:"+value);
		}
		@Override
		public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
			String name = srae.getName();
			String value = srae.getValue().toString();//¨ú±oÂÂ­È
			String newValue = srae.getServletRequest().getAttribute(name).toString();//·s­È
			
			System.out.println("Replaced:"+name+" value:"+value+" newValue:"+newValue);
		}
		@Override
		public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
			String name = srae.getName();
			String value = srae.getValue().toString();
			System.out.println("Removed(:"+name+" value:"+value);
			
		}
}
