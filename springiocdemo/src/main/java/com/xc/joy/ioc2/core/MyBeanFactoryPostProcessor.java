package com.xc.joy.ioc2.core;

import com.xc.joy.ioc2.dao.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		// jdk 动态代理  UserMapper 接口
		UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				new Class<?>[]{UserMapper.class},
				new MyMapperProxy());

		beanFactory.registerSingleton("userMapper",userMapper);

	}
}
