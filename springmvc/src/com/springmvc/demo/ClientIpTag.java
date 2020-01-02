package com.springmvc.demo;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author 明
 *获取客户端IP
 */
public class ClientIpTag extends SimpleTagSupport {
	@Override
	public void doTag() throws IOException {
		//获取PageContext对象
		PageContext pc=(PageContext) this.getJspContext();
		//获取请求对象
		ServletRequest request=pc.getRequest();
		//获取客户端IP
		String clientIP=request.getRemoteAddr();
		//获取标准输出流
		JspWriter out=pc.getOut();
		//将客户端IP写入到输出流中
		out.print(clientIP);
	}

}
