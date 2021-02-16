package com.xc.joy.ioc2.core;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {


		// map  key: userMapper bat.ke.qq.com.dao.UserMapper
		// for   scan

		BeanDefinition beanDefinition = new RootBeanDefinition(MyFactoryBean.class);
		// 拿到构造器
		beanDefinition.getConstructorArgumentValues()
				.addGenericArgumentValue("bat.ke.qq.com.dao.UserMapper");

		registry.registerBeanDefinition("userMapper",beanDefinition);


		BeanDefinition beanDefinition2 = new RootBeanDefinition(MyFactoryBean.class);
		// 拿到构造器
		beanDefinition2.getConstructorArgumentValues()
				.addGenericArgumentValue("bat.ke.qq.com.dao.AccountMapper");

		registry.registerBeanDefinition("accountMapper",beanDefinition2);
	}
}
