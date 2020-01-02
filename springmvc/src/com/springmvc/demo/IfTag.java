package com.springmvc.demo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport {
	private boolean test;
	public void setTest(boolean test) {
		this.test = test;
	}


	@Override
	public void doTag() throws JspException, IOException {
		if(test) {
			//获取标签体
			JspFragment jf=this.getJspBody();
			//将标签体内容写入到输出流
			jf.invoke(this.getJspContext().getOut());
			//this.getJspBody().invoke(null);这个语句等价于上面的效果
		}
	}

}
