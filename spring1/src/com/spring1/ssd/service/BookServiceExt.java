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
		System.out.println("����BookServiceExt��д��һ������");
		bookDao.save();
	}
}
