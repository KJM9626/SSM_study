package com.spring2.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulService {
	@Autowired
	private BookService bookService;
	
	@Transactional
	public void mulTx() {
		//Propagation.REQUIRES_NEW,�������쳣����֮ǰ�����Ѿ��ύ
		bookService.checkOut("Mike", "ISBN-002");
		bookService.updatePrice("ISBN-002", 1000);
		int i=10/0;
	}

}
