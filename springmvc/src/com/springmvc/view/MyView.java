package com.springmvc.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;


public class MyView implements View {

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//������Ӧ��������
		response.setContentType("text/html");
		System.out.println("�㱣��������ǣ�"+model);
		response.getWriter().write("�������Զ������ͼ����������ͼ����");
	}
	
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return "text/html";
	}

}
