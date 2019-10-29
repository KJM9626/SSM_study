package com.spring1.factory;

import java.util.UUID;

import org.springframework.beans.factory.FactoryBean;

import com.spring1.demo.Book;

public class MyFactoryBeanImpl implements FactoryBean<Book> {

	/**
	 *getObject����������
	 *���ش����Ķ���
	 */
	@Override
	public Book getObject() throws Exception {
		Book book=new Book();
		book.setBookName(UUID.randomUUID().toString());
		return book;
	}
	/**
	 *���ش����Ķ��������
	 *spring���Զ��������������ȷ�϶�����ʲô����
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
