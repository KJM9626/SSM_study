package com.spring2.ioc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.spring2.ioc.demo.inter.Calculator;
import com.spring2.ioc.utils.LogUtil;

/**
 * @author �� 
 * ������
 *�ײ�ʵ�ִ������ԭ������ 
 */
public class CalculatorProxy {

	/**
	 * @param calculator:���뱻�������
	 * @return�������Ĵ������
	 */
	public static Calculator getProxy(Calculator calculator) {
		// ����ִ������������Ŀ�����ִ��Ŀ�귽��
		InvocationHandler handler = new InvocationHandler() {
			/**
			 * Object proxy��������󣬸�jdk�ã��κ�ʱ�򶼲�Ҫ��������� Method method ����ǰ��Ҫִ�е�Ŀ�����ķ��� Object[]
			 * args�������������ʱ��紫��Ĳ���ֵ
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result=null;
				try {
					// ���÷���ִ��Ŀ�����ķ���
					LogUtil.logStart1(method, args);
					result= method.invoke(calculator, args);
					// Ŀ�귽��ִ�к�ķ���ֵ������ֵ���뷵�س�ȥ�������õ�����ִ�к�ķ���ֵ
					LogUtil.logReturn1(method, result);
				} catch (Exception e) {
					LogUtil.logException1(e);
				}finally {
					LogUtil.logEnd1(method);
				}
				return result;
			}
		};
		ClassLoader loader = calculator.getClass().getClassLoader();
		Class<?>[] interfaces = calculator.getClass().getInterfaces();

		Object proxy = Proxy.newProxyInstance(loader, interfaces, handler);
		return (Calculator) proxy;
	}

}
