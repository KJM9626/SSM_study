package com.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring1.demo.Person;
import com.spring1.generic.service.BaseService;
import com.spring1.generic.service.BookService;
import com.spring1.generic.service.UserService;
import com.spring1.ssd.servlet.BookServlet;

public class IOCTest2 {
	private ConfigurableApplicationContext ab = new ClassPathXmlApplicationContext("config2/applicationContext.xml");
	private ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("config2/applicationContext2.xml");

	@Test
	public void test() {
//		ab.getBean("book1");
		System.out.println("调用close方法关闭容器");
		ab.close();
	}

	@Test
	public void test2() throws SQLException {
//		从容器中拿到连接池
		DataSource dSource = (DataSource) ac.getBean("dSource");
//		按照类型获取组件，可以获取到这个类下的所有实现类子类,仅对于配置文件中bean的实例只有一个
//		DataSource dSource2=ac.getBean(DataSource.class);
		System.out.println(dSource.getConnection());
//		System.out.println(dSource==dSource2);
	}

	@Test
	public void test3() {
		Person p1 = ac.getBean("person1", Person.class);
		System.out.println(p1.getBooks());
	}

	/*
	 * @Test public void test4() { System.out.println("测试注解下创建的实例"); BookServlet
	 * bServlet = (BookServlet) ac.getBean("bookServlet"); // Object
	 * object2=ac.getBean("hello"); // System.out.println(object1==object2);
	 * bServlet.getService(); }
	 */

	@Test
	public void test5() {
		BookService bService = ac.getBean("bookService", BookService.class);
		UserService uService = ac.getBean("userService", UserService.class);
		bService.getDao();
		uService.getDao();
		
		System.out.println(bService.getClass().getGenericSuperclass());
	}

}
