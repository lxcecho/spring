package com.xc.joy.ioc.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		BeanDefinition beanDefinition = new RootBeanDefinition(Cat.class);
		// beanDefinition.getPropertyValues().add("name","")
		// beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("");
		// beanDefinition.setBeanClassName("bat.ke.qq.com.bean.Fox");

		registry.registerBeanDefinition("cat",beanDefinition);

	}
}
