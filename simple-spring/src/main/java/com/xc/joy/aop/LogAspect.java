package com.xc.joy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lxcecho 909231497@qq.com
 * @since 03.05.2022
 * <p>
 * Spring 5 以后的顺序就一切正常：
 * 正常：前置通知--目标方法--返回通知--后置通知
 * 异常：前置通知--目标方法--异常通知--后置通知
 * try {
 * 前置通知
 * 目标方法
 * 返回通知
 * } catch (Exception e) {
 * 异常通知
 * } finally {
 * 后置通知
 * }
 *
 * 案例结果输出：
 * logStart(): {sayHello}, args: [{[lxcecho]}]
 * result: {Hello, lxcecho}
 * logReturn(): {sayHello}, args: [{[lxcecho]}], result: {Hello, lxcecho---7}
 * logEnd(): {sayHello}, args: [{[lxcecho]}]
 */
@Component // 切面也是容器中的组件
@Aspect // 说明这是切面
public class LogAspect {

	public LogAspect() {
		System.out.println("LogAspect...");
	}

	/**
	 * 前置通知
	 *
	 * @param joinPoint
	 */
	@Before("execution(* com.xc.joy.aop.HelloService.sayHello(..))")
	public void logStart(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("logStart(): {" + name + "}, args: [{" + Arrays.asList(joinPoint.getArgs()) + "}]");
	}

	/**
	 * 返回通知
	 *
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value = "execution(* com.xc.joy.aop.HelloService.sayHello(..))", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		String name = joinPoint.getSignature().getName();
		System.out.println("logReturn(): {" + name + "}, args: [{" + Arrays.asList(joinPoint.getArgs()) + "}], result: {" + result + "}");
	}

	/**
	 * 后置通知
	 *
	 * @param joinPoint
	 */
	@After("execution(* com.xc.joy.aop.HelloService.sayHello(..))")
	public void logEnd(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("logEnd(): {" + name + "}, args: [{" + Arrays.asList(joinPoint.getArgs()) + "}]");
	}

	/**
	 * 异常通知
	 */
	@AfterThrowing(value = "execution(* com.xc.joy.aop.HelloService.sayHello(..))", throwing = "e")
	public void logError(JoinPoint joinPoint, Exception e) {
		String name = joinPoint.getSignature().getName();
		System.out.println("logError(): {" + name + "}, args: [{" + Arrays.asList(joinPoint.getArgs()) + "}], exception: {" + e + "}");
	}

	// 环绕通知 @Around

}
