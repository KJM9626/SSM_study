package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring1.demo.AirPlane;
import com.spring1.demo.Book;
import com.spring1.demo.Car;
import com.spring1.demo.Person;
import com.spring1.factory.AirPlaneStaticFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class IOCTest {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("config/ioc.xml");
	private ApplicationContext ab = new ClassPathXmlApplicationContext("config/ioc2.xml");
	private ApplicationContext ad = new ClassPathXmlApplicationContext("config/ioc3.xml");

	
	@Test
	public void test() {

		Person p1 = (Person) ac.getBean("person1");
//		Person person=ac.getBean("person2",Person.class);
		System.out.println(p1.getName());

//		Person p3=(Person) ac.getBean("person3");
//		System.out.println(p3.getEmail());

		Person p5 = ac.getBean("person5", Person.class);
		System.out.println(p5);
	}

	@Test
	public void test2() {
		Person p1 = ab.getBean("person1", Person.class);
//		System.out.println(p1.getName()==null);
		Car car = p1.getCar();
		System.out.println(car);
//		System.out.println(car==ab.getBean("car1"));
		List<Book> books = p1.getBooks();
		System.out.println(books);

		Map<String, Object> map = p1.getMap();
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println("key=" + key + " " + map.get(key));
		}
		System.out.println(ab.getBean("map1")==p1.getMap());
		
		Properties properties=p1.getProperties();
		System.out.println(properties);
	}
	@Test
	public void test3() {
		Person p3=ab.getBean("person3", Person.class);
		System.out.println(p3.getAge());
	}
	
	@Test
	public void test4() {
		Person p1=ad.getBean("person1", Person.class);
		Person p2=ad.getBean("person1", Person.class);
		System.out.println(p1==p2);
		Book b1=ad.getBean("book1", Book.class);
		Book b2=ad.getBean("book1", Book.class);
		System.out.println(b1==b2);
	}
	
	@Test
	public void test5() {
//		Object object=ad.getBean("sf");
//		System.out.println(object);
//		
//		Object object2=ad.getBean("ap");
//		System.out.println(object2);
		
		Object object3=ad.getBean("myFactoryBeanImpl");
		Object object4=ad.getBean("myFactoryBeanImpl");
		System.out.println(object3==object4);
		
	}

}
