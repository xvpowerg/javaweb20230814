package tw.com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MyBodyTagSuppor extends BodyTagSupport {
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		BodyContent  bodyContent =   getBodyContent();
		String body = bodyContent.getString();
		 JspWriter  out =  bodyContent.getEnclosingWriter();
		 if (body != null) {
			 try {
				out.println(body.toUpperCase());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		 }
		return SKIP_BODY;
	}
}
