package com.springmvc.view;

import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class MeiNVViewResolver implements ViewResolver,Ordered{

	private int order=0;
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		//根据视图名返回视图对象
		if(viewName.startsWith("meinv:")) {
			return new MyView();
		}else {
			return null;
		}
		
	}

	@Override
	public int getOrder() {
		return this.order;
	}
	public void setOrder(int order) {
		this.order=order;
	}

}
