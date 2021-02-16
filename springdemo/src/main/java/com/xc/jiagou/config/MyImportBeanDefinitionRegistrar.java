package com.xc.jiagou.config;

import com.xc.jiagou.service.UserServiceImpl;
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
		BeanDefinition beanDefinition = new RootBeanDefinition(UserServiceImpl.class);
		registry.registerBeanDefinition("userServiceImpl",beanDefinition);
		((RootBeanDefinition) beanDefinition).setAutowireMode(2);
	}
}
