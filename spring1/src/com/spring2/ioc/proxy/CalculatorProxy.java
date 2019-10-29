package com.spring2.ioc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.spring2.ioc.demo.inter.Calculator;
import com.spring2.ioc.utils.LogUtil;

/**
 * @author 明 
 * 代理类
 *底层实现代理类的原生方法 
 */
public class CalculatorProxy {

	/**
	 * @param calculator:传入被代理对象
	 * @return：真正的代理对象
	 */
	public static Calculator getProxy(Calculator calculator) {
		// 方法执行器，帮我们目标对象执行目标方法
		InvocationHandler handler = new InvocationHandler() {
			/**
			 * Object proxy：代理对象，给jdk用，任何时候都不要动这个对象 Method method ：当前将要执行的目标对象的方法 Object[]
			 * args：这个方法调用时外界传入的参数值
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result=null;
				try {
					// 利用反射执行目标对象的方法
					LogUtil.logStart1(method, args);
					result= method.invoke(calculator, args);
					// 目标方法执行后的返回值，返回值必须返回出去外界才能拿到真正执行后的返回值
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
