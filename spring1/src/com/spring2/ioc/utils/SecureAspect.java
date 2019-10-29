package com.spring2.ioc.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class SecureAspect {
	public static void logStart(JoinPoint joinPoint) {
		Object[] args=joinPoint.getArgs();
		String name=joinPoint.getSignature().getName();
		System.out.println("SecureAspect这是动态代理将要帮你执行方法");
		System.out.println("SecureAspect使用了[" + name+ "]方法，传入的参数为[" + Arrays.asList(args) + "]");
	}
	public static void logReturn(JoinPoint joinPoint,Object result) {
		String name=joinPoint.getSignature().getName();
		System.out.println("SecureAspect "+name+ "方法返回的结果是" + result);
	}
	public static void logException(JoinPoint joinPoint,Exception e) {
		String name=joinPoint.getSignature().getName();
		System.out.println("SecureAspect "+name+"方法出现了异常，异常信息为："+e);
	}
	public static void logEnd() {
		System.out.println("SecureAspect aop的后置通知方法执行");
	}

}
