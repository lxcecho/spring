package com.xc.joy.ioc3.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class AopMethodInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("=====方法调用前======");
		Long  start = System.currentTimeMillis();
		Object result = invocation.proceed();
		System.out.println("=====方法调用后======");
		System.out.println("调用时间：" +(System.currentTimeMillis()-start));
		return result;
	}
}
