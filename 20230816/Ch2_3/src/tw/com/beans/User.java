package tw.com.beans;

public class User {
	private String acc;
	private String pwd;
	
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "User [acc=" + acc + ", pwd=" + pwd + "]";
	}
	
	
}
