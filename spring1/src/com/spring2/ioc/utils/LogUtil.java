package com.spring2.ioc.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogUtil {
	@Pointcut(value = "execution (public int com.spring2.ioc.demo.impl.MyCalculator.*(int, int))")
	public void reuse() {
		// TODO Auto-generated method stub

	}
	@Before("reuse()")
	public static void logStart(JoinPoint joinPoint) {
		Object[] args=joinPoint.getArgs();
		String name=joinPoint.getSignature().getName();
		System.out.println("���Ƕ�̬����Ҫ����ִ�з���");
		System.out.println("ʹ����[" + name+ "]����������Ĳ���Ϊ[" + Arrays.asList(args) + "]");
	}

	public static void logStart1(Method method, Object[] args) {
		System.out.println("���Ƕ�̬����Ҫ����ִ�з���");
		System.out.println("ʹ����[" + method.getName() + "]����������Ĳ���Ϊ[" + Arrays.asList(args) + "]");
	}

	@AfterReturning(value = "reuse()",returning = "result")
	public static void logReturn(JoinPoint joinPoint,Object result) {
		String name=joinPoint.getSignature().getName();
		System.out.println(name+ "�������صĽ����" + result);
	}

	public static void logReturn1(Method method, Object result) {
		System.out.println(method.getName() + "�������صĽ����" + result);
	}

	@AfterThrowing(value = "reuse()",throwing = "e")
	public static void logException(JoinPoint joinPoint,Exception e) {
		String name=joinPoint.getSignature().getName();
		System.out.println(name+"�����������쳣���쳣��ϢΪ��"+e);
	}

	public static void logException1(Exception e) {
		System.out.println(e.getCause());
	}

	@After("reuse()")
	public static void logEnd() {
		System.out.println("aop�ĺ���֪ͨ����ִ��");
	}

	public static void logEnd1(Method method) {
		System.out.println(method.getName() + "����ִ�������");
	}
	
	@Around("reuse()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		String name = pjp.getSignature().getName();
		Object proceed=null;
		try {
			System.out.println("Aroundʹ����[" + name+ "]����������Ĳ���Ϊ[" + Arrays.asList(args) + "]");
			//�������÷������Ŀ�귽�����ɣ��൱��method.invoke(obj,args)
			proceed = pjp.proceed(args);
			System.out.println("Around"+name+ "�������صĽ����" +proceed);
		} catch (Throwable e) {
			System.out.println("Around"+name+"�����������쳣���쳣��ϢΪ��"+e);
			//Ϊ�������֪���쳣����Ϣ��һ��ѡ����쳣�׳�ȥ
			throw new RuntimeException(e);
		}finally {
			System.out.println("Around aop�ĺ���֪ͨ����ִ��");
		}
		return proceed;
	}

}
