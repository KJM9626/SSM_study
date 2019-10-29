package com.spring1.generic.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring1.generic.dao.BaseDao;

public class BaseService<T> {
	
	@Autowired 
	private BaseDao<T> baseDao;
	
	public void getDao() {
		System.out.println("Service层调用Dao层方法进行逻辑处理"+baseDao);
		baseDao.save();
	}

}
