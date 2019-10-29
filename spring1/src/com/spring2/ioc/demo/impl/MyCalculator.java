package com.spring2.ioc.demo.impl;

import org.springframework.stereotype.Service;

import com.spring2.ioc.demo.inter.Calculator;

/**
 * @author 明
 *真正的业务处理类
 *
 *使用经过spring封装后的aop切面
 */

@Service
public class MyCalculator implements Calculator{

	@Override
	public int add(int i, int j) {
		int m=i+j;
		return m;
	}

	@Override
	public int sub(int i, int j) {
		int m=i-j;
		return m;
	}

	@Override
	public int mul(int i, int j) {
		int m=i*j;
		return m;
	}

	@Override
	public int div(int i, int j) {
		int m=i/j;
		return m;
	}

}
