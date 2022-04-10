package com.xc.joy.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 14.06.2021
 * <p>
 * XXAware接口：帮我们装配 Spring 底层的一些组件
 * 1.Bean 的功能增强全部都是有 BeanPostProcessor + InitializingBean （合作来完成的）
 * 2.骚操作就是 BeanPostProcessor + InitializingBean
 * <p>
 * 思考：Autowired 是怎么完成的？？？
 * Person 为什么能把 ApplicationContext、MessageSource 当为自己的参数传进来？
 * - 通过实现接口的方式自动注入了 ApplicationContext、MessageSource。是由  BeanPostProcessor（Bean的后置处理器完成的）
 * -
 */
@Component
public class Person implements ApplicationContextAware, MessageSourceAware {

	//	@Autowired
	ApplicationContext context; // 可以拿到 ioc 容器 又或者 实现 ApplicationContextAware 接口
	MessageSource messageSource;

	private String name;

	//	@Autowired // 依赖的组件是多实例就不能 Autowired
	private Cat cat;

	// setApplicationContext 断点处，看 ApplicationContextAware 实现过程
	public Person() {
		System.out.println("person 创建...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lookup // 去容器中找，@Bean 的这种方式注册的 Person @Lookup 不生效
	public Cat getCat() {
		return cat;
	}

	@Autowired  // debug 自动装配的过程...
	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// 利用回调机制，把 IOC 容器传入
		this.context = applicationContext;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
