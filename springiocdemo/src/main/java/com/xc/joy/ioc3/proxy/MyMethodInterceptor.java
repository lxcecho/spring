package com.xc.joy.ioc3.proxy;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object object = methodProxy.invokeSuper(o, objects);

        return object;
    }


}