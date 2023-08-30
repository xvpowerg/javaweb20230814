package tw.com.ejb;

import javax.ejb.Local;

import tw.com.jpa.MyUser;

@Local
public interface MyUserBeanLocal {
	public boolean login(MyUser myUser);
	public boolean  register(MyUser myUser);
	public MyUser findUserByAccount(String account);
	public boolean deleteUser(MyUser myUser);
}
