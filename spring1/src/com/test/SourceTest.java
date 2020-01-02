package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring1.demo.Person;

public class SourceTest {
	private static ApplicationContext context;

	public static void main(String[] args) {
	    context=new ClassPathXmlApplicationContext("config/ioc.xml");
	    Person bean = context.getBean("person1", Person.class);
	    System.out.println(bean);
	}

}
