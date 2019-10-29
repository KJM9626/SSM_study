package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring1.ssd.servlet.BookServlet;

@ContextConfiguration(locations = "classpath:config2/applicationContext2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCTest3 {

	ConfigurableApplicationContext ioc=null;
	@Autowired
	private BookServlet bookServlet;
	
	@Test
	public void test() {
		bookServlet.getService();
	}
}
