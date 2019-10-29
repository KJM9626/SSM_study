package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring2.ioc.demo.impl.MyCalculator;
import com.spring2.ioc.demo.inter.Calculator;
import com.spring2.ioc.proxy.CalculatorProxy;

public class AOPTest {
	
	private ApplicationContext ab=new ClassPathXmlApplicationContext("config2/applicationContext3.xml"); 
	

	@Test
	public void test() {
		Calculator calculator=new MyCalculator();
		Calculator calculator2=CalculatorProxy.getProxy(calculator);
		calculator2.div(3, 1);
	}
	@Test
	public void test2() {
		Calculator calculator=ab.getBean(Calculator.class);
		calculator.div(3, 1);
	}
	@Test
	public void test3() {
		Calculator calculator=ab.getBean(Calculator.class);
		calculator.add(3, 5);
	}
	

}
