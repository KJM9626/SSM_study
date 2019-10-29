package com.spring1.ssd.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.spring1.ssd.dao.BookDao;
import com.spring1.ssd.service.BookService;

@Controller
public class BookServlet {

//	@Qualifier("bookService")
//	@Autowired(required = false)
//	@Autowired
	private BookService bookServiceExt;
	
	@Autowired
	public BookServlet(@Qualifier("bookServiceExt")BookService bookService) {
		this.bookServiceExt=bookService;
		System.out.println("bookService"+bookService);
	}
//	@Autowired
	public void get(BookDao bookDao,@Qualifier("bookServiceExt")BookService bookService) {
		System.out.println("bookDao:"+bookDao+",bookService"+bookService);
	}
	
	
	public void getService() {
//		System.out.println("bookService:"+bookServiceExt);
		bookServiceExt.getDao();
	}
}
