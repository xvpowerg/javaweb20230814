package tw.com.bean;

import javax.inject.Inject;

public class MyUser {
	private int id;
	private String name;
	//要@Inject 需有預設建構式
	public MyUser() {
		super();
	}
	public MyUser(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", name=" + name + "]";
	}
	
}
