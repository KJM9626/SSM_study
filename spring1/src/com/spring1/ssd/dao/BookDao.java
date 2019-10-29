package com.spring1.ssd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("hello")
@Scope(value = "prototype")
public class BookDao {

	public void save() {
		System.out.println("dao层实现保存数据");
	}
}
