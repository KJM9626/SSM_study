package com.spring2.ioc.demo.impl;

import org.springframework.stereotype.Service;

import com.spring2.ioc.demo.inter.Calculator;

/**
 * @author ��
 *������ҵ������
 *
 *ʹ�þ���spring��װ���aop����
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
