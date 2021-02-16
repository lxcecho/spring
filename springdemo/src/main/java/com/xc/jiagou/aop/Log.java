package com.xc.jiagou.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Aspect
@Component
public class Log {


	@Pointcut("execution(* com.jiagouedu.service.*.*(..))")
	public void inWebLayer() {
		System.out.println("=======inWebLayer=====");
	}

	@Before("execution(* com.jiagouedu.service.*.*(..))")
	public void doAccessCheck() {
		System.out.println("=======doAccessCheck=====");
	}

}
