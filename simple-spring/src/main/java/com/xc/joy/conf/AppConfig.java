package com.xc.joy.conf;

import com.xc.joy.beans.Cat;
import com.xc.joy.beans.Person;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 07.04.2021
 * <p>
 * This is a configuration class.
 */
//@Import({Person.class, AppConfig.MyImportRegister.class})
@Configuration
@ComponentScan("com.xc.joy")
public class AppConfig {

	//	@Bean // @Bean 这种方式注册的Bean，@Lookup 不生效
	public Person person() {
		Person person = new Person();
		person.setName("lxcecho");
		return person;
	}

	/**
	 * BeanDefinitionRegistry：Bean 定义信息注册中心：图纸中心；
	 * 它里面都是 BeanDefinition
	 *
	 * <bean class="com.atguigu.spring.bean.Person" id="person">
	 * 		<property name="name" value="张三"/>
	 * 	</bean>
	 * 	 对应
	 * 	RootBeanDefinition
	 */
	static class MyImportRegister implements ImportBeanDefinitionRegistrar {
		@Override
		public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
											BeanDefinitionRegistry registry) {
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
		}
	}

}
