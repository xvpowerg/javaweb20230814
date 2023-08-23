package tw.com.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionListener implements HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object obj = event.getValue();
		System.out.println("Add:"+name+" value:"+obj);
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object obj = event.getValue();
		HttpSession session =  event.getSession();
		System.out.println("Replaced:"+name+" value:"+obj+" newValue:"+session.getAttribute(name));
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object obj = event.getValue();
		System.out.println("Removed:"+name+" value:"+obj);
	}
}
