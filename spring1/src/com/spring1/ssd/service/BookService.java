package com.spring1.ssd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.ssd.dao.BookDao;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	public void getDao() {
		System.out.println("service层调用dao层的方法进行逻辑处理");
		bookDao.save();
	}
}
