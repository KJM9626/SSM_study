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
	 * 结账：传入哪个用户买了那本书
	 * @throws FileNotFoundException 
	 */
	@Transactional(rollbackFor = {FileNotFoundException.class},propagation = Propagation.REQUIRES_NEW)
	public void checkOut(String userName,String isbn) {
		bookDao.updateStock(isbn);
		int price = bookDao.getPrice(isbn);
		bookDao.updateBalance(userName, price);
		//int i=1/0;运行时异常
		//new FileInputStream("D://helllo.txt");编译时异常
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
