package tw.com.beans;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.time.LocalDateTime;
public class MyUser implements HttpSessionBindingListener {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "MyUser [name=" + name + "]";
		}
		
		@Override
		public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
			LocalDateTime time = LocalDateTime.now();
			System.out.println("login:"+time);
		}
		
		@Override
		public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
			LocalDateTime time = LocalDateTime.now();
			System.out.println("logout:"+time);
		}
		
}
