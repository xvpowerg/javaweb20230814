package tw.com.cdi;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import tw.com.bean.MyApple;
import tw.com.bean.MyUser;

public class MyProduces {
	
	@Produces
	@Named("redApple")
	private MyApple getRedApple() {
		MyApple myApple = new MyApple();
		
		myApple.setName("Red Apple");
		myApple.setPrice(100);
		return myApple;
	}
	@Produces
	@Named("kenUser")
	private MyUser myUser = new MyUser(10,"Ken");
	
	@Produces
	@Named("myUserList")
	private List<MyUser> myUserList(){
		List<MyUser> myUserList = new ArrayList();
		MyUser myUser = new MyUser(2,"Vivin");
		MyUser myUser2 = new MyUser(3,"Lucy");
		myUserList.add(myUser);
		myUserList.add(myUser2);
		return myUserList;	
	}

}
