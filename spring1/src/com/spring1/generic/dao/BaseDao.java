package com.spring1.generic.dao;

public class BaseDao<T> {
	
	public void save() {
		System.out.println("dao层进行业务处理");
	}

}
