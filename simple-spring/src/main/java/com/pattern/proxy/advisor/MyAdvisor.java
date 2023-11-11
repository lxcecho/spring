package com.pattern.proxy.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20:14 02-01-2023
 */
public class MyAdvisor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before invoke...");
        Object result = invocation.proceed();
        System.out.println("after invoke...");
        return result;
    }
}
