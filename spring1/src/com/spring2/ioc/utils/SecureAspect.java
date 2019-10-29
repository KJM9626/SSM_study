package com.spring2.ioc.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class SecureAspect {
	public static void logStart(JoinPoint joinPoint) {
		Object[] args=joinPoint.getArgs();
		String name=joinPoint.getSignature().getName();
		System.out.println("SecureAspect���Ƕ�̬����Ҫ����ִ�з���");
		System.out.println("SecureAspectʹ����[" + name+ "]����������Ĳ���Ϊ[" + Arrays.asList(args) + "]");
	}
	public static void logReturn(JoinPoint joinPoint,Object result) {
		String name=joinPoint.getSignature().getName();
		System.out.println("SecureAspect "+name+ "�������صĽ����" + result);
	}
	public static void logException(JoinPoint joinPoint,Exception e) {
		String name=joinPoint.getSignature().getName();
		System.out.println("SecureAspect "+name+"�����������쳣���쳣��ϢΪ��"+e);
	}
	public static void logEnd() {
		System.out.println("SecureAspect aop�ĺ���֪ͨ����ִ��");
	}

}
