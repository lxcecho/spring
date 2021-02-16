package com.xc.joy.ioc3.proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
       // System.out.println("beanName:"+beanName+"调用postProcessBeforeInstantiation");
        //生成动态代理
        if(beanClass==FoxProxy.class){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(new MyMethodInterceptor());
            FoxProxy proxy = (FoxProxy)enhancer.create();

            System.out.println("返回动态代理对象:"+proxy);
            return proxy;
        }

        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        //System.out.println("beanName:"+beanName+"调用postProcessAfterInstantiation");

//		if(beanName.equals("user")){
//			return false;
//		}

        return true;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("beanName:"+beanName+"调用postProcessBeforeInitialization");

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("beanName:"+beanName+"调用postProcessAfterInitialization");

        return bean;
    }
}
