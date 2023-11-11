package com.lxcecho.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否 linux 系统
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class LinuxCondition implements Condition {

	/**
	 * ConditionContext：判断条件能使用的上下文（环境）
	 * AnnotatedTypeMetadata：注释信息
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO 是否 linux 系统
		// 1、能获取到 ioc 使用的 beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		// 2、获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		// 3、获取当前环境信息
		Environment environment = context.getEnvironment();
		// 4、获取到 bean 定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();

		String property = environment.getProperty("os.name");

		// 可以判断容器中的 bean 注册情况，也可以给容器中注册 bean
		boolean definition = registry.containsBeanDefinition("person");
		if (property.contains("linux")) {
			return true;
		}

		return false;
	}
}
