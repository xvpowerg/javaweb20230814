package tw.com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MsgHelloTag extends TagSupport {
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		PageContext pageContext =   this.pageContext;
		 JspWriter  out =  pageContext.getOut();
		 String msg = String.format("<font size='6' color='red'>%s§A¦n!</font>", this.getMessage()) ;
		 try {
			out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
}
