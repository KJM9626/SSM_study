package com.springmvc.demo;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ELFunction extends SimpleTagSupport{
	
	public static String lowerToUpper(String source) {
		return source.toUpperCase();
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		//����һ��������������е����ݿ�ͨ����toString������ȡ�����ı���ʽ
		StringWriter writer = new StringWriter();
		//��ȡ��ǩ�����
		JspFragment jf=this.getJspBody();
		//����ǩ������д�뵽�����
		jf.invoke(writer);
		//���ı�����ʽ��ȡ��������е�����
		String content = writer.toString();
		//Сд���д
		content=content.toUpperCase();
		//��ת��Ϊ�Ĵ�д����д�뵽��׼�������
		JspWriter out=this.getJspContext().getOut();
		out.print(content);
	}

}
