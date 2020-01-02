package com.springmvc.demo;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author ��
 *��ȡ�ͻ���IP
 */
public class ClientIpTag extends SimpleTagSupport {
	@Override
	public void doTag() throws IOException {
		//��ȡPageContext����
		PageContext pc=(PageContext) this.getJspContext();
		//��ȡ�������
		ServletRequest request=pc.getRequest();
		//��ȡ�ͻ���IP
		String clientIP=request.getRemoteAddr();
		//��ȡ��׼�����
		JspWriter out=pc.getOut();
		//���ͻ���IPд�뵽�������
		out.print(clientIP);
	}

}
