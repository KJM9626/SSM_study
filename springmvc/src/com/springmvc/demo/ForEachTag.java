package com.springmvc.demo;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport{
	
	private Object items;
	private String var;//当前遍历对象要放到域中的属性名
	
	public void setItems(Object items) {
		this.items = items;
	}


	public void setVar(String var) {
		this.var = var;
	}
	public Collection getColl() {
		if(items instanceof List) {
			return (List)items;
		}else if(items instanceof Set) {
			return (Set)items;
		}else if(items instanceof Map) {
			return ((Map)items).entrySet();
		}else if(items instanceof Object[]) {
			return Arrays.asList((Object[])items);
		}else if (items.getClass().isArray()) {//遍历所有类型的数组
			List nums=new ArrayList();
			for(int i=0;i<Array.getLength(items);i++) {
				nums.add(Array.get(items, i));
			}
			return nums;
		}
		return null;
	}


	@Override
	public void doTag() throws JspException, IOException {
		for (Object obj : getColl()) {
			//由于EL只能处理四大域中的数据，所以这里将当前遍历对象放入到page域中
			//其key为var所指定的名称，而value则为当前的遍历对象obj
			this.getJspContext().setAttribute(var, obj);
			this.getJspBody().invoke(null);
		}
	}

}
