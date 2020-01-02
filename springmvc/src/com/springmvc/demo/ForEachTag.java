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
	private String var;//��ǰ��������Ҫ�ŵ����е�������
	
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
		}else if (items.getClass().isArray()) {//�����������͵�����
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
			//����ELֻ�ܴ����Ĵ����е����ݣ��������ｫ��ǰ����������뵽page����
			//��keyΪvar��ָ�������ƣ���value��Ϊ��ǰ�ı�������obj
			this.getJspContext().setAttribute(var, obj);
			this.getJspBody().invoke(null);
		}
	}

}
