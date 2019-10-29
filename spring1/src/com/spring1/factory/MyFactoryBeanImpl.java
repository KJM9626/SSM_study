package com.spring1.factory;

import java.util.UUID;

import org.springframework.beans.factory.FactoryBean;

import com.spring1.demo.Book;

public class MyFactoryBeanImpl implements FactoryBean<Book> {

	/**
	 *getObject：工厂方法
	 *返回创建的对象
	 */
	@Override
	public Book getObject() throws Exception {
		Book book=new Book();
		book.setBookName(UUID.randomUUID().toString());
		return book;
	}
	/**
	 *返回创建的对象的类型
	 *spring会自动调用这个方法来确认对象是什么类型
	 */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Book.class;
	}

	
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
//		return true;
	}
}
