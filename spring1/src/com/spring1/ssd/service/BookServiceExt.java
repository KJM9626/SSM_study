package com.spring1.ssd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.ssd.dao.BookDao;

@Service
public class BookServiceExt extends BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public void getDao() {
		System.out.println("这是BookServiceExt重写的一个方法");
		bookDao.save();
	}
}
