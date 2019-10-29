package com.spring1.generic.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring1.generic.dao.BaseDao;

public class BaseService<T> {
	
	@Autowired 
	private BaseDao<T> baseDao;
	
	public void getDao() {
		System.out.println("Service�����Dao�㷽�������߼�����"+baseDao);
		baseDao.save();
	}

}
