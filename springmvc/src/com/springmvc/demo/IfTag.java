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
			//��ȡ��ǩ��
			JspFragment jf=this.getJspBody();
			//����ǩ������д�뵽�����
			jf.invoke(this.getJspContext().getOut());
			//this.getJspBody().invoke(null);������ȼ��������Ч��
		}
	}

}
