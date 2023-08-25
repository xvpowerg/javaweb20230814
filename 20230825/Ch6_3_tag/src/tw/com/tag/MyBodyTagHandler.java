package tw.com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class MyBodyTagHandler implements BodyTag {
	  private PageContext pageContext;
	    private String message;
	    private int counter = 1;
	    private Tag parent;
	    
	    
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public int doAfterBody() throws JspException {
			// TODO Auto-generated method stub
			if (counter > 3) {
				return EVAL_PAGE;
			}
			counter++;
			return EVAL_BODY_AGAIN;
		}

		@Override
		public int doEndTag() throws JspException {
			 JspWriter out = this.pageContext.getOut();
			 
			 try {
				out.print("<h1>標籤結束</h1>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			// TODO Auto-generated method stub
			return EVAL_PAGE;
		}

		@Override
		public int doStartTag() throws JspException {
			// TODO Auto-generated method stub
			JspWriter out = pageContext.getOut();
			try {
				out.print(
						String.format("<h1>%s開始標籤</h1>", this.message));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return EVAL_BODY_INCLUDE;
		}

		@Override
		public Tag getParent() {
			// TODO Auto-generated method stub
			return this.parent;
		}

		@Override
		public void release() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setPageContext(PageContext pc) {
			// TODO Auto-generated method stub
			this.pageContext = pc;
		}

		@Override
		public void setParent(Tag t) {
			// TODO Auto-generated method stub
			this.parent = t;
		}

		@Override
		public void doInitBody() throws JspException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBodyContent(BodyContent arg0) {
			// TODO Auto-generated method stub
			
		}
	
}
