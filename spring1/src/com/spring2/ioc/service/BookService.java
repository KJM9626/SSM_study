package com.spring2.ioc.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring2.ioc.dao.BookDao;


@Service
public class BookService {
	@Autowired
	private BookDao bookDao;

	/**
	 * @param userName
	 * @param isbn
	 * ���ˣ������ĸ��û������Ǳ���
	 * @throws FileNotFoundException 
	 */
	@Transactional(rollbackFor = {FileNotFoundException.class},propagation = Propagation.REQUIRES_NEW)
	public void checkOut(String userName,String isbn) {
		bookDao.updateStock(isbn);
		int price = bookDao.getPrice(isbn);
		bookDao.updateBalance(userName, price);
		//int i=1/0;����ʱ�쳣
		//new FileInputStream("D://helllo.txt");����ʱ�쳣
	}
	
	@Transactional(readOnly = true,isolation = Isolation.READ_UNCOMMITTED)
	public int getPrice(String isbn) {
		return bookDao.getPrice(isbn);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updatePrice(String isbn,int price) {
		bookDao.updatePrice(isbn, price);
//		int i=10/0;
	}
}
