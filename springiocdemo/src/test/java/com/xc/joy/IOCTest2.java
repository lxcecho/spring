package com.xc.joy;

import com.xc.joy.ioc.config.AppConfig;
import com.xc.joy.ioc2.dao.AccountMapper;
import com.xc.joy.ioc2.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class IOCTest2 {
	@Test
	public void test() {
		//ioc容器
		ApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);

		// FactoryBean既可以是本身，也可以是特殊bean(getObject())
		//System.out.println(context.getBean("myFactoryBean"));
		//	System.out.println(context.getBean("&myFactoryBean"));

		// jdk动态代理
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		System.out.println(userMapper.query());

		userMapper.query();

		AccountMapper accountMapper = (AccountMapper) context.getBean("accountMapper");
		accountMapper.query();

		//  将userMapper交给spring管理

		// NoSuchBeanDefinitionException
		// BeanDefinition   承载bean属性的文件
		// BeanDefinitionMap   key: id/name  beanName  value: BeanDefinition

//		BeanFactory beanFactory = ((AnnotationConfigApplicationContext) context).getDefaultListableBeanFactory();
//		// 注册BeanDefinition
////		BeanDefinition beanDefinition = new RootBeanDefinition(Fox.class);
////		((DefaultListableBeanFactory) beanFactory)
////				.registerBeanDefinition("fox",beanDefinition);
//
//		// singletonObjects 单例对象池   Map :  key: beanName value:  bean对象 object
//		((DefaultListableBeanFactory) beanFactory)
//				.registerSingleton("fox",new Fox());
//
//		context.getBean("fox");

	}
}
