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
 * @author 明
 *验证多切面运行顺序
 */
@Component
@Aspect
public class ValidateAspect {
	
	@Before("com.spring2.ioc.utils.LogUtil.reuse()")
	public static void logStart(JoinPoint joinPoint) {
		Object[] args=joinPoint.getArgs();
		String name=joinPoint.getSignature().getName();
		System.out.println("ValidateAspect这是动态代理将要帮你执行方法");
		System.out.println("ValidateAspect使用了[" + name+ "]方法，传入的参数为[" + Arrays.asList(args) + "]");
	}
	@AfterReturning(value = "com.spring2.ioc.utils.LogUtil.reuse()",returning = "result")
	public static void logReturn(JoinPoint joinPoint,Object result) {
		String name=joinPoint.getSignature().getName();
		System.out.println("ValidateAspect "+name+ "方法返回的结果是" + result);
	}
	@AfterThrowing(value = "com.spring2.ioc.utils.LogUtil.reuse()",throwing = "e")
	public static void logException(JoinPoint joinPoint,Exception e) {
		String name=joinPoint.getSignature().getName();
		System.out.println("ValidateAspect "+name+"方法出现了异常，异常信息为："+e);
	}
	@After("com.spring2.ioc.utils.LogUtil.reuse()")
	public static void logEnd() {
		System.out.println("ValidateAspect aop的后置通知方法执行");
	}


}
