package com.springmvc.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;


public class MyView implements View {

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//设置响应内容类型
		response.setContentType("text/html");
		System.out.println("你保存的数据是："+model);
		response.getWriter().write("这是你自定义的视图解析器和视图对象");
	}
	
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return "text/html";
	}

}
