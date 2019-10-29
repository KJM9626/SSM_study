package com.spring2.ioc.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ��
 *��֤����������˳��
 */
@Component
@Aspect
public class ValidateAspect {
	
	@Before("com.spring2.ioc.utils.LogUtil.reuse()")
	public static void logStart(JoinPoint joinPoint) {
		Object[] args=joinPoint.getArgs();
		String name=joinPoint.getSignature().getName();
		System.out.println("ValidateAspect���Ƕ�̬����Ҫ����ִ�з���");
		System.out.println("ValidateAspectʹ����[" + name+ "]����������Ĳ���Ϊ[" + Arrays.asList(args) + "]");
	}
	@AfterReturning(value = "com.spring2.ioc.utils.LogUtil.reuse()",returning = "result")
	public static void logReturn(JoinPoint joinPoint,Object result) {
		String name=joinPoint.getSignature().getName();
		System.out.println("ValidateAspect "+name+ "�������صĽ����" + result);
	}
	@AfterThrowing(value = "com.spring2.ioc.utils.LogUtil.reuse()",throwing = "e")
	public static void logException(JoinPoint joinPoint,Exception e) {
		String name=joinPoint.getSignature().getName();
		System.out.println("ValidateAspect "+name+"�����������쳣���쳣��ϢΪ��"+e);
	}
	@After("com.spring2.ioc.utils.LogUtil.reuse()")
	public static void logEnd() {
		System.out.println("ValidateAspect aop�ĺ���֪ͨ����ִ��");
	}


}
