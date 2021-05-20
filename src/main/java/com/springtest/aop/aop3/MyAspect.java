package com.springtest.aop.aop3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author: admin
 * @Description: 切面类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.aop.aop3
 * @CreateTime: 2021-05-09 10:11:01
 */
@Aspect
public class MyAspect {

	@Pointcut("execution(* com..aop3.Calculate.*(..))")
	public void myPointCut() {
	}

	@Before("myPointCut()")
	public void before(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		Object[] args = joinPoint.getArgs();
		System.out.println("---- before前置通知,方法签名：" + signature + ",参数列表：" + Arrays.asList(args));
	}

	@After("myPointCut()")
	public void after(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("---- after后置通知,方法签名：" + signature);
	}

	//@AfterReturning(value = "myPointCut()", returning = "result")
	public void afterReturing(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("----正常返回通知afterReturing,方法名：" + methodName + ",返回结果：" + result);
	}

	//@AfterThrowing(value = "myPointCut()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("----异常返回通知afterThrowing,方法名：" + methodName + ",异常信息：" + exception);
	}

	/*@Around(value = "myPointCut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("----around,description:" + jp.toString());
		Object proceed = jp.proceed();
		return proceed;
	}*/

}
