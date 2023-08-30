package tw.com.ws;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@Path("myuser")
@Produces(MediaType.APPLICATION_JSON) //¦^¶ÇJSON
public class TestMyUserWs {
	@EJB
	private MyUserBeanLocal myUserBean;
	
	public class Msg{
		private String msg;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
	}
	
	@POST
	public Response register(@FormParam("account") String account,
			@FormParam("password") String password) {
			
		MyUser myUser = new MyUser();
		myUser.setAccount(account);
		myUser.setPassword(password);
		
		boolean pass = myUserBean.register(myUser);
		if (pass) {
			return Response.ok().encoding("utf-8").entity(myUser).build();
		}
		Msg msg = new Msg();
		msg.setMsg("¥¢±Ñ");
		return Response.status(400).entity(msg).build();
	}
	
	
	@GET
	public String testHello() {
		return "{\"value\":\"Hello\" }";
	}
}
