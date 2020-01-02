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
		//创建一个输出流，该流中的内容可通过其toString方法获取到其文本形式
		StringWriter writer = new StringWriter();
		//获取标签体对象
		JspFragment jf=this.getJspBody();
		//将标签体内容写入到输出流
		jf.invoke(writer);
		//以文本的形式获取到输出流中的内容
		String content = writer.toString();
		//小写变大写
		content=content.toUpperCase();
		//将转换为的大写内容写入到标准输出流中
		JspWriter out=this.getJspContext().getOut();
		out.print(content);
	}

}
