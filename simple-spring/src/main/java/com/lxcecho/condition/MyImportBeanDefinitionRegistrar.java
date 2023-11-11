package com.lxcecho.condition;

import com.lxcecho.entity.Cat;
import com.lxcecho.entity.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * BeanDefinitionRegistry：Bean 定义信息注册中心：图纸中心；它里面都是 BeanDefinition
	 * 把所有需要添加到容器中的 bean；调用 BeanDefinitionRegistry.registerBeanDefinition 手工注册进来
	 *
	 * @param importingClassMetadata annotation metadata of the importing class 当前类的注解信息
	 * @param registry               current bean definition registry BeanDefinition 注册类
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		/*
		 * <bean class="com.lxcecho.bean.Person" id="person">
		 * <property name="name" value="张三"/>
		 * </bean>
		 * 对应 RootBeanDefinition
		 */
		// BeanDefinition
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
		rootBeanDefinition.setBeanClass(Cat.class);
		// 可以声明自定义信息，包括我需要自动装配什么？

		// 实例提供者
//			rootBeanDefinition.setInstanceSupplier(()->new Cat());
		// 设置初始化方法
//			rootBeanDefinition.setInitMethodName("abc");

		// 可以设置 init 方法
//			rootBeanDefinition.setInitMethodName("aaa");

		// Spring 这个实例的类型，名字
		registry.registerBeanDefinition("tomCat", rootBeanDefinition);

		/*boolean definition = registry.containsBeanDefinition("com.lxcecho.entity.Red");
		boolean definition2 = registry.containsBeanDefinition("com.lxcecho.entity.Blue");
		if (definition && definition2) {
			// 指定 Bean 定义信息；（Bean 的类型，Bean。。。）
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			// 注册一个 Bean，指定 bean 名
			registry.registerBeanDefinition("rainBow", beanDefinition);
		}*/
	}
}
