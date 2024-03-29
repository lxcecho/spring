/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.util.function.Supplier;

import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * Standalone application context, accepting <em>component classes</em> as input &mdash;
 * in particular {@link Configuration @Configuration}-annotated classes, but also plain
 * {@link org.springframework.stereotype.Component @Component} types and JSR-330 compliant
 * classes using {@code javax.inject} annotations.
 *
 * <p>Allows for registering classes one by one using {@link #register(Class...)}
 * as well as for classpath scanning using {@link #scan(String...)}.
 *
 * <p>In case of multiple {@code @Configuration} classes, {@link Bean @Bean} methods
 * defined in later classes will override those defined in earlier classes. This can
 * be leveraged to deliberately override certain bean definitions via an extra
 * {@code @Configuration} class.
 *
 * <p>See {@link Configuration @Configuration}'s javadoc for usage examples.
 *
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 3.0
 * @see #register
 * @see #scan
 * @see AnnotatedBeanDefinitionReader
 * @see ClassPathBeanDefinitionScanner
 * @see org.springframework.context.support.GenericXmlApplicationContext
 */
public class AnnotationConfigApplicationContext extends GenericApplicationContext implements AnnotationConfigRegistry {

	/**
	 * 保存一个读取注解的 Bean 定义读取器，并将其设置到容器中
	 */
	private final AnnotatedBeanDefinitionReader reader;

	/**
	 * 保存一个扫描指定类路径中注解 Bean 定义的扫描器，并将其设置到容器中
	 * 能够扫描 BeanDefinition，能够扫描一个类，并且转成 BeanDefinition
 	 */
	private final ClassPathBeanDefinitionScanner scanner;


	/**
	 * 默认构造函数，初始化一个空容器，容器不包含任何 Bean 信息，需要在稍后通过调用其 register() 方法注册配置类，
	 * 并调用 refresh() 方法刷新容器，触发容器对注解 Bean 的载入、解析和注册过程
	 *
	 * Create a new AnnotationConfigApplicationContext that needs to be populated
	 * through {@link #register} calls and then manually {@linkplain #refresh refreshed}.
	 */
	public AnnotationConfigApplicationContext() {
		// AnnotatedBeanDefinitiionReader 后续就是为了加载底层功能组件的后置处理器
		this.reader = new AnnotatedBeanDefinitionReader(this);
		// ClassPathBeanDefinitionScanner 扫描需要导入的所有 Bean 信息【准备环境变量等一些信息】
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}

	/**
	 * fixme refresh 的底层原理
	 * 1 在调用 AnnotationConfigApplicationContext 的构造方法之前，会调用父类的 GenericApplicationContext的 无参构造函数，会构造一个 BeanFactory ，为 DefaultListableBeanFactory。
	 *
	 * Create a new AnnotationConfigApplicationContext with the given DefaultListableBeanFactory.
	 * @param beanFactory the DefaultListableBeanFactory instance to use for this context
	 */
	public AnnotationConfigApplicationContext(DefaultListableBeanFactory beanFactory) {
		super(beanFactory);
		// 2 构造 AnnotatedBeanDefinitionReader（主要作用添加一些基础的 PostProcessor，
		// 同时可以通过 reader 进行 BeanDefinition 的注册），同时对 BeanFactory 进行设置和添加
		// PostProcessor（后置处理器）
		this.reader = new AnnotatedBeanDefinitionReader(this);
		// 3 构造 ClassPathBeanDefinitionScanner（主要作用可以用来扫描得到并注册 BeanDefinition），同时进行设置
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}

	/**
	 * 最常用的构造函数，通过将涉及到的配置类传递给该构造函数，以实现将相应配置类中的 Bean 自动注册到容器中
	 *
	 * Create a new AnnotationConfigApplicationContext, deriving bean definitions
	 * from the given component classes and automatically refreshing the context.
	 * @param componentClasses one or more component classes &mdash; for example,
	 * {@link Configuration @Configuration} classes
	 */
	public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
		this();
		// 关闭循环依赖
//		setAllowCircularReferences(false);
		// 向容器注册指定注解的 Bean
		register(componentClasses);
		// 容器完整刷新（创建出所有组件，组织好所有功能）
		refresh();
	}

	/**
	 * 该构造函数会自动扫描以给定的包及其子包下的所有类，并自动识别所有的 SpringBean，将其注册到容器中
	 *
	 * Create a new AnnotationConfigApplicationContext, scanning for components
	 * in the given packages, registering bean definitions for those components,
	 * and automatically refreshing the context.
	 * @param basePackages the packages to scan for component classes
	 */
	public AnnotationConfigApplicationContext(String... basePackages) {
		this();
		scan(basePackages);
		refresh();
	}


	/**
	 * Propagate the given custom {@code Environment} to the underlying
	 * {@link AnnotatedBeanDefinitionReader} and {@link ClassPathBeanDefinitionScanner}.
	 */
	@Override
	public void setEnvironment(ConfigurableEnvironment environment) {
		super.setEnvironment(environment);
		this.reader.setEnvironment(environment);
		this.scanner.setEnvironment(environment);
	}

	/**
	 * 为容器的注解 Bean 读取器和注解 Bean 扫描器设置 Bean 名称产生器
	 *
	 * Provide a custom {@link BeanNameGenerator} for use with {@link AnnotatedBeanDefinitionReader}
	 * and/or {@link ClassPathBeanDefinitionScanner}, if any.
	 * <p>Default is {@link AnnotationBeanNameGenerator}.
	 * <p>Any call to this method must occur prior to calls to {@link #register(Class...)}
	 * and/or {@link #scan(String...)}.
	 * @see AnnotatedBeanDefinitionReader#setBeanNameGenerator
	 * @see ClassPathBeanDefinitionScanner#setBeanNameGenerator
	 * @see AnnotationBeanNameGenerator
	 * @see FullyQualifiedAnnotationBeanNameGenerator
	 */
	public void setBeanNameGenerator(BeanNameGenerator beanNameGenerator) {
		this.reader.setBeanNameGenerator(beanNameGenerator);
		this.scanner.setBeanNameGenerator(beanNameGenerator);
		getBeanFactory().registerSingleton(
				AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR, beanNameGenerator);
	}

	/**
	 * 为容器的注解 Bean 读取器和注解 Bean 扫描器设置作用范围元信息解析器
	 *
	 * Set the {@link ScopeMetadataResolver} to use for registered component classes.
	 * <p>The default is an {@link AnnotationScopeMetadataResolver}.
	 * <p>Any call to this method must occur prior to calls to {@link #register(Class...)}
	 * and/or {@link #scan(String...)}.
	 */
	public void setScopeMetadataResolver(ScopeMetadataResolver scopeMetadataResolver) {
		this.reader.setScopeMetadataResolver(scopeMetadataResolver);
		this.scanner.setScopeMetadataResolver(scopeMetadataResolver);
	}


	//---------------------------------------------------------------------
	// Implementation of AnnotationConfigRegistry
	//---------------------------------------------------------------------

	/**
	 * 为容器注册一个要被处理的注解 Bean，新注册的 Bean，必须手动调用容器的 refresh() 方法刷新容器，触发容器对新注册的 Bean 的处理
	 *
	 * Register one or more component classes to be processed.
	 * <p>Note that {@link #refresh()} must be called in order for the context
	 * to fully process the new classes.
	 * @param componentClasses one or more component classes &mdash; for example,
	 * {@link Configuration @Configuration} classes
	 * @see #scan(String...)
	 * @see #refresh()
	 */
	@Override
	public void register(Class<?>... componentClasses) {
		Assert.notEmpty(componentClasses, "At least one component class must be specified");
		// 注册多个注解的 Bean 定义类
		this.reader.register(componentClasses);
	}

	/**
	 * 扫描指定包路径及其子包下的注解类，为了使新添加的类被处理，必须手动调用 refresh()方法刷新容器
	 * 
	 * Perform a scan within the specified base packages.
	 * <p>Note that {@link #refresh()} must be called in order for the context
	 * to fully process the new classes.
	 * @param basePackages the packages to scan for component classes
	 * @see #register(Class...)
	 * @see #refresh()
	 */
	@Override
	public void scan(String... basePackages) {
		Assert.notEmpty(basePackages, "At least one base package must be specified");
		this.scanner.scan(basePackages);
	}


	//---------------------------------------------------------------------
	// Adapt superclass registerBean calls to AnnotatedBeanDefinitionReader
	//---------------------------------------------------------------------

	@Override
	public <T> void registerBean(@Nullable String beanName, Class<T> beanClass,
			@Nullable Supplier<T> supplier, BeanDefinitionCustomizer... customizers) {

		this.reader.registerBean(beanClass, beanName, supplier, customizers);
	}

}
