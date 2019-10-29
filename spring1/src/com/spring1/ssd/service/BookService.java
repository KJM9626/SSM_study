package com.spring1.ssd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.ssd.dao.BookDao;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	public void getDao() {
		System.out.println("service�����dao��ķ��������߼�����");
		bookDao.save();
	}
}
