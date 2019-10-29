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
		System.out.println("这是动态代理将要帮你执行方法");
		System.out.println("使用了[" + name+ "]方法，传入的参数为[" + Arrays.asList(args) + "]");
	}

	public static void logStart1(Method method, Object[] args) {
		System.out.println("这是动态代理将要帮你执行方法");
		System.out.println("使用了[" + method.getName() + "]方法，传入的参数为[" + Arrays.asList(args) + "]");
	}

	@AfterReturning(value = "reuse()",returning = "result")
	public static void logReturn(JoinPoint joinPoint,Object result) {
		String name=joinPoint.getSignature().getName();
		System.out.println(name+ "方法返回的结果是" + result);
	}

	public static void logReturn1(Method method, Object result) {
		System.out.println(method.getName() + "方法返回的结果是" + result);
	}

	@AfterThrowing(value = "reuse()",throwing = "e")
	public static void logException(JoinPoint joinPoint,Exception e) {
		String name=joinPoint.getSignature().getName();
		System.out.println(name+"方法出现了异常，异常信息为："+e);
	}

	public static void logException1(Exception e) {
		System.out.println(e.getCause());
	}

	@After("reuse()")
	public static void logEnd() {
		System.out.println("aop的后置通知方法执行");
	}

	public static void logEnd1(Method method) {
		System.out.println(method.getName() + "方法执行完成了");
	}
	
	@Around("reuse()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		String name = pjp.getSignature().getName();
		Object proceed=null;
		try {
			System.out.println("Around使用了[" + name+ "]方法，传入的参数为[" + Arrays.asList(args) + "]");
			//就是利用反射调用目标方法即可，相当于method.invoke(obj,args)
			proceed = pjp.proceed(args);
			System.out.println("Around"+name+ "方法返回的结果是" +proceed);
		} catch (Throwable e) {
			System.out.println("Around"+name+"方法出现了异常，异常信息为："+e);
			//为了让外界知道异常的信息，一般选择把异常抛出去
			throw new RuntimeException(e);
		}finally {
			System.out.println("Around aop的后置通知方法执行");
		}
		return proceed;
	}

}
